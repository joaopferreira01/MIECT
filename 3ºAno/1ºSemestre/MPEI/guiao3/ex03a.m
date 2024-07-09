T = zeros(20);
for i = 1:20
    A = rand(20,1);
    A = A / sum(A);
    T(:,i) = A;
end
sum(sum(T)) / 20