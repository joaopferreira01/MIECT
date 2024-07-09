iteracoes = [2 5 10 100];
y = zeros(1,4);

for i = 1:length(iteracoes) % a testar para cada num de iteraçao
    z = T^iteracoes(i); % nessa iteraçao, fazer o T^it 
    y(i) = z(20); % checkar a prob do estado 20
end

fprintf('prob de estar no estado 20 apos 2 iteracoes é %.5f \n', y(1)*100);
fprintf('prob de estar no estado 20 apos 5 iteracoes é %.5f \n', y(2)*100);
fprintf('prob de estar no estado 20 apos 10 iteracoes é %.5f \n', y(3)*100);
fprintf('prob de estar no estado 20 apos 100 iteracoes é %.5f \n', y(4)*100);

%Nao interessa qual a matriz random de transicao de estados, o valor para o
%estado 20 após n iteracoes são semelhantes uns aos outros