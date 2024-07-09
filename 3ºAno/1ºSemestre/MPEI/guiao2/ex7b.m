% P(Carlos|Erro) = P(CE) / P(E) = 0.5 * 0.001 / 0.001 = 0.5
% P(Bruno|Erro) = P(BE) / P(E) = 0.3 * 0.05 / 0.05 = 0.3
% P(Andre|Erro) = P(AE) / P(E) = 0.2 * 0.02 / 0.02 = 0.2
N = 1e5;
numProgramas = 100;
programas = rand(numProgramas, N);

probs = programas(1:50,:) <= 0.001;
probCarlos = sum(sum(probs)) / N;
fprintf("Probabilidade de ser o Carlos: %f%%", probCarlos);

probs = programas(81:100,:) <= 0.01;
probAndre = sum(sum(probs)) / N;
fprintf("Probabilidade de ser o André: %f%%", probAndre);

probs = programas(51:80,:) <= 0.05;
probBruno = sum(sum(probs)) / N;
fprintf("Probabilidade de ser o Bruno: %f%%", probBruno);