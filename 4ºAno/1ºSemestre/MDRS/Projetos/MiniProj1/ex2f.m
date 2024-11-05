lambda  = 1500;             % rate of arrival to the queue in pps
P = 100000;                 % Packets to be transmitted (stoping criteria)
C = 10;                     % Capacity of connection with 10Mbps
f = 1000000;                % Queue Size in Bytes
N = 20;                     % Times to run the simulation
n = [10 20 30 40];          % nr VoIP packets flows
B = 10^-5;                  % Bit error rate
alfa = 0.1;                 % 90% confidence interval for results

p64 = 0.19;
p110 = 0.23;
p1518 = 0.17;
p_other = 1 - (p64 + p110 + p1518);

%average packet size
PSize_average = p64 * 64 + p110 * 110 + p1518 * 1518 + p_other * mean(65:1517);

T_throughput = (lambda * PSize_average * 8) / 10^6; % Mbps


fprintf('Theoretical throughput: %.2f Mbps\n', T_throughput);

