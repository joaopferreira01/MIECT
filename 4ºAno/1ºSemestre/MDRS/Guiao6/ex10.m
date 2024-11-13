% Exercício 10

%% 10.a)
clear all
close all
clc

load('InputData2.mat')
nNodes= size(Nodes,1);
nLinks= size(Links,1);
nFlows= size(T,1);

MTBF = (450*365*24)./L;
A = MTBF./(MTBF + 24);
A(isnan(A))= 0;
A = A + eye(size(A));
Alog = -log(A);

k= 1;                           % Most available path
sP= cell(2,nFlows);
nSP= zeros(1,nFlows);
av_sum = 0;

for f=1:nFlows
    [shortestPath, totalCost] = kShortestPath(Alog,T(f,1),T(f,2),k);
    sP{1,f}= shortestPath;
    nSP(f)= length(totalCost);
    for i= 1:nSP(f)
        Aaux= Alog;
        path1= sP{1,f}{i};
        for j=2:length(path1)
            Aaux(path1(j),path1(j-1))= inf;
            Aaux(path1(j-1),path1(j))= inf;
        end
        [shortestPath, totalCost] = kShortestPath(Aaux,T(f,1),T(f,2),1);
        if ~isempty(shortestPath)
            sP{2,f}{i}= shortestPath{1};
        end
    end
    
    % calculate availabilty
    av = 1;
    % iterate through the first element of the path until the penultimate
    for node_idx = 1 : length(sP{1, f}{1}) - 1
        % first node of the link
        nodeA = sP{1, f}{1}(node_idx);
        % second node of the link
        nodeB = sP{1, f}{1}(node_idx + 1);
        % availability of the link between nodeA and nodeB
        av = av * A(nodeA, nodeB);
    end
    
    av_sum = av_sum + av;
    
    fprintf('Flow %d: Availability = %.7f - Path = %s\n', f, av, num2str(sP{1, f}{1}));
end