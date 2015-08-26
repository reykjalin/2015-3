function [num, den] = parseCellValues(cellIn)
% A parser for changing the input of cell variables into usable arrays
% input 
%           cellIn = the input values in cell format, num and den
% output
%           num  = numerator of cellIn value, the first one
%           den = denumeratir cellIn value, second one


num = str2num(cellIn{1});
den = str2num(cellIn{2});