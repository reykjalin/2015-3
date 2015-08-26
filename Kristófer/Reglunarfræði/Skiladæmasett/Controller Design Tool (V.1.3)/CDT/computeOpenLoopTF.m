function out = computeOpenLoopTF()
% Computes the open loop transfer function

F = getGlobal_f;
[gNum, gDen] = getGlobal_g;
[cNum, cDen] = getGlobal_c;
[hNum, hDen] = getGlobal_h;

tf_g = tf(gNum, gDen);
tf_c = tf(cNum, cDen);
G = tf_g*tf_c;


out = F*G;