function forceCallBack1(handles, sysVal)
% 
%
% input 
%       handles = array of all handles in program
%       sysVal  = a binary number to recognize if open loop or closed loop
%                 0 = closed loop, 1 = open loop 
    content = cellstr(get(handles.drawMenu, 'String'));
    selected = content{get(handles.drawMenu, 'Value')};
    % Draw to the main axis;
    axes(handles.mainAxes);
    cla; axis on;
    % Fetch the current system
    if sysVal == 0
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

    elseif strcmp(selected, 'P-Z Plot')
        h = pzplot(sys);

    elseif strcmp(selected, 'Bode')
        if get(handles.setTFTypeButton, 'Value') == 0
            figTitle = 'Closed Loop Bode Diagram';
        else
            sys = computeOpenLoopTF();
            figTitle = 'Open Loop Bode Diagram';
        end
 
            bode(sys);
            title(figTitle)
            grid on

    elseif strcmp(selected, 'Freq. Magnitude')
        h = bodeplot(sys);
        setoptions(h,'FreqUnits','Hz', 'PhaseVisible', 'off')
        
    elseif strcmp(selected, 'Freq. Phase')
        h = bodeplot(sys);
        setoptions(h,'FreqUnits','Hz', 'MagVisible', 'off')
        
    elseif strcmp(selected, 'Root Locus')
        sys = computeOpenLoopTF();
        rlocus(sys);
        
    elseif strcmp(selected, 'Nichols')
        sys = computeOpenLoopTF();
        nichols(sys); 
    end
    grid on;
