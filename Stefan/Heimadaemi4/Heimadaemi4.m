%Timadaemi 4   
clear all; close all; clc;
%Daemi 1 - b)

%k = 1
sys1 = tf([120 6*120],[1 16 248 920]);
figure(2)
step(sys1);
title('K = 1');
info_k1 = stepinfo(sys1)

%k = 10
sys10 = tf([1200 6*1200],[1 16 1328 7400]);
figure(1)
step(sys10);
title('K = 10');
info_k10 = stepinfo(sys10)


%k = 50
sys50 = tf([6000 6*6000],[1 16 6138 36200]);
figure(3)
step(sys50);
title('K = 50');
info_k50 = stepinfo(sys50)

%% Daemi 2
clear all; close all; clc;
k1 = 4.57;

%k2 = 0
fall1 = tf([375*k1],[1 40 375 375*k1]);
figure(1)
step(fall1)
stepinfo(fall1)
pzplot(fall1)

%k1/k2 = 5
k2 = 5*k1;
fall2 = tf([375*k1 375*k2],[1 40 375 375*k1 375*k2]);
figure(2)
step(fall2)
damp(fall2)

close all; clear all; clc;
k1 = 4.6;
num = [375*k1 75*k1];
den = [1 40 375 375*k1 75*k1];

 sys = tf(num,den);
%  damp(sys)
 figure(1)
%  rlocus(sys)
 step(sys)
 stepinfo(sys)
 pzplot(sys)

 
%% SD3 - D2 a & b
close all; clear all; clc;
k1 = 4.57;  %k2 = 0;
num = [375*k1 0];
den = [1 40 375 375*k1 0];

sys = tf(num,den);
damp(sys)
figure(1)
rlocus(sys)
k2null = stepinfo(sys)
title('k2 = 0')

k1 = 4.6;  %k2 != 0;
num = [375*k1 75*k1];
den = [1 40 375 375*k1 75*k1];

sys = tf(num,den);
damp(sys)
figure(2)
rlocus(sys)
k2ekkinull = stepinfo(sys)
title('K2 != 0')