% B --> pelo menos um dos filhos é rapaz
% A --> apenas um dos outros ser tambem rapaz
% queremos Probabilidade de A sabendo que B, ou seja, P(A | B)
% P(A | B) = P(A∩B) / P(B)
k = 5;   % filhos por familia

familias = rand(k, N);
rapazes = familias > 0.5;
numPeloMenosDoisRapazes = sum(rapazes) == 2; % P(A E B)
numPeloMenosDoisRapazes = sum(numPeloMenosDoisRapazes) / N;

numPeloMenosUmRapaz = sum(rapazes) >= 1; % P(B)
numPeloMenosUmRapaz = sum(numPeloMenosUmRapaz) / N;
fprintf("E) %f%%", numPeloMenosDoisRapazes / numPeloMenosUmRapaz * 100);
