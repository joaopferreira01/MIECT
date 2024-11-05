% Exercicio 2

%% 2.b)
rate = 1500;                % rate of arrival to the queue in pps
P = 100000;                 % Packets to be transmitted (stoping criteria)
C = 10;                     % Capacity of connection with 10Mbps
f = 1000000;                % Queue Size in Bytes
N = 20;                     % Times to run the simulation
nVoips = [10 20 30 40];     % nr VoIP packets flows
b = 10^-5;                  % Bit error rate
alfa = 0.1;                 % 90% confidence interval for results

% Variables to store bar graph data
PLd_values = zeros(1, length(nVoips));
PLd_terms = zeros(1, length(nVoips));
PLv_values = zeros(1, length(nVoips));
PLv_terms = zeros(1, length(nVoips));

PLd = zeros(1, N);
PLv = zeros(1, N);

% Test all number of VoIP flows
for i = 1 : length(nVoips)
    % Run the simulator N times
    for it = 1:N
        [PLd(it), PLv(it), APDd(it), APDv(it), MPDd(it), MPDv(it), TT(it)] = Sim3A(rate, C, f, P, nVoips(i), b);
    end

    fprintf('For %d VoIP flows:\n', nVoips(i));
    
    alfa = 0.1;         %90% confidence interval

    media = mean(PLd);
    term = norminv(1-alfa/2)*sqrt(var(PLd)/N);
    fprintf('PacketLoss of data(%%)\t\t= %.2e +- %.2e\n', media, term);
    PLd_values(i) = media;
    PLd_terms(i) = term;

    media = mean(PLv);
    term = norminv(1-alfa/2)*sqrt(var(PLv)/N);
    fprintf('PacketLoss of VoIP(%%)\t\t= %.2e +- %.2e\n\n', media, term);
    PLv_values(i) = media;
    PLv_terms(i) = term;
end

figure(1);
hold on;
grid on;
bar(nVoips, PLd_values');                                   % Bar Graph
er = errorbar(nVoips, PLd_values', PLd_terms);              % Set the error bar
er.Color = [0 0 0];
er.LineStyle = 'none';
xlabel('Number of VoIP Flows')
ylabel('Avg. Data Packet Loss (%)')
title('Avg. Data Packet Loss vs Number of VoIP Flows');
hold off;

figure(2);
hold on;
grid on;
bar(nVoips, PLv_values');                                   % Bar Graph
er = errorbar(nVoips, PLv_values', PLv_terms);              % Set the error bar
er.Color = [0 0 0];
er.LineStyle = 'none';
xlabel('Number of VoIP Flows')
ylabel('Avg. VoIP Packet Loss (%)')
title('Avg. VoIP Packet Loss vs Number of VoIP Flows');
hold off;

