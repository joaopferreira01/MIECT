% Exercicio 2

%% 2.a)
rate = 1500;                % rate of arrival to the queue in pps
P = 100000;                 % Packets to be transmitted (stoping criteria)
C = 10;                     % Capacity of connection with 10Mbps
f = 1000000;                % Queue Size in Bytes
N = 20;                     % Times to run the simulation
nVoips = [10 20 30 40];     % nr VoIP packets flows
b = 10^-5;                  % Bit error rate
alfa = 0.1;                 % 90% confidence interval for results

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
    media = mean(PLd);
    term = norminv(1-alfa/2)*sqrt(var(PLd)/N);
    fprintf('PacketLoss of data(%%)\t\t= %.2e +- %.2e\n', media, term);
    media = mean(PLv);
    term = norminv(1-alfa/2)*sqrt(var(PLv)/N);
    fprintf('PacketLoss of VoIP(%%)\t\t= %.2e +- %.2e\n', media, term);
    
    media = mean(APDd);
    term = norminv(1-alfa/2)*sqrt(var(APDd)/N);
    fprintf('Av. Packet Delay of data (ms)\t= %.2e +- %.2e\n', media, term);
    media = mean(APDv);
    term = norminv(1-alfa/2)*sqrt(var(APDv)/N);
    fprintf('Av. Packet Delay of VoIP (ms)\t= %.2e +- %.2e\n', media, term);
    
    media = mean(MPDd);
    term = norminv(1-alfa/2)*sqrt(var(MPDd)/N);
    fprintf('Max. Packet Delay of data (ms)\t= %.2e +- %.2e\n', media, term);
    media = mean(MPDv);
    term = norminv(1-alfa/2)*sqrt(var(MPDv)/N);
    fprintf('Max. Packet Delay of VoIP (ms)\t= %.2e +- %.2e\n', media, term);
    
    media = mean(TT);
    term = norminv(1-alfa/2)*sqrt(var(TT)/N);
    fprintf('Throughput (Mbps)\t\t= %.2e +- %.2e\n\n', media, term);
end