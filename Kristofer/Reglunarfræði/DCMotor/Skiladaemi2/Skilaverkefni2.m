%a-lidur
clear all; close all; clc;

Rm = 2.3;   % Viðnám mótors
Kt = 0.02;  % Vægisstuðull mótors
Km = 0.02;  % Spanstuðull mótors
Jmt = 155*10^-6; % Snúningstregðuvægi
Vmax = 24;  % Mesta spenna maganara
Imax = 5;   % Mesti straumur magnara
Ka = 2.3;   % Spennumörgnun magnara

[timi, raunhradi, oskhradi, styrispenna] = textread('lidur_a.txt');

timi = timi - min(timi);

b = Kt*0.1./71.05; % Viðnám mótors og skífu

t063 = 0.63*(max(raunhradi) - min(raunhradi)) + min(raunhradi)

Sm = max(raunhradi)/max(styrispenna)

figure(1)
plot(timi,raunhradi,timi,oskhradi);
axis([min(timi) max(timi) 20 100])
legend('Raunhraði', 'Óskhraði', 'Location', 'NorthWest')
ylabel('Snúningshraði [rad/s]')
xlabel('Tími [sek]')
title('Mæling á svörun kerfisins án afturverkunar')



Tau = Rm*Jmt/(Rm*b+Kt*Km);
K = Km/(Ka*b+Kt*Km);

%% b-lidur
close all; clc;

[tb001, raunhradi_b001, oskhradi_b001, styrispenna_b001] = textread('lidur_b001.txt');
[tb004, raunhradi_b004, oskhradi_b004, styrispenna_b004] = textread('lidur_b004.txt');

tb001 = tb001 - min(tb001);
tb004 = tb004 - min(tb004);

raunhradi_b001 = raunhradi_b001;
raunhradi_b004 = raunhradi_b004;

figure(1)
subplot(1,2,1)
plot(tb001,raunhradi_b001,tb001,oskhradi_b001);
axis([min(tb001) max(tb001) 0 100])
legend('Raunhraði', 'Óskhraði', 'Location', 'NorthWest')
ylabel('Snúningshraði [rad/s]')
xlabel('Tími [sek]')
title('Mæling á svörun kerfisins með afturverkunar, Kp = 0.01')
subplot(1,2,2)
plot(tb004,raunhradi_b004,tb004,oskhradi_b004);
axis([min(tb004) max(tb004) 0 100])
legend('Raunhraði', 'Óskhraði', 'Location', 'NorthWest')
ylabel('Snúningshraði [rad/s]')
xlabel('Tími [sek]')
title('Mæling á svörun kerfisins með afturverkun, Kp = 0.04')

errorkp001 = max(oskhradi_b001)-max(raunhradi_b001) 
errorkp004 = max(oskhradi_b004)-max(raunhradi_b004) 


%% c-lidur
clear all; close all; clc;
[tkikp, raunhradikikp, oskhradikikp, styrispennakikp] = textread('Lidur3_kikp.txt');
[tki014, raunhradiki014, oskhradiki014, styrispennaki014] = textread('Lidur3_ki014.txt');

tkikp = tkikp - min(tkikp);
tki014 = tki014 - min(tki014);

figure(1)
subplot(1,2,1)
plot(tkikp,raunhradikikp,tkikp,oskhradikikp);
axis([min(tkikp) max(tkikp) 0 100])
legend('Raunhraði', 'Óskhraði', 'Location', 'NorthWest')
ylabel('Snúningshraði [rad/s]')
xlabel('Tími [sek]')
title('Mæling á svörun kerfisins með afturverkunar, Kp = Ki = 0.065')
subplot(1,2,2)
plot(tki014,raunhradiki014,tki014,oskhradiki014);
axis([min(tki014) max(tki014) 0 100])
legend('Raunhraði', 'Óskhraði', 'Location', 'NorthWest')
ylabel('Snúningshraði [rad/s]')
xlabel('Tími [sek]')
title('Mæling á svörun kerfisins með afturverkun, Ki = 0,14 og Kp = 0.065')

POkikp = (max(raunhradikikp)-70)/(70-30)*100
POki014 = (max(raunhradiki014)-70)/(70-30)*100

