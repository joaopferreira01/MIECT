lambda = 1500; % pps
C = 10; % Mbps
f = 10000; % bytes
P = 100000; % stopping criterion
n = [10, 20, 30, 40]; % VoIP flows

N = 20; % number of runs

media_PLdata = zeros(length(n), 1); % Average packet loss for Data
media_PLvoip = zeros(length(n), 1); % Average packet loss for VoIP
media_APDdata = zeros(length(n), 1); % Average Packet Delay Data
media_APDvoip = zeros(length(n), 1); % Average Packet Delay VoIP
erro_APDdata = zeros(length(n), 1); % Error for delays
erro_APDvoip = zeros(length(n), 1); % Error for delays
erro_PLdata = zeros(length(n), 1); % Error for packet losses
erro_PLvoip = zeros(length(n), 1); % Error for packet losses

alfa = 0.1; % Confidence interval

for k = 1:length(n)
    PLdata = zeros(1, N);
    PLvoip = zeros(1, N);
    APDdata = zeros(1, N);
    APDvoip = zeros(1, N);
  
    for i = 1:N
        [PLdata(i), PLvoip(i), APDdata(i), APDvoip(i)] = Sim4(lambda, C, f, P, n(k));
    end

    % Calculate average packet loss
    media_PLdata(k) = mean(PLdata);
    media_PLvoip(k) = mean(PLvoip);
    
    % Packet Loss error
    erro_PL(k) = norminv(1 - alfa/2) * sqrt(var(PLdata) / N);
    erro_PL(k) = norminv(1 - alfa/2) * sqrt(var(PLvoip) / N);
    
    % Calculate average packet delay
    media_APDdata(k) = mean(APDdata);
    media_APDvoip(k) = mean(APDvoip);
    
    % APD error
    erro_APDdata(k) = norminv(1 - alfa/2) * sqrt(var(APDdata) / N);
    erro_APDvoip(k) = norminv(1 - alfa/2) * sqrt(var(APDvoip) / N);
    
    % Output results to the console
    fprintf('For n = %d:\n', n(k));
    fprintf('PacketLoss of data(%%)\t= %.2e +- %.2e\n', PLdata_avg(k), erro_PLdata(k));
    fprintf('PacketLoss of VoIP(%%)\t= %.2e +- %.2e\n', PLvoip_avg(k), erro_PLvoip(k));
    fprintf('Av. Packet Delay of data (ms)\t= %.2e +- %.2e\n', APDdata_avg(k), erro_APDdata(k));
    fprintf('Av. Packet Delay of VoIP (ms)\t= %.2e +- %.2e\n\n', APDvoip_avg(k), erro_APDvoip(k));
end

% Prepare data for plotting: Combine averages and errors
average_values = [media_APDdata, media_APDvoip, media_PLdata, media_PLvoip]; % 4 columns for Data Delay, VoIP Delay, Data Loss, VoIP Loss

% Create a grouped bar chart
figure;
b = bar(n, average_values, 'grouped');
hold on;

% Customize the chart
grid on;
title("Average Packet Delay and Packet Loss");
xlabel("Number of VoIP Flows (n)");
ylabel("Value");
legend({'Avg. Delay Data', 'Avg. Delay VoIP', 'Avg. Packet Loss Data', 'Avg. Packet Loss VoIP'}, 'Location', 'northeastoutside');

hold off;

% TO-DO
% falta colocar no gráfico os confidence intervals


%   channel characteristics remain the same

% what shows:
% packet delay for data packets ver high comparing to voip  
% average voip delay increases a tiny little bit for each voip flow(0.46,0.48,0.50, 0.52)
% packet loss increases as voip flows increase, 
% but the data packet loss increases much quicker
%
%

% conclusions:
%
%
%
%
