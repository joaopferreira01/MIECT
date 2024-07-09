keys = 0:T-1;
N = 1e2;

sum = 0;
probs = [];
for i = 1:T
    valores = randi([0,T - 1],keys(i), N);
    sum = 0;
    for a = 1:N
        if length(unique(valores(:,a))) ~= keys(i)
            sum = sum + 1;
        end
    end
    probs(end + 1) = sum / N * 100;
end

plot(probs, keys) % quantos mais resultados forem possiveis, mais duplicates irao existir
