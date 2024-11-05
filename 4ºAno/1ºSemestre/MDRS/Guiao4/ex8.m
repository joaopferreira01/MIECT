% Exercicio 8

%% 8.a)
clear all;
close all;
clc

load('InputData.mat')
nNodes= size(Nodes,1);
nLinks= size(Links,1);
nFlows= size(T,1);

% Computing up to k=6 shortest paths for all flows from 1 to nFlows:
k= 1;
sP= cell(1,nFlows);
nSP= zeros(1,nFlows);
for f=1:nFlows
    [shortestPath, totalCost] = kShortestPath(L,T(f,1),T(f,2),k);
    sP{f}= shortestPath;
    nSP(f)= totalCost;
    fprintf('Flow %d (%d -> %d): length = %d, Path = %s\n', f, T(f, 1), T(f, 2), totalCost, num2str(shortestPath{1}));
end
% sP{f}{i} is the i-th path of flow f
% nSP(f) is the number of paths of flow f


%% 8.b)
% Compute the link loads using the first (shortest) path of each flow:
sol= ones(1,nFlows);
Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);

% Determine the worst link load:
maxLoad= max(max(Loads(:,3:4)));

fprintf('Worst Link Load = %.1f\n', maxLoad);
for l = 1 : length(Loads)
    fprintf('{%d - %d}: %.2f \t %.2f\n', Loads(l, 1), Loads(l, 2), Loads(l, 3), Loads(l, 4));
end

%% 8.c)
% Computing k=10 shortest paths for flow f= 1
k= 4;
f= 1;
[shortestPath, totalCost] = kShortestPath(L,T(f,1),T(f,2),k);

% Visualizing the 6th path and its length:
for i = 1 : length(totalCost)
    fprintf('Path %d:  %s  (length= %d)\n',i , num2str(shortestPath{i}), totalCost(i));
end