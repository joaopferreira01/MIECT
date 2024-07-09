%A -> Outro e, apenas mais um, filho tambem e rapaz
%B -> Pelo menos um dos filhos e rapaz
%Queremos: P(A|B) = P(AB)/P(B)
% Onde sabemos que P(AB) simboliza "Temos 2 filhos rapazes"

%P(AB)
N = 1e5;        % numero de experiencias
p = 0.5;        % probabilidade de um dos filhos ser rapaz
k = 2;          % numero de filhos rapazes
n = 5;          % numero total de filhos

filhos = rand(n, N) > p;
rapazes = sum(filhos)==k;
probSimulacao = sum(rapazes)/N;
% probabilidade de a familia ter apenas dois filhos rapazes

%P(B)
k = 1;
rapazes = sum(filhos)>=k;
probSimulacaoB = sum(rapazes)/N
% prob de haver pelo menos 1 filho rapaz
probSimFinal = probSimulacao/probSimulacaoB
