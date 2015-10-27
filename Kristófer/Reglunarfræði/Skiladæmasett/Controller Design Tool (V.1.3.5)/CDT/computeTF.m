function out = computeTF()
% Compute the transfer function, using the feedback block diagram. 
% output
%        out = transfer function ready to be printed via latex.

% Get the set varables.
[fK, fNum, fDen] = getGlobal_f;
[gK, gNum, gDen] = getGlobal_g;
[cK, cNum, cDen] = getGlobal_c;
[hK, hNum, hDen] = getGlobal_h;

tf_f = tf(fK.*fNum, fDen);
tf_g = tf(gK.*gNum, gDen);
tf_c = tf(cK.*cNum, cDen);
G = tf_g*tf_c;

H = tf(hK.*hNum, hDen);

out = minreal(tf_f* G/(1+G*H));

