function varargout = ilaplace(varargin)
% ILAPLACE MATLAB code for ilaplace.fig
%      ILAPLACE, by itself, creates a new ILAPLACE or raises the existing
%      singleton*.
%
%      H = ILAPLACE returns the handle to a new ILAPLACE or the handle to
%      the existing singleton*.
%
%      ILAPLACE('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in ILAPLACE.M with the given input arguments.
%
%      ILAPLACE('Property','Value',...) creates a new ILAPLACE or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before ilaplace_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to ilaplace_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help ilaplace

% Last Modified by GUIDE v2.5 21-Jul-2015 16:30:48

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @ilaplace_OpeningFcn, ...
                   'gui_OutputFcn',  @ilaplace_OutputFcn, ...
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


% --- Executes just before ilaplace is made visible.
function ilaplace_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to ilaplace (see VARARGIN)

% Choose default command line output for ilaplace
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);
addpath global

% UIWAIT makes ilaplace wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = ilaplace_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in quitButton.
function quitButton_Callback(hObject, eventdata, handles)
close; 


% --- Executes during object creation, after setting all properties.
function ilapAxes_CreateFcn(hObject, eventdata, handles) 
    syms s;
    TF = computeTF();
    TF = symbolicTF(TF, s);
    TF = ilaplace(TF, s);
    TF = latex(TF);
    TF = ['$', TF, '$'];

    cla; axis off;
    text('Interpreter', 'Latex', 'string', TF,...
        'FontSize', 15)
    
    
    
