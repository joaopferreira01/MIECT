T = 1000;
keys = 10;
N = 1e5;

valores = randi([0,T - 1],keys, N);
sum = 0;
for a = 1:N
    if length(unique(valores(:,a))) ~= keys
        sum = sum + 1;
    end
end
fprintf("A) %.f%%", sum / N * 100);