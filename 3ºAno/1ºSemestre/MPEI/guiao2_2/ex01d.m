% B --> primeiro filho é rapaz
% A --> segundo filho é rapaz
% queremos Probabilidade de A sabendo que B, ou seja, P(A | B)
% P(A | B) = P(A∩B) / P(B)
k = 2;   % filhos por familia

familias = rand(k, N);
rapazes = familias > 0.5;
numPeloMenosDoisRapazes = sum(rapazes) == 2; % P(A E B)
numPeloMenosDoisRapazes = sum(numPeloMenosDoisRapazes) / N;

numPeloMenosUmRapaz = rapazes(1,:) == 1; % P(B)
numPeloMenosUmRapaz = sum(numPeloMenosUmRapaz) / N;
fprintf("D) %f%%", numPeloMenosDoisRapazes / numPeloMenosUmRapaz * 100);