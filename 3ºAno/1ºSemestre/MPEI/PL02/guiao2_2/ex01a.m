p = 0.5; % rate ter filho
N = 1e5; % experiencias
k = 2;   % filhos por familia

familias = rand(k, N);
rapazes = familias > 0.5;
numRapazes = sum(rapazes) >= 1;
numRapazes = sum(numRapazes) / N;
fprintf("A) %f%%", numRapazes * 100);