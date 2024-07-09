%P(AB)
N = 1e5;        % Numero de experiencias
p = 0.5;        % Probababilidade de ter um filho rapaz
k = 2;          % Numero de filhos rapazes
n = 2;          % Numero total de filhos

filhos = rand(n, N) > p; 
rapazes = sum(filhos)==k;
probSimulacao = sum (rapazes)/N

%P(B)
k = 1;
primeiroRapaz = sum(filhos(1,:)==k);        %%1,: é a primeira fila, ou seja, os primeiros filhos
probSimulacaoB = sum(primeiroRapaz)/N

probSimFinal = probSimulacao/probSimulacaoB