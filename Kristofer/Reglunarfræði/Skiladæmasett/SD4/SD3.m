%% SD3 - D1
close all; clear all; clc;

% K = 1
num = [120 720];
den = [1 16 28+100+120 120*6+200];
t1 = tf(num, den)
subplot(1,3,1)
step(t1);
stepinfo(t1)
legend('K = 1')

% K = 10
num = [1200 7200];
den = [1 16 1328 7400];
t10 = tf(num, den)
subplot(1,3,2)
step(t10);
stepinfo(t10)
legend('K = 10')

% K = 50
num = [120*50 6*120*50];
den = [1 16 100+28+120*50 200+6*120*50];
t50 = tf(num, den)
subplot(1,3,3)
step(t50);
stepinfo(t50)
legend('K = 50')

%% SD3 - D2a
close all; clear all; clc;
k1 = 4.6;
%k1 = 4.57;
num = [375*k1 75*k1];
den = [1 40 375 375*k1 75*k1];

%num = [375*k1 0];
%den = [1 40 375 375*k1 0];

sys = tf(num,den);
damp(sys)
figure(1)
rlocus(sys)
stepinfo(sys)

%% SD3 - 2b

stepinfo(sys);
step(sys);