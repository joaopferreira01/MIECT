% B --> um dos filhos é rapaz
% A --> o outro filho é rapaz
% queremos Probabilidade de A sabendo que B, ou seja, P(A | B)
% P(A | B) = P(A∩B) / P(B)
k = 2;   % filhos por familia

familias = rand(k, N);
rapazes = familias > 0.5;
numPeloMenosDoisRapazes = sum(rapazes) == 2; % P(A E B)
numPeloMenosDoisRapazes = sum(numPeloMenosDoisRapazes) / N;

numPeloMenosUmRapaz = sum(rapazes) >= 1; % P(B)
numPeloMenosUmRapaz = sum(numPeloMenosUmRapaz) / N;
fprintf("C) %f%%", numPeloMenosDoisRapazes / numPeloMenosUmRapaz * 100);