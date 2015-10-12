clear all; close all; clc;
%To find the slope of the drainage
slope = textread('slope.txt');
T_innstillt = slope(:,1);
V_innstillt = slope(:,2);
T_raun = slope(:,3);
T_raun = T_raun - T_raun(1); %Gert til a� null stilla t�mann
V_raun = slope(:,4);

%Find best line
fit1 = polyfit(T_raun, V_raun,1)
val1 = polyval(fit1, T_raun);
x1 = linspace(min(T_raun), max(T_raun), length(val1));


plot(T_raun, V_raun)
hold on
plot(x1, V_raun)
xlabel('Tími [s]')
ylabel('Raun rúmmál tanksins [L]')
legend('Gögn úr forriti', 'Besta lína')
hold off

%% Find the slope of the pump
clear all; close all; clc;
slope = textread('dæla.txt');
T_innstillt = slope(:,1);
V_innstillt = slope(:,2);
T_raun = slope(:,3);
T_raun = T_raun - T_raun(1) %Gert til að null stilla tímann
V_raun = slope(:,4);

%find best line
fit1 = polyfit(T_raun, V_raun,1)
val1 = polyval(fit1, T_raun);
x1 = linspace(min(T_raun), max(T_raun), length(val1));

figure(1)
plot(T_raun, V_raun)
hold on
plot(x1, V_raun)
xlabel('Tími [s]')
ylabel('Raun rúmmál tanksins [L]')
legend('Gögn úr forriti', 'Besta lína')
hold off

%% Simulate the system with Kp 3, 5, 7, 10 with feedback
clear all; close all; clc;

Data = xlsread('Kp_test_feedback.xlsx');

Kp_3time = Data(:,1);
Kp_3data = Data(:,2);
Kp_5time = Data(:,3);
Kp_5data = Data(:,4);
Kp_7time = Data(:,5);
Kp_7data = Data(:,6);
Kp_10time = Data(:,7);
Kp_10data = Data(:,8);

figure(1);
subplot(1,2,1)
hold on
plot(Kp_3time, Kp_3data,'r');
plot(Kp_5time, Kp_5data,'b');
plot(Kp_7time, Kp_7data,'m');
plot(Kp_10time, Kp_10data,'g');
legend('Kp = 3', 'Kp = 5', 'Kp = 7', 'Kp = 10', 'Location', 'NorthWest')
%grid on
%set(gca, 'XColor', [0.3 0.3 0.3], 'YColor', [0.3 0.3 0.3])
%set(gca,'Color',[0 0 0]);
axis([0 50 0 3])
xlabel('Tími [s]')
ylabel('Hermt rúmmál [L]')
hold off

% Data from the system with feedback
%Collecting data from the system and fitting it with a 3rd order polynomial
[t3 o3 t3 v_kp3 null] = textread('Bak_3kp.txt');
t3 = t3 - t3(1);
fit3 = polyfit(t3, v_kp3,3);
val3 = polyval(fit3, t3);
x3 = linspace(min(t3), max(t3), length(val3));
[t5 o5 t5 v_kp5 null] = textread('Bak_5kp.txt');
t5 = t5 - t5(1);
fit5 = polyfit(t5, v_kp5,3);
val5 = polyval(fit5, t5);
x5 = linspace(min(t5), max(t5), length(val5));
[t7 o7 t7 v_kp7 null] = textread('Bak_7kp.txt');
t7 = t7 - t7(1);
fit7 = polyfit(t7, v_kp7,3);
val7 = polyval(fit7, t7);
x7 = linspace(min(t7), max(t7), length(val7));
[t10 o10 t10 v_kp10 null] = textread('Bak_10kp.txt');
t10 = t10 - t10(1);
fit10 = polyfit(t10, v_kp10,3);
val10 = polyval(fit10, t10);
x10 = linspace(min(t10), max(t10), length(val10));

%ploting the fitted data (actual data commented out)
subplot(1,2,2)
hold on
% plot(t3, v_kp3);
plot(x3, v_kp3,'r');
% plot(t5, v_kp5);
plot(x5, v_kp5,'b');
% plot(t7, v_kp7);
plot(x7, v_kp7,'m');
% plot(t10, v_kp10);
plot(x10, v_kp10,'g');
legend('Kp = 3', 'Kp = 5','Kp = 7', 'Kp =10','Location', 'NorthWest');
%grid on
%set(gca, 'XColor', [0.3 0.3 0.3], 'YColor', [0.3 0.3 0.3])
%set(gca,'Color',[0 0 0]);
axis([0 50 0 3])
xlabel('Tími [s]')
ylabel('Raun rúmmál [L]')





%% Data from the system without feedback
clear all; close all; clc;

%Collecting data from the system and fitting it with a 3rd order polynomial
[t3 o3 t3 v_kp3 null] = textread('No_bak_3kp.txt');
t3 = t3 - t3(1);
% v_kp3 = v_kp3 - min(v_kp3);
fit3 = polyfit(t3, v_kp3,3);
val3 = polyval(fit3, t3);
x3 = linspace(min(t3), max(t3), length(val3));
[t5 o5 t5 v_kp5 null] = textread('No_bak_5kp.txt');
t5 = t5 - t5(1);
fit5 = polyfit(t5, v_kp5,3);
val5 = polyval(fit5, t5);
x5 = linspace(min(t5), max(t5), length(val5));
[t7 o7 t7 v_kp7 null] = textread('No_bak_7kp.txt');
t7 = t7 - t7(1);
fit7 = polyfit(t7, v_kp7,3);
val7 = polyval(fit7, t7);
x7 = linspace(min(t7), max(t7), length(val7));
[t10 o10 t10 v_kp10 null] = textread('No_bak_10kp.txt');
t10 = t10 - t10(1);
fit10 = polyfit(t10, v_kp10,3);
val10 = polyval(fit10, t10);
x10 = linspace(min(t10), max(t10), length(val10));

%ploting the fitted data (actual data commented out)
figure(1)
hold on
% plot(t3, v_kp3);
plot(x3, v_kp3);
% plot(t5, v_kp5);
plot(x5, v_kp5);
% plot(t7, v_kp7);
plot(x7, v_kp7);
% plot(t10, v_kp10);
plot(x10, v_kp10);
legend('Kp = 3', 'Kp = 5','Kp = 7', 'Kp =10');
xlabel('Tími [s]')
ylabel('Raun rúmmál [L]')

%% Lidur 2.1 - Data from the system with kp = 10 and Ti = 1 and Ti = 0.5
clear all; close all; clc;

%Collecting data from the system and fitting it with a 3rd order polynomial
%Ti = 1
[t1 oskagildi t1, raungildi1 null] = textread('lidur2_1_ti1.txt');
t1 = t1 - min(t1);
fit1 = polyfit(t1, raungildi1,3);
val1 = polyval(fit1, t1);
x1 = linspace(min(t1), max(t1), length(val1));

%Ti = 0.5
[t2 oskagildi t2, raungildi_05 null] = textread('lidur2_1_ti0_5.txt');
t2 = t2 - min(t2);
fit2 = polyfit(t2, raungildi_05,3);
val2 = polyval(fit2, t2);
x2 = linspace(min(t2), max(t2), length(val2));


subplot(1,2,1)
plot(x1,raungildi1)
hold on
plot(x1(find(raungildi1 == max(raungildi1))), max(raungildi1), 'rs')
legend('Ti = 1', 'P.O. = 6.81%')
axis([0 120 0 3])
xlabel('Timi [s]')
ylabel('Raun rúmmál [L]')
%grid on

subplot(1,2,2)
plot(x2,raungildi_05)
hold on
plot(x2(find(raungildi_05 == max(raungildi_05))), max(raungildi_05), 'rs')
legend('Ti = 0.5', 'P.O. = 5.61%')
axis([0 120 0 3])
xlabel('Timi [s]')
ylabel('Raun rúmmál [L]')
%grid on

PO_1 = (max(raungildi1)-2)/2
PO_05 = (max(raungildi_05)-2)/2

%% Lidur 2.1 - Data from the system with kp = 15 and Ti = 10 and Td = 0.001
clear all; close all; clc;

%Collecting data from the system and fitting it with a 3rd order polynomial
[t oskagildi t raungildi null] = textread('lidur2_2.txt');
t = t - min(t);
fit1 = polyfit(t, raungildi,3);
val1 = polyval(fit1, t);
x1 = linspace(min(t), max(t), length(val1));

plot(x1,raungildi)
hold on
plot(x1, ones(length(val1)).*2, 'k--');
legend('Kp = 15, Ti = 10, Td = 0.001', 'Óskgildi')
axis([0 50 1.2 2.2])
xlabel('Timi [s]')
ylabel('Raun rúmmál [L]')
%grid on

PO = (max(raungildi)-2)/2


