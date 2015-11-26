function [k, num, den, c] = getValuesFromInput(strVal)
% Promts a question box asking for the input values of the 
% clicked box
% input
%       strVal = from parent function a string to show witch box is being
%                 checked
% output
%       k     =  magnification factor
%       num   =  numerator for the polynomial
%       den   =  denumerator for the polynomial
%       c     =  return 1 if cancel button is pressed


% Question setup
question = {'K-Gain', 'Numerator (num)', 'Denominator (den)'};
boxTitle = [strcat(strVal, ', box')];
numLines = 1;
[k, n, d] = getGlobalStrings(strVal);
c = 0;



def = {k, n, d};

% Some options set for dialogue window
opt.Resize = 'on';
opt.WindowStile = 'Normal';

% Dialogue window prompted, reurns cell value
cellVal = inputdlg(question, boxTitle, numLines, def, opt);

if isempty(cellVal)
   c = 1;
   k = [];
   num = [];
   den = [];
end

% Get return the values in array form, if not empty
if c == 0
    if ~isempty(cellVal)
        [k, num, den] = parseCellValues(cellVal);
        setGlobalStrings(cellVal{1}, cellVal{2}, cellVal{3}, strVal);
    else
        k = 1;num = 1; den = 1;
    end
end
