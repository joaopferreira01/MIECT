% P(Carlos|Erro) = P(CE) / P(E) = 0.5 * 0.001 / 0.001 = 0.5
N = 1e5;
numProgramas = 100;
programas = randi([1, numProgramas], numProgramas, N);

probs = programas <= 50;
probCarlos = sum(sum(probs)) * 0.001 / N;
fprintf("A) %f", probCarlos);