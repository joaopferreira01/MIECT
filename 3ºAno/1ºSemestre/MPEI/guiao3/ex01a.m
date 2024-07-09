%Todas as semanas tem 2 aulas TPs da UCx às 9h00 quarta e sexta
%1 - nao ir a aula
%2 - ir a aula
Tij = [0.2 0.3
       0.8 0.7];
   
sum(Tij); % se der vetor de 1 temos matriz estocastica

x0 = [0 1]';

%x2 = Tijx1 = Tij(Tijx0) = Tij2x0
x2 = Tij^2*x0;
fprintf('1a) reposta = %f\n', x2(2));