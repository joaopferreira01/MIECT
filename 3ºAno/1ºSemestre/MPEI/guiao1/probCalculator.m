function res = probCalculator(p, lancamentos, carasPretendidas, experiencias);
lanc = rand(lancamentos, experiencias) > p;
sucess = sum(lanc);
carasPretendidas = sucess;
res = sum(sucess)/experiencias;
end