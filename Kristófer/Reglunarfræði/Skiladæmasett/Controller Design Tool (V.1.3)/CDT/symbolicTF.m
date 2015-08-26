function [symbTF] = symbolicTF(sys, symb)
% Changes a tf system to a symbolic system, to be able to print out
% various information
% input
%       sys = a tf(num, den) object
%       symb = a symbolic variable
% output
%       symbTF = a symbolic version of transfer system

[num, den] = tfdata(sys);
symbTF = poly2sym(cell2mat(num),symb)/(poly2sym(cell2mat(den),symb));
