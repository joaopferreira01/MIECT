% Exercicio 2

%% 2.d)
rate = 1500;                % rate of arrival to the queue in pps
P = 100000;                 % Packets to be transmitted (stoping criteria)
C = 10;                     % Capacity of connection with 10Mbps
f = 1000000;                % Queue Size in Bytes
N = 20;                     % Times to run the simulation
nVoips = [10 20 30 40];     % nr VoIP packets flows
b = 10^-5;                  % Bit error rate
alfa = 0.1;                 % 90% confidence interval for results

% Variables to store bar graph data
MPDd_values = zeros(1, length(nVoips));
MPDd_terms = zeros(1, length(nVoips));
MPDv_values = zeros(1, length(nVoips));
MPDv_terms = zeros(1, length(nVoips));

PLd = zeros(1, N);
PLv = zeros(1, N);
APDd = zeros(1, N);
APDv = zeros(1, N);
MPDd = zeros(1, N);
MPDv = zeros(1, N);
TT = zeros(1, N);

% Test all number of VoIP flows
for i = 1 : length(nVoips)
    % Run the simulator N times
    for it = 1:N
        [PLd(it), PLv(it), APDd(it), APDv(it), MPDd(it), MPDv(it), TT(it)] = Sim3A(rate, C, f, P, nVoips(i), b);
    end

    fprintf('For %d VoIP flows:\n', nVoips(i));
    
    alfa = 0.1;         %90% confidence interval

    % Calculate Maximum Packet Delay for Data Packets
    media = mean(MPDd);
    term = norminv(1-alfa/2)*sqrt(var(MPDd)/N);
    fprintf('Max. Packet Delay of data (ms)\t= %.2e +- %.2e\n', media, term);
    MPDd_values(i) = media;
    MPDd_terms(i) = term;


    media = mean(MPDv);
    term = norminv(1-alfa/2)*sqrt(var(MPDv)/N);
    fprintf('Max. Packet Delay of VoIP (ms)\t= %.2e +- %.2e\n', media, term);
    MPDv_values(i) = media;
    MPDv_terms(i) = term;
end

figure(1);
hold on;
grid on;
bar(nVoips, MPDd_values');                                  % Bar Graph
ylim([0 7]);                                                % Set y axis values between 0 and 7
er = errorbar(nVoips, MPDd_values', MPDd_terms);            % Set the error bar
er.Color = [0 0 0];
er.LineStyle = 'none';
xlabel('Number of VoIP Flows')
ylabel('Maximum Data Packet Delay (ms)')
title('Maximum Data Packet Delay vs Number of VoIP Flows');
hold off;

figure(2);
hold on;
grid on;
bar(nVoips, MPDv_values');                                  % Bar Graph
ylim([0 7]);                                                % Set y axis values between 0 and 7
er = errorbar(nVoips, MPDv_values', MPDv_terms);            % Set the error bar
er.Color = [0 0 0];
er.LineStyle = 'none';
xlabel('Number of VoIP Flows')
ylabel('Maximum VoIP Packet Delay (ms)')
title('Maximum VoIP Packet Delay vs Number of VoIP Flows');
hold off;

