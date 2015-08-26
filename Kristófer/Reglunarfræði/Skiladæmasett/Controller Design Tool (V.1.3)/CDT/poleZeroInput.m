function [num, den] = poleZeroInput(strVal)
% A function to create a tf object given the poles and zeros of the
% system


% Open question dialog,
question = {'Zeros', 'Poles'};
boxTitle = [strcat(strVal, 'box')];
numLines = 1;
def = {'', ''};

% Some options set for dialogue window
opt.Resize = 'on';
opt.WindowStile = 'Normal';

cellVal = inputdlg(question, boxTitle, numLines, def, opt);


if ~isempty(cellVal)
    zeros = str2num(cellVal{1});
    poles = str2num(cellVal{2});

    %% Check if legal input, i.e. if imag have conjugates
    value = 0;
    if checkConjugate(zeros)
        if checkConjugate(poles)
            value = 1;
        end
    end

    if value == 1
        if ~isempty(zeros)
            num = p_zToPolynomial(zeros);
        else
            num = 1;
        end
        if ~isempty(poles)
            den = p_zToPolynomial(poles);
        else
            den = 1;
        end

    else
        num = 1; 
        den = 1;
        uiwait(warndlg(['Inputs wrong, make sure imaginary ', ...
                'numbers have conjugates'],...
            'WRONG INPUT WARNING'));
    end
else
    num = [];
    den = [];
end