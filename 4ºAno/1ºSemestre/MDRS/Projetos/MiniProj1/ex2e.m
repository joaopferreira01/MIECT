% Exercicio 2

%% 2.e)
rate = 1500;                % rate of arrival to the queue in pps
P = 100000;                 % Packets to be transmitted (stoping criteria)
C = 10;                     % Capacity of connection with 10Mbps
f = 1000000;                % Queue Size in Bytes
N = 1;                     % Times to run the simulation
nVoips = [10 20 30 40];     % nr VoIP packets flows
b = 10^-5;                  % Bit error rate
alfa = 0.1;                 % 90% confidence interval for results

% Inicializar arrays para armazenar os resultados
TT_means = zeros(1, length(nVoips));  % Média do Throughput para cada fluxo
TT_terms = zeros(1, length(nVoips));  % Termo de confiança para cada fluxo

% Variables to store the simulation results
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
    
    % Calculate Maximum Packet Delay for Data Packets
    TT_means(i) = mean(TT);   % Média do Throughput
    TT_terms(i) = norminv(1-alfa/2) * sqrt(var(TT) / N);  % Termo do intervalo de confiança
    
    % Exibir resultado por escrito
    fprintf('Throughput (Mbps)\t= %.2e +- %.2e\n', TT_means(i), TT_terms(i));
end

% Plot do gráfico de barras com valores para cada fluxo VoIP
figure;
hold on
grid on;
bar(nVoips, TT_means);  % Gráfico de barras com a média do Throughput
ylim([0 9])
er = errorbar(nVoips, TT_means, TT_terms);
er.Color = [0 0 0];
er.LineStyle = 'none';
xlabel('Number of VoIP Flows');
ylabel('Throughput (Mbps)');
title('Throughput vs Number of VoIP Flows');
hold off;
