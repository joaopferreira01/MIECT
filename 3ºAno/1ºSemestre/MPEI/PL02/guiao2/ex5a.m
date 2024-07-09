% "A – a soma dos dois valores e igual a 9"

n = 2; % vezes lancadas
N = 1e5;
lancamentos = randi([1,6], n, N);
a = sum(lancamentos) == 9;
probA = sum(a) / N;
fprintf("a) A - %f%%", probA * 100);

% “B – o segundo valor é par”

b = lancamentos(2,:);
bIsEven = rem(b, 2) == 0;
probB = sum(bIsEven) / N;
fprintf("a) B - %f%%", probB * 100);

% “C – pelo menos um dos valores é igual a 5”

igualACinco = lancamentos == 5;
somaIgualACinco = sum(igualACinco);
c = somaIgualACinco >= 1;
probC = sum(c) / N;
fprintf("a) C - %f%%", probC * 100);

% “D – nenhum dos valores é igual a 1”

igualAUm = lancamentos ~= 1;
somaIgualAUm = sum(igualAUm);
d = somaIgualAUm == 2;
probD = sum(d) / N;
fprintf("a) D - %f%%", probD * 100);