%Valor esperado = somatorio de i=0 ate m de xi * P(X = xi)
E = 0;
for i=1 : 5
  E = E + (i-1) * pX(i);
end


fprintf("E[X]: %d\n",E);

%Variancia = E[X^2] - E^2[X]
E2 = 0;
for i=1 : 5
  E2 = E2 + (i-1)^2 * pX(i);
end

var = E2 - E^2;

fprintf("Var(X)= %d\n",var);

%Desvio padrao = sqrt(var(X))
dp = sqrt(var);
fprintf("σX = %d\n",dp);