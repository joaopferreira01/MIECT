% Exercicio 1

%% 1.c)
% Probability for different packet data sizes from 64, 110, and 1518 Bytes
prob_left = (1 - (0.19 + 0.23 + 0.17)) / ((109 - 65 + 1) + (1517 - 111 + 1));
ber_values = [1e-6, 1e-4];      % Bit error rates to test
ploss_ber = zeros(1, length(ber_values));  % Packet loss probabilities

% Loop over each bit error rate
for i = 1:length(ber_values)
    ber = ber_values(i);
    
    % Calculate loss probability for each packet size
    for packetSize = 64:1518
        no_error_prob = (1 - ber)^(packetSize * 8); % Probability of no bit error

        % Check specific packet sizes with predefined probabilities
        if packetSize == 64
            ploss_ber(i) = ploss_ber(i) + (1 - no_error_prob) * 0.19;
        elseif packetSize == 110
            ploss_ber(i) = ploss_ber(i) + (1 - no_error_prob) * 0.23;
        elseif packetSize == 1518
            ploss_ber(i) = ploss_ber(i) + (1 - no_error_prob) * 0.17;
        else
            ploss_ber(i) = ploss_ber(i) + (1 - no_error_prob) * prob_left;
        end
    end
end

% Convert results to percentage
ploss_ber = ploss_ber * 100;

% Display the results
fprintf(['Considering that the bit error rate is the only factor causing packet loss,\n' ...
    'the theoretical packet loss (%%) for a bit error rate of 10^-6 is: %.4f %%\n' ...
    'and for a bit error rate of 10^-4 is: %.4f %%\n'], ploss_ber(1), ploss_ber(2));




%%