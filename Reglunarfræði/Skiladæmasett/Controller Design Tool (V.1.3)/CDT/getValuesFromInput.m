function [num, den] = getValuesFromInput(strVal)
% Promts a question box asking for the input values of the 
% clicked box
% input
%       strVal = from parent function a string to show witch box is being
%                 checked
% output
%       num   =  numerator for the polynomial
%       den   =  denumerator for the polynomial
% 


% Question setup
question = {'Numerator (num)', 'Denominator (den)'};
boxTitle = [strcat(strVal, ', box')];
numLines = 1;
def = {'1', '1'};

% Some options set for dialogue window
opt.Resize = 'on';
opt.WindowStile = 'Normal';


% Dialogue window prompted, reurns cell value
cellVal = inputdlg(question, boxTitle, numLines, def, opt);

% Get return the values in array form, if not empty
if ~isempty(cellVal)
    [num, den] = parseCellValues(cellVal);
else
    num = -1; den = -1;
end
