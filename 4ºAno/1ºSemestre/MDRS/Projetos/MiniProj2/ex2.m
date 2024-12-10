%% 2.a

clear all
close all
clc

load('InputDataProject2.mat')
nNodes= size(Nodes,1);
nFlows= size(T,1);


v = 2*10^5;             % v = 2x10^5 km/sec
D = L/v;                % Propagation Delay matrix
anycastNodes = [3 10];

k= 6;

sP= cell(1, nFlows);
nSP= zeros(1, nFlows);
costs = zeros(1, nNodes);
uni_sP= cell(1, nNodes);
roundTripDelays = zeros(1, nFlows);
Taux = zeros(1,4);
%anycast services
%we should run kShortesPath for each node
for f = 1:nFlows
    if T(f, 1) == 1 || T(f, 1) == 2  % ---> [UNICAST SERVICE]
        [shortestPath, totalCost] = kShortestPath(D, T(f, 2), T(f, 3), k);

        if isempty(totalCost)
            % Handle cases where no paths are found
            fprintf("No paths found for flow %d\n", f);
            sP{f} = {}; % No paths available
            nSP(f) = 0;
            roundTripDelays(f) = Inf; % Set delay to a large value
        else
            % Store paths and costs safely
            nPaths = min(length(totalCost), k); % Use the smaller of k or the number of found paths
            sP{f} = shortestPath(1:nPaths);
            nSP(f) = nPaths;
            roundTripDelays(f) = 2 * totalCost(1) * 1000; % Use the shortest path's delay
        end
    elseif T(f, 1) == 3 % ---> ANYCAST SERVICE
        if ismember(T(f, 2), anycastNodes)
            sP{f} = {T(f, 2)};
            roundTripDelays(f) = 0; % No delay for local access
        else
            Taux(f, :) = T(f, 2:5);
            minCost = Inf;
            bestPath = {};
            for acNode = anycastNodes
                [shortestPath, totalCost] = kShortestPath(D, T(f, 2), acNode, k);

                if ~isempty(totalCost) && totalCost(1) < minCost
                    minCost = totalCost(1); % Update minimum cost
                    bestPath = shortestPath{1}; % Update best path
                end
            end
            sP{f} = {bestPath}; % Store the best path
            roundTripDelays(f) = 2 * minCost * 1000; % Round-trip delay
        end
    end
end

t= tic;
timeLimit= 30;
bestLoad= inf;
contador= 0;
somador= 0;
alfa =1;
while toc(t) < timeLimit
    sol = zeros(1,nFlows);

    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    [sol, load] = greedyRandomizedStrategy(nNodes, Links, T, sP, nSP);

    [sol, load] = MultiStartHillClimbing(nNodes, Links, T, sP, nSP, sol, load);

    if load<bestLoad
        bestSol= sol;
        bestLoad= load;
        bestLoads= Loads;
        bestLoadTime = toc(t);
    end
    contador= contador + 1;
    somador= somador + load;
end

% Separate delays by service type
unicastDelays1 = roundTripDelays(T(:, 1) == 1);
unicastDelays2 = roundTripDelays(T(:, 1) == 2);
anycastDelays = roundTripDelays(T(:, 1) == 3);

% Output results
fprintf("-------------------------------------------------------------------------\n");
fprintf("Anycast nodes = %s\n", num2str(anycastNodes));

% Worst and average round-trip delays for each service
fprintf("Worst round-trip delay (unicast service 1): %.2f ms\n", max(unicastDelays1));
fprintf("Average round-trip delay (unicast service 1): %.2f ms\n", mean(unicastDelays1));
fprintf("Worst round-trip delay (unicast service 2): %.2f ms\n", max(unicastDelays2));
fprintf("Average round-trip delay (unicast service 2): %.2f ms\n", mean(unicastDelays2));
fprintf("Worst round-trip delay (anycast service): %.2f ms\n", max(anycastDelays));
fprintf("Average round-trip delay (anycast service): %.2f ms\n", mean(anycastDelays));

% Worst link load of the network
fprintf("Worst link load of the network: %.2f\n", bestLoad);

fprintf("Performance parameters:\n");
fprintf("Total cycles run: %d\n", contador);
fprintf("Time to best solution: %.2f seconds\n", bestLoadTime);
fprintf("-------------------------------------------------------------------------\n");