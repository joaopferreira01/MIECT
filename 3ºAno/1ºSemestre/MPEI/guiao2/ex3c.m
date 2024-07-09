keys = 50;
T = 100:100:1000;
N = 1e3;

sum = 0;
probs = [];
for i = 1:length(T)
    valores = randi([0,T(i) - 1],keys, N);
    sum = 0;
    for a = 1:N
        if length(unique(valores(:,a))) == keys
            sum = sum + 1;
        end
    end
    probs(end + 1) = sum / N * 100;
end

plot(probs, T)