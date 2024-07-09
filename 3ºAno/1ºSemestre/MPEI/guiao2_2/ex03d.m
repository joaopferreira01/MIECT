pXTeorica = zeros(1,5);
n = 4;
p = 1/2;

for i=1 : 5
  k = i-1;
  nCk = factorial(n)/(factorial(k) * factorial(n-k));
  pXTeorica(i) = nCk * p^k * (1-p)^(n-k);
end 

subplot(2,2,[3,4]);
x = 0:4;
stem(x,pXTeorica);

axis([-0.5 4.5 0 0.5]);
xlabel('x');
ylabel('pX');
title("Grafico Funcao de Probabilidade de X (Teorico)");