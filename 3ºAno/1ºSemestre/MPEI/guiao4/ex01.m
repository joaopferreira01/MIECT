%a
N = 10^5;
imin = 6;
imax = 20;
caracteres = ['A':'Z' 'a':'z'];
prob_caracteres = ones(1, length(caracteres)) / length(caracteres);
chaves = gera_chaves(N, imin, imax, caracteres, prob_caracteres)

%b
prob_caracteres = load('prob_pt.txt');
caracteres = ['a':'z'];
chaves = gera_chaves(N, imin, imax, caracteres, prob_caracteres);

