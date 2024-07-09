T = [0 0 0 0 0 0 0
    0.5 0 0 0 0 0 0
    0.5 0 0 0 0 0 0
    0 1/3 0.6 0.4 0.5 0.3 0
    0 1/3 0 0.1 0.2 0 0
    0 1/3 0.4 0.3 0 0.3 0
    0 0 0 0.2 0.3 0.4 0];

N = 1e5;
cell_array = cell(N, 1);

for i = 1:N
    cell_array(i) = {crawl(T, 1, 7)};
end

lengths = cellfun('length', cell_array);
cont = 0;
cont2 = 0;

for i = 1:N
    b = cell_array{i}; 

    if lengths(i) == 8 && b(2) == 2 && b(7) == 6
        cont = cont + 1;
    end

    if lengths(i) == 8 && b(2) == 2
        cont2 = cont2 + 1;
    end

end

fprintf('P(7 digitos iniciada por 91 e terminada em 9) %f\n', cont / N);
fprintf('P(7 digitos iniciada por 91) %f\n', cont2 / N);

% ANEXO
function [state] = crawl(H, first, last)
    % the sequence of states will be saved in the vector "state"
    % initially, the vector contains only the initial state:
    state = [first];
    % keep moving from state to state until state "last" is reached:
    while (1)
        state(end + 1) = nextState(H, state(end));

        if ismember(state(end), last) % verifies if state(end) is absorbing
            break;
        end

    end

end

% Returning the next state
% Inputs:
% H - state transition matrix
% currentState - current state
function state = nextState(H, currentState)
    % find the probabilities of reaching all states starting at the current one:
    probVector = H(:, currentState)'; % probVector is cell_array row vector
    n = length(probVector); %n is the number of states
    % generate the next state randomly according to probabilities probVector:
    state = discrete_rnd(1:n, probVector);
end

% Generate randomly the next state.
% Inputs:
% states = vector with state values
% probVector = probability vector
function state = discrete_rnd(states, probVector)
    U = rand();
    i = 1 + sum(U > cumsum(probVector));
    state = states(i);
end
