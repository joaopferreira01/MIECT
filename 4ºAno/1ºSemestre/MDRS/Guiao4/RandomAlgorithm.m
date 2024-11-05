function [bestSol,bestObjective,noCycles,avObjective] = RandomAlgorithm(nNodes,Links,T,sP,nSP,timeLimit)
    t= tic;
    nFlows= size(T,1);
    bestObjective= inf;
    noCycles= 0;
    aux= 0;
    while toc(t) < timeLimit
        sol= zeros(1,nFlows);
        for f= 1:nFlows
            sol(f)= randi(nSP(f));
        end
        Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
        load= max(max(Loads(:,3:4)));
        noCycles= noCycles+1;
        aux= aux+load;
        if load<bestObjective
            bestSol= sol;
            bestObjective= load;
        end
    end
    avObjective= aux/noCycles;
end