%Funcao massa de probabilidade de X:
pX = zeros(1, 5);
s = 0:4;
N = 1e5; %Numero de experiencias
p = 0.5; %Probabilidade de sair coroa
n = 4;   %numero de lancamentos por experiencia

for i=1 : 5
  k = i-1;
  pX(i) = fMassaProb(N,p,k,n);
end
stem(s,pX), xlabel('x'), ylabel('px(x)'), title('Funcao massa de probabilidade');