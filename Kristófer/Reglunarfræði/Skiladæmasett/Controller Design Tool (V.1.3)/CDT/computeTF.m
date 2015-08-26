function out = computeTF()
% Compute the transfer function, using the feedback block diagram. 
% output
%        out = transfer function ready to be printed via latex.

% Get the set varables.
F = getGlobal_f;
[gNum, gDen] = getGlobal_g;
[cNum, cDen] = getGlobal_c;
[hNum, hDen] = getGlobal_h;

tf_g = tf(gNum, gDen);
tf_c = tf(cNum, cDen);
G = tf_g*tf_c;

H = tf(hNum, hDen);

out = minreal(F* G/(1+G*H));

