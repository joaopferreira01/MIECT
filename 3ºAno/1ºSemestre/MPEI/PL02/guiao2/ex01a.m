N= 1e5;     % número de famílias
p = 0.5;    % probabilidade de ser rapaz
k = 1;      % número de filhos
n = 2;      % número total de filhos
familias = rand(n,N) > p;       % Cada coluna é uma família com dois filhos
                                % Resultado é 0 ou 1
rapazes = sum(familias) >= k;
probSimulacao = sum(rapazes)/N