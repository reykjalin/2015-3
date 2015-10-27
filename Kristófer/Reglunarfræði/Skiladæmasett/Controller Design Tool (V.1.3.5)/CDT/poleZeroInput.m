function [k, num, den, c] = poleZeroInput(strVal)
% A function to create a tf object given the poles and zeros of the
% system


% Open question dialog,
c = 0;
question = {'K-Gain','Zeros', 'Poles'};
boxTitle = [strcat(strVal, 'box')];
numLines = 1;
[k, n, d] = getGlobalStrings(strVal);
def = {k, n, d};

% Some options set for dialogue window
opt.Resize = 'on';
opt.WindowStile = 'Normal';

cellVal = inputdlg(question, boxTitle, numLines, def, opt);

if isempty(cellVal)
    k = [];
    num = [];
    den = [];
    c = 1;
elseif ~isempty(cellVal)
    k = str2num(cellVal{1});
    zeros = str2num(cellVal{2});
    poles = str2num(cellVal{3});
    setGlobalStrings(cellVal{1}, cellVal{2}, cellVal{3}, strVal);
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
        k = 1;
        num = 1; 
        den = 1;
        uiwait(warndlg(['Inputs wrong, make sure imaginary ', ...
                'numbers have conjugates'],...
            'WRONG INPUT WARNING'));
    end
else
    k = [];
    num = [];
    den = [];
end