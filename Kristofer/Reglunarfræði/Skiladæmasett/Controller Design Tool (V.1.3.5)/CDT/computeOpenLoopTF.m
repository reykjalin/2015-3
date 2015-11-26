function out = computeOpenLoopTF()
% Computes the open loop transfer function

[fK, fNum, fDen] = getGlobal_f;
[gK, gNum, gDen] = getGlobal_g;
[cK, cNum, cDen] = getGlobal_c;

tf_f = tf(fK.*fNum, fDen);
tf_g = tf(gK.*gNum, gDen);
tf_c = tf(cK.*cNum, cDen);
G = tf_g*tf_c;


out = minreal(tf_f*G);
