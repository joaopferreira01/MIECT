% Exercicio 12

%% ex12.a)
clear all
close all
clc

load('InputData3.mat')
nNodes= size(Nodes,1);
nFlows= size(T,1);


v = 2*10^5;             % v = 2x10^5 km/sec
D = L/v;                % Propagation Delay matrix
anycastNodes = [3 5];

k= 1;

sP= cell(1, nFlows);
nSP= zeros(1, nFlows);
costs = zeros(1, nNodes);
uni_sP= cell(1, nNodes);
roundTripDelays = zeros(1, nFlows);
Taux = zeros(1,4);
%anycast services
%we should run kShortesPath for each node
for f=1:nFlows
    if T(f,1) == 1 % ---> [UNICAST SERVICE]
        [shortestPath, totalCost] = kShortestPath(D,T(f,2),T(f,3),k);
        sP{f}= shortestPath;
        nSP(f)= length(totalCost);
        Taux(f,:) = T(f,2:5);
        roundTripDelays(f) = 2 * totalCost * 1000; % ---> Ida e Volta (*2) e converter para ms (*1000)
    elseif T(f,1) == 2 % ---> ANYCAST SERVICE
        if ismember(T(f,2), anycastNodes)
            sP{f} = {T(f,2)};
        else
            Taux(f,:) = T(f,2:5);
            minCost = inf;
            for acNode = anycastNodes
                [shortestPath, totalCost] = kShortestPath(D, T(f,2), acNode, k);
                if totalCost < minCost
                    minCost = totalCost;          % Update custo min
                    sP{f} = shortestPath;         % Guardar
                end
            end
            % Calculate round-trip delay (ms)
            roundTripDelays(f) = 2 * minCost * 1000; % ---> Ida e Volta (*2) e converter para ms (*1000)
        end
    end
end

% Compute round-trip delays
unicastDelays = roundTripDelays(T(:,1) == 1);
anycastDelays = roundTripDelays(T(:,1) == 2);

fprintf("Anycast nodes = %s\n", num2str(anycastNodes));
fprintf("Worst round-trip delay (unicast service) %.2f ms \n", max(unicastDelays));
fprintf("Average round-trip delay (unicast service) %.2f \n", mean(unicastDelays));
fprintf("Worst round-trip delay (anycast service) %.2f ms \n", max(anycastDelays));
fprintf("Average round-trip delay (anycast service) %.2f ms \n", mean(anycastDelays));

%% 12.b - Link Loads for 12.a Solution

% Compute the link loads using the first (shortest) path of each flow:
sol=ones(1,nFlows);

Loads= calculateLinkLoads(nNodes,Links,Taux,sP,sol);

% Determine the worst link load:
maxLoad= max(max(Loads(:,3:4)));

fprintf('Worst Link Load = %.1f\n', maxLoad);
for l = 1 : length(Loads)
    fprintf('{%d - %d}: %.2f \t %.2f\n', Loads(l, 1), Loads(l, 2), Loads(l, 3), Loads(l, 4));
end

%% 12.c


load('InputData3.mat')
nNodes = size(Nodes, 1);
nFlows = size(T, 1);
nLinks = size(Links, 1);


v = 2 * 10^5;             % v = 2x10^5 km/sec
D = L / v;                % Propagation Delay matrix
anycastNodes = {[1 2], [1 3], [1 4], [1 5], [1 6], [1 7], [1 8], [1 9], [1 10], [1 11], ...
    [2 3], [2 4], [2 5], [2 6], [2 7], [2 8], [2 9], [2 10], [2 11], ...
    [3 4], [3 5], [3 6], [3 7], [3 8], [3 9], [3 10], [3 11], ...
    [4 5], [4 6], [4 7], [4 8], [4 9], [4 10], [4 11], ...
    [5 6], [5 7], [5 8], [5 9], [5 10], [5 11], ...
    [6 7], [6 8], [6 9], [6 10], [6 11], ...
    [7 8], [7 9], [7 10], [7 11], ...
    [8 9], [8 10], [8 11], ...
    [9 10], [9 11], ...
    [10 11]};

k = 1;

sP = cell(1, nFlows);
nSP = zeros(1, nFlows);
costs = zeros(1, nNodes);
uni_sP = cell(1, nNodes);
roundTripDelays = zeros(1, nFlows);
Taux = zeros(1, 4);

% Variables to track the best combination and corresponding delays
minWorstLoad = inf;  % Initialize with a large number
bestAnycastNodes = [];  % Store the best anycast node combination
bestUnicastDelays = [];  % Store unicast delays for the best combination
bestAnycastDelays = [];  % Store anycast delays for the best combination
% Anycast services
for i = 1:length(anycastNodes)
    for f = 1:nFlows
        if T(f, 1) == 1 % ---> [UNICAST SERVICE]
            [shortestPath, totalCost] = kShortestPath(D, T(f, 2), T(f, 3), k);
            sP{f} = shortestPath;
            nSP(f) = length(totalCost);
            Taux(f, :) = T(f, 2:5);
            roundTripDelays(f) = 2 * totalCost * 1000; % ---> ida e volta (*2) e converter para ms (*1000)
        elseif T(f, 1) == 2 % ---> ANYCAST SERVICE
            if ismember(T(f, 2), anycastNodes{i})
                sP{f} = {T(f, 2)};
                roundTripDelays(f) = 0;
            else
                Taux(f, :) = T(f, 2:5);
                minCost = inf;
                for acNode = anycastNodes{i}
                    [shortestPath, totalCost] = kShortestPath(D, T(f, 2), acNode, k);
                    if totalCost < minCost
                        minCost = totalCost;          % Update custo min
                        sP{f} = shortestPath;         % Guardar
                    end
                end
                % Calculate round-trip delay (ms)
                roundTripDelays(f) = 2 * minCost * 1000; % ---> ida e volta (*2) e converter para ms (*1000)

            end
        end
    end
    % Compute round-trip delays
    unicastDelays = roundTripDelays(T(:, 1) == 1);
    anycastDelays = roundTripDelays(T(:, 1) == 2);


    sol = ones(1, nFlows);

    [rows, cols] = size(T);

    Loads = calculateLinkLoads(nNodes, Links, Taux, sP, sol);

    % Determine the worst link load:
    maxLoad = max(max(Loads(:, 3:4)));

    % Check if the current combination has the lowest worst link load
    if maxLoad < minWorstLoad
        minWorstLoad = maxLoad;   % Update the minimum worst link load
        bestAnycastNodes = anycastNodes{i};  % Store the best combination
        bestUnicastDelays = unicastDelays;  % Store the unicast delays for the best combination
        bestAnycastDelays = anycastDelays;  % Store the anycast delays for the best combination
    end
end

% Display the best combination of anycast nodes and the corresponding delays
fprintf("Anycast nodes = %s\n", num2str(bestAnycastNodes));
fprintf("Worst link load = %.2f Gbps\n", minWorstLoad);
fprintf("Worst round-trip delay (unicast service) %.2f ms \n", max(bestUnicastDelays));
fprintf("Average round-trip delay (unicast service) %.2f ms \n", mean(bestUnicastDelays));
fprintf("Worst round-trip delay (anycast service) %.2f ms \n", max(bestAnycastDelays));
fprintf("Average round-trip delay (anycast service) %.2f ms \n", mean(bestAnycastDelays));

%% 12.d


load('InputData3.mat')
nNodes = size(Nodes, 1);
nFlows = size(T, 1);
nLinks = size(Links, 1);


v = 2 * 10^5;             % v = 2x10^5 km/sec
D = L / v;                % Propagation Delay matrix
anycastNodes = {[1 2], [1 3], [1 4], [1 5], [1 6], [1 7], [1 8], [1 9], [1 10], [1 11], ...
    [2 3], [2 4], [2 5], [2 6], [2 7], [2 8], [2 9], [2 10], [2 11], ...
    [3 4], [3 5], [3 6], [3 7], [3 8], [3 9], [3 10], [3 11], ...
    [4 5], [4 6], [4 7], [4 8], [4 9], [4 10], [4 11], ...
    [5 6], [5 7], [5 8], [5 9], [5 10], [5 11], ...
    [6 7], [6 8], [6 9], [6 10], [6 11], ...
    [7 8], [7 9], [7 10], [7 11], ...
    [8 9], [8 10], [8 11], ...
    [9 10], [9 11], ...
    [10 11]};

k = 1;

sP = cell(1, nFlows);
nSP = zeros(1, nFlows);
costs = zeros(1, nNodes);
uni_sP = cell(1, nNodes);
roundTripDelays = zeros(1, nFlows);
Taux = zeros(1, 4);

% Variables to track the best combination and corresponding delays
minWorstLoad = inf;  % Initialize with a large number
bestAnycastNodes = [];  % Store the best anycast node combination
bestUnicastDelays = [];  % Store unicast delays for the best combination
bestAnycastDelays = [];  % Store anycast delays for the best combination
% Anycast services
for i = 1:length(anycastNodes)
    for f = 1:nFlows
        if T(f, 1) == 1 % ---> [UNICAST SERVICE]
            [shortestPath, totalCost] = kShortestPath(D, T(f, 2), T(f, 3), k);
            sP{f} = shortestPath;
            nSP(f) = length(totalCost);
            Taux(f, :) = T(f, 2:5);
            roundTripDelays(f) = 2 * totalCost * 1000; % ---> ida e volta (*2) e converter para ms (*1000)
        elseif T(f, 1) == 2 % ---> ANYCAST SERVICE
            if ismember(T(f, 2), anycastNodes{i})
                sP{f} = {T(f, 2)};
                roundTripDelays(f) = 0;
            else
                Taux(f, :) = T(f, 2:5);
                minCost = inf;
                for acNode = anycastNodes{i}
                    [shortestPath, totalCost] = kShortestPath(D, T(f, 2), acNode, k);
                    if totalCost < minCost
                        minCost = totalCost;          % Update custo min
                        sP{f} = shortestPath;         % Guardar
                    end
                end
                % Calculate round-trip delay (ms)
                roundTripDelays(f) = 2 * minCost * 1000; % ---> ida e volta (*2) e converter para ms (*1000)

            end
        end
    end
    % Compute round-trip delays
    unicastDelays = roundTripDelays(T(:, 1) == 1);
    anycastDelays = roundTripDelays(T(:, 1) == 2);


    sol = ones(1, nFlows);

    [rows, cols] = size(T);

    % Determine the worst round-trip delay for anycast service:
    maxAnycastDelay = max(anycastDelays);

    % Check if the current combination has the lowest worst anycast delay
    if maxAnycastDelay < minWorstLoad
        minWorstLoad = maxAnycastDelay;   % Update the minimum worst anycast delay
        bestAnycastNodes = anycastNodes{i};  % Store the best combination
        bestUnicastDelays = unicastDelays;  % Store the unicast delays for the best combination
        bestAnycastDelays = anycastDelays;  % Store the anycast delays for the best combination
    end

end

% Display the best combination of anycast nodes and the corresponding delays
fprintf("Anycast nodes = %s\n", num2str(bestAnycastNodes));
fprintf("Worst link load = %.2f Gbps\n", minWorstLoad);
fprintf("Worst round-trip delay (unicast service) %.2f ms \n", max(bestUnicastDelays));
fprintf("Average round-trip delay (unicast service) %.2f ms \n", mean(bestUnicastDelays));
fprintf("Worst round-trip delay (anycast service) %.2f ms \n", max(bestAnycastDelays));
fprintf("Average round-trip delay (anycast service) %.2f ms \n", mean(bestAnycastDelays));


