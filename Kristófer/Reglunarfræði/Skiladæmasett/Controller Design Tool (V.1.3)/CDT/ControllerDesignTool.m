function varargout = ControllerDesignTool(varargin)
%       Author: David Orn Johannesson, davidj11@ru.is
%               Reykjavik University,   2015
%               
% 

    % CONTROLLERDESIGNTOOL MATLAB code for ControllerDesignTool.fig
    %      CONTROLLERDESIGNTOOL, by itself, creates a new CONTROLLERDESIGNTOOL or raises the existing
    %      singleton*.
    %
    %      H = CONTROLLERDESIGNTOOL returns the handle to a new CONTROLLERDESIGNTOOL or the handle to
    %      the existing singleton*.
    %
    %      CONTROLLERDESIGNTOOL('CALLBACK',hObject,eventData,handles,...) calls the local
    %      function named CALLBACK in CONTROLLERDESIGNTOOL.M with the given input arguments.
    %
    %      CONTROLLERDESIGNTOOL('Property','Value',...) creates a new CONTROLLERDESIGNTOOL or raises the
    %      existing singleton*.  Starting from the left, property value pairs are
    %      applied to the GUI before ControllerDesignTool_OpeningFcn gets called.  An
    %      unrecognized property name or invalid value makes property application
    %      stop.  All inputs are passed to ControllerDesignTool_OpeningFcn via varargin.
    %
    %      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
    %      instance to run (singleton)".
    %
    % See also: GUIDE, GUIDATA, GUIHANDLES

    % Edit the above text to modify the response to help ControllerDesignTool

    % Last Modified by GUIDE v2.5 13-Aug-2015 14:51:00

    % Begin initialization code - DO NOT EDIT
    gui_Singleton = 1;
    gui_State = struct('gui_Name',       mfilename, ...
        'gui_Singleton',  gui_Singleton, ...
        'gui_OpeningFcn', @ControllerDesignTool_OpeningFcn, ...
        'gui_OutputFcn',  @ControllerDesignTool_OutputFcn, ...
        'gui_LayoutFcn',  [] , ...
        'gui_Callback',   []);
    if nargin && ischar(varargin{1})
        gui_State.gui_Callback = str2func(varargin{1});
    end

    if nargout
        [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
    else
        gui_mainfcn(gui_State, varargin{:});
    end
    % End initialization code - DO NOT EDIT


% --- Executes just before ControllerDesignTool is made visible.
function ControllerDesignTool_OpeningFcn(hObject, eventdata, handles, varargin)
    % This function has no output args, see OutputFcn.
    % hObject    handle to figure
    % eventdata  reserved - to be defined in a future version of MATLAB
    % handles    structure with handles and user data (see GUIDATA)
    % varargin   command line arguments to ControllerDesignTool (see VARARGIN)

    % Choose default command line output for ControllerDesignTool
    handles.output = hObject;
    % Update handles structure
    guidata(hObject, handles);
    % UIWAIT makes ControllerDesignTool wait for user response (see UIRESUME)
    % uiwait(handles.figure1);
    % Showing figure for background
    axes(handles.axes1);
    %% Change figure later
    imshow('blockDiagram.jpg');
    %% Open the global function file
    startupFunction();
    changeText(handles);
    
    % Clean main axes. 
    axes(handles.mainAxes);
    cla; axis off;
    
    % Set up iniformation about input type as polynomial
    axes(handles.inputTypeAxis);
    cla; axis off;    
    addpath CDT/global;
    setGlobal_inputType(1);
    set(handles.inputTypeButton, 'Value', 1);
    text('Interpreter', 'Latex', 'string', 'Polynomial',...
        'FontSize', 15);
    movegui(gcf,'center')
    

% --- Outputs from this function are returned to the command line.
function varargout = ControllerDesignTool_OutputFcn(hObject, eventdata, handles)
    % varargout  cell array for returning output args (see VARARGOUT);
    % hObject    handle to figure
    % eventdata  reserved - to be defined in a future version of MATLAB
    % handles    structure with handles and user data (see GUIDATA)

    % Get default command line output from handles structur
    varargout{1} = handles.output;






%% Butons described
% --- Executes on button press in fButton.
function fButton_Callback(hObject, eventdata, handles)
    % Special case question, single input
    % Question setup
    question = {'Set scalar factor'};
    boxTitle = ['F box'];
    numLines = 1;
    def = {'1'};
    % Some options set for dialogue window
    opt.Resize = 'on';
    opt.WindowStile = 'Normal';
    % Dialogue window prompted, reurns cell value
    cellVal = inputdlg(question, boxTitle, numLines, def, opt);
    if ~isempty(cellVal)
        f_Val = str2num(cellVal{1});
        setGlobal_f(f_Val);
    end
    changeText(handles)


% --- Executes on button press in cButton.
function cButton_Callback(hObject, eventdata, handles)
    inputTypeVal = getGlobal_inputType();
    
    
    if inputTypeVal == 1 % polynomial value input
        [num, den] = getValuesFromInput('C(s)');
    else %Pole zero value input
        [num, den] = poleZeroInput('C(s)');
    end
    if num ~= -1 | den ~= -1   
        setGlobal_c(num, den);
        changeText(handles);
    end
% --- Executes on button press in gButton.
function gButton_Callback(hObject, eventdata, handles)
    inputTypeVal = getGlobal_inputType();
    
    if inputTypeVal == 1 % Polynomial input type
        [num, den] = getValuesFromInput('G(s)');
    else % Pole/zero input type
        [num, den] = poleZeroInput('G(s)');
    end
    if num ~= -1 | den ~= -1   
            setGlobal_g(num, den);
            changeText(handles);
    end
    
% --- Executes on button press in hButton.
function hButton_Callback(hObject, eventdata, handles)
    inputTypeVal = getGlobal_inputType();
    
    if inputTypeVal == 1   % Polynomial input value
        [num, den] = getValuesFromInput('H(s)');
    else    % Pole/Zero input type
        [num, den] = poleZeroInput('H(s)');
    end
    if num ~= -1 | den ~= -1   
        setGlobal_h(num, den);
        changeText(handles);
    end
    
%%      Change the text values of axes
% Text names
% axes handle names
% fAxes, cAxes, gAxes, hAxes, tfaxes, zeroAxes, poleAxis;
% ilaplace handle name: ilapAxes
function changeText(handles)
    syms s;
    format shortg;
    % setting the fontsize
    fontZ = 15;
    % Setting the f values
    axes(handles.fAxes);
    cla
    axis off;
    text('Interpreter', 'Latex', 'string', num2str(getGlobal_f()),...
        'FontSize', fontZ);

    %% Setting the C values
    [cNum, cDen] = getGlobal_c();
    axes(handles.cAxes);
    cla;
    axis off
    % Set up the string for latex format
    c_sys = tf(cNum, cDen);
    C = symbolicTF(c_sys, s);
    C = latex(C);
    C = ['$', C, '$'];
    text('Interpreter', 'Latex', 'string', C,...
        'FontSize', fontZ);

    %% Setting the G values
    [gNum, gDen] = getGlobal_g();
    axes(handles.gAxes);
    cla;
    axis off
    % Set up the string for latex format
    g_sys = tf(gNum, gDen);
    G = symbolicTF(g_sys, s);
    G = latex(G);
    G = ['$', G, '$'];
    text('Interpreter', 'Latex', 'string', G,...
        'FontSize', fontZ);


    %% Setting the H values
    [hNum, hDen] = getGlobal_h();
    axes(handles.hAxes);
    cla;
    axis off
    % Set up the string for latex format
    h_sys = tf(hNum, hDen);
    H = symbolicTF(h_sys, s);
    H = latex(H);
    H = ['$', H, '$'];
    text('Interpreter', 'Latex', 'string', H,...
        'FontSize', fontZ);

    % Calculate and print out the TF 
    checkTFVal = get(handles.setTFTypeButton, 'Value');
    
    if checkTFVal  == 0
        TFtotal = computeTF();
    else
        TFtotal = computeOpenLoopTF();
    end
    
    TF = latexTFMaker(TFtotal);

    axes(handles.tfAxes);
    cla;
    axis off;
    text('Interpreter', 'Latex', 'string', TF,...
        'FontSize', fontZ);

    % Get the poles and zeros and print to axis
    [z, p, ~] = zpkdata(TFtotal);
    z = double(z{1}); p = double(p{1});
    axes(handles.zeroAxis);
    cla; axis off; 
    for zi =1:length(z)
        string = pzString(z);
        text('Interpreter', 'Latex', 'string', string,...
        'FontSize', fontZ);
    end
   
    axes(handles.poleAxis);
    cla; axis off;
    for pi =1:length(p)
        string = pzString(p);
        text('Interpreter', 'Latex', 'string', string,...
        'FontSize', fontZ);
    end
   
    forceCallBack1(handles, checkTFVal);


    
function axes1_CreateFcn(hObject, eventdata, handles)
% Old sins


% --- Executes on button press in quitButton.
function quitButton_Callback(hObject, eventdata, handles)
    % Quits the program, and prints out author info.
    close all; clear all; clc; 
    disp('Controller Design Tool [CDT]')
    disp('Author: David Orn Johannesson')
    disp('davidj11@hr.is')
    disp('Reykjavik University')
    disp('2015')


% --- Executes on button press in resetButton.
function resetButton_Callback(hObject, eventdata, handles)
% Resets the global variables and the transfer function, 
    resetGlobals();
    changeText(handles);


% --- Executes on button press in ilaplaceButton.
function ilaplaceButton_Callback(hObject, eventdata, handles)
    run('ilaplace.m');


% --- Executes on button press in drawButton.
function drawButton_Callback(hObject, eventdata, handles)
    drawFigure(hObject, eventdata, handles, 1);


%% Draw menu setup, only contains information
function drawMenu_Callback(hObject, eventdata, handles)

function drawMenu_CreateFcn(hObject, eventdata, handles)
    if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
        set(hObject,'BackgroundColor','white');
    end



function timeBox_Callback(hObject, eventdata, handles)


% --- Executes during object creation, after setting all properties.
function timeBox_CreateFcn(hObject, eventdata, handles)

    if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
        set(hObject,'BackgroundColor','white');
    end


%%      Design tool buttons
% --- Executes on button press in systoolButton.
function systoolButton_Callback(hObject, eventdata, handles)
    if get(handles.setTFTypeButton, 'Value') == 0
        sys = computeTF();
    else
        sys = computeOpenLoopTF();
    end
    sisotool(sys);
    
% --- Executes on button press in rlocButton.
function rlocButton_Callback(hObject, eventdata, handles)
    if get(handles.setTFTypeButton, 'Value') == 0
        sys = computeTF();
    else
        sys = computeOpenLoopTF();
    end
    sisotool('rlocus', sys);

% --- Executes on button press in bodeButton.
function bodeButton_Callback(hObject, eventdata, handles)
    if get(handles.setTFTypeButton, 'Value') == 0
        sys = computeTF();
    else
        sys = computeOpenLoopTF();
    end
    sisotool('bode', sys);
% Hint: get(hObject,'Value') returns toggle state of bodeButton

% --- Executes on button press in setTFTypeButton.
function setTFTypeButton_Callback(hObject, eventdata, handles)
        state = get(hObject, 'Value');
        if state == get(hObject, 'Max') % button not clicked
            set(hObject, 'String' ,'Open Loop');
            set(handles.text14, 'String', 'Open Loop Transfer Function')
            changeText(handles);
        elseif state == get(hObject, 'Min')
            set(hObject, 'String', 'Closed Loop');
            set(handles.text14, 'String', 'Closed Loop Transfer Function')
            changeText(handles);
        end
            


function inputTypeButton_Callback(hObject, eventdata, handles)
    state = get(hObject, 'Value');
    setGlobal_inputType(state);
    axes(handles.inputTypeAxis);
    cla; axis off;
    if state == get(hObject, 'Max') %Original state, not pushed
       text('Interpreter', 'Latex', 'string', 'Polynomial',...
        'FontSize', 15); 
    elseif state == get(hObject, 'Min')
        text('Interpreter', 'Latex', 'string', 'Pole/Zero',...
        'FontSize', 15);
    end


% --------------------------------------------------------------------
function saveMenu_Callback(hObject, eventdata, handles)
% hObject    handle to saveMenu (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
% function saveFigure_Callback(hObject, eventdata, handles)

% function helpMenu_Callback(hObject, eventdata, handles)
%     % Runs a preset help menu.
%     programHelpMenu();
    



% --------------------------------------------------------------------
function saveSYStoWorkspace_Callback(hObject, eventdata, handles)
    sys = computeTF;
    save('sys.mat', 'sys', '-mat')
    S = {'System saved to current workspace:','"' ,[pwd,'/sys.mat'], '"',...
        'Saved as as sys.mat'};
    uiwait(warndlg(S, 'System Saved'))
% hObject    handle to saveSYStoWorkspace (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function helpMenu_Callback(hObject, eventdata, handles)
    addpath CDT/Help/
    open('CDT/Help/helpManual.pdf');
% hObject    handle to helpMenu (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes when figure1 is resized.
function figure1_SizeChangedFcn(hObject, eventdata, handles)
% hObject    handle to figure1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in createFigButton.
function createFigButton_Callback(hObject, eventdata, handles)
    drawFigure(hObject, eventdata, handles, 2)
    

function drawFigure(hObject, eventdata, handles, val)
    content = cellstr(get(handles.drawMenu, 'String'));
    selected = content{get(handles.drawMenu, 'Value')};

    % Draw to the main axis;
    if val == 1
        axes(handles.mainAxes);
        cla; axis on;
    elseif val == 2
        figure();
    end
    % Fetch the current system
    if get(handles.setTFTypeButton, 'Value') == 0
        sys = computeTF();
    else
        sys = computeOpenLoopTF();
    end
    
    % Get the set time value for picture
    T = cellstr(get(handles.timeBox, 'String'));
    T = str2double(T{1});
    
    % Drawing selected picture. Selected from the pop-up menu
    if strcmp(selected, 'Time Domain - Impulse')
        impulse(sys, T);
        
    elseif strcmp(selected, 'Time Domain - Step')
        step(sys, T);

    elseif strcmp(selected, 'Time Domain - Ramp');
        s = tf('s');
        step(sys/s, T);
        
    elseif strcmp(selected, 'Freq. Magnitude')
        h = bodeplot(sys);
        setoptions(h,'FreqUnits','Hz', 'PhaseVisible', 'off')
        
    elseif strcmp(selected, 'Freq. Phase')
        h = bodeplot(sys);
        setoptions(h,'FreqUnits','Hz', 'MagVisible', 'off')
        
    elseif strcmp(selected, 'Root Locus')
        rlocus(sys);
        
    elseif strcmp(selected, 'Nichols')
        nichols(sys);
        
    end
    
 
% --- Executes during object creation, after setting all properties.
function mainAxes_CreateFcn(hObject, eventdata, handles)
% hObject    handle to mainAxes (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate mainAxes
