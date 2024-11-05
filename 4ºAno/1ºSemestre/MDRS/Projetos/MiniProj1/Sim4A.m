function [PLdata, PLvoip, APDdata, APDvoip, MPDdata, MPDvoip, TT] = Sim4(lambda, C, f, P, n,p)
% INPUT PARAMETERS:
%  lambda - packet rate (packets/sec)
%  C      - link bandwidth (Mbps)
%  f      - queue size (Bytes)
%  P      - number of packets (stopping criterium)
%  n      - number of initial VoIP packets
% OUTPUT PARAMETERS:
%  PLdata   - packet loss (%) of data packets
%  PLvoip  - Packet Loss (%) of Voip packets
%  APDdata  - average  data packet delay (milliseconds)
%  APDvoip  - average Voip packet delay (milliseconds)
%  MPDdata  - maximum data packet delay (milliseconds)
%  MPDvoip  - maximum Voip packet delay (milliseconds)
%  TT   - transmitted throughput (Mbps)

% Events:
ARRIVAL = 0;      % Arrival of a packet            
DEPARTURE = 1;    % Departure of a packet

% State variables:
STATE = 0;           % 0 - connection is free; 1 - connection is occupied
QUEUEOCCUPATION = 0; % Occupation of the queue (in Bytes)
QUEUE = [];          % Size, arriving time instant, and type of each packet in the queue

% Statistical Counters:
TOTALPACKETS = 0;        % No. of packets arrived to the system
TOTALPACKETSvoip = 0;
LOSTPACKETS = 0;         % No. of packets dropped due to buffer overflow
LOSTPACKETSvoip = 0;
TRANSPACKETS = 0;        % No. of transmitted data packets
TRANSPACKETSvoip = 0;
TRANSBYTES = 0;          % Sum of the Bytes of transmitted packets

DELAYS = 0;              % Sum of the delays of transmitted data packets
DELAYSvoip = 0;
MAXDELAY = 0;            % Maximum delay among all transmitted data packets
MAXDELAYvoip = 0;

% Initializing the simulation clock:
Clock = 0;

% Initializing the List of Events with the first data packet ARRIVAL:
tmp = Clock + exprnd(1/lambda);
EventList = [ARRIVAL, tmp, GeneratePacketSize(), tmp, 0];

% Generate initial VoIP packets:
for i = 1:n
    tmp = unifrnd(0, 0.02);
    EventList = [EventList; ARRIVAL, tmp, randi([110, 130]), tmp, 1];
end

% Simulation loop:
while (TRANSPACKETS + TRANSPACKETSvoip) < P % Stopping criterion
    EventList = sortrows(EventList, 2);  % Order EventList by time
    Event = EventList(1, 1);              % Get first event 
    Clock = EventList(1, 2);              % Current time
    PacketSize = EventList(1, 3);         % Packet size
    ArrInstant = EventList(1, 4);         % Arrival time
    type = EventList(1, 5);               % Packet type (0 for data, 1 for VoIP)

    EventList(1, :) = [];                 % Remove the processed event
    
    switch Event
        case ARRIVAL                     % If the event is an ARRIVAL
            if type == 0  % Data packet
                TOTALPACKETS = TOTALPACKETS + 1;
                tmp = Clock + exprnd(1/lambda);
                EventList = [EventList; ARRIVAL, tmp, GeneratePacketSize(), tmp, 0];
                if STATE == 0
                    STATE = 1;
                    EventList = [EventList; DEPARTURE, Clock + 8 * PacketSize / (C * 10^6), PacketSize, Clock, 0];
                else
                    if QUEUEOCCUPATION + PacketSize <= f*(p/100) % changes here, total queue ocupation <= queue size * p(%)/100
                        QUEUE = [QUEUE; PacketSize, Clock, 0]; % Add data packet to the queue
                        QUEUEOCCUPATION = QUEUEOCCUPATION + PacketSize;
                    else
                        LOSTPACKETS = LOSTPACKETS + 1;  % Data packet lost due to buffer overflow
                    end
                end
            elseif type == 1 % VoIP packet
                TOTALPACKETSvoip = TOTALPACKETSvoip + 1;
                tmp = Clock + unifrnd(0.016, 0.024);
                EventList = [EventList; ARRIVAL, tmp, randi([110, 130]), tmp, 1];
                if STATE == 0
                    STATE = 1;
                    EventList = [EventList; DEPARTURE, Clock + 8 * PacketSize / (C * 10^6), PacketSize, Clock, 1];
                else
                    if QUEUEOCCUPATION + PacketSize <= f
                        QUEUE = [QUEUE; PacketSize, Clock, 1]; % Add VoIP packet to the queue
                        QUEUEOCCUPATION = QUEUEOCCUPATION + PacketSize;
                    else
                        LOSTPACKETSvoip = LOSTPACKETSvoip + 1; % VoIP packet lost due to buffer overflow
                    end
                end
            end
           
        case DEPARTURE                     % If the event is a DEPARTURE
            if type == 0 % Data packet
                TRANSBYTES = TRANSBYTES + PacketSize;
                DELAYS = DELAYS + (Clock - ArrInstant);
                if Clock - ArrInstant > MAXDELAY
                    MAXDELAY = Clock - ArrInstant;
                end
                TRANSPACKETS = TRANSPACKETS + 1;
            elseif type == 1 % VoIP packet
                TRANSBYTES = TRANSBYTES + PacketSize;
                DELAYSvoip = DELAYSvoip + (Clock - ArrInstant);
                if Clock - ArrInstant > MAXDELAYvoip
                    MAXDELAYvoip = Clock - ArrInstant;
                end
                TRANSPACKETSvoip = TRANSPACKETSvoip + 1;
            end
            
            % Serve the next packet in the queue, prioritizing VoIP
           if QUEUEOCCUPATION > 0
                % changes here
                QUEUE = sortrows(QUEUE, -3);% orders the queue in descending order(-) y the packet type(column number 3)
                EventList = [EventList; DEPARTURE, Clock + 8*QUEUE(1,1)/(C10^6), QUEUE(1,1), QUEUE(1,2), QUEUE(1,3)];
                QUEUEOCCUPATION= QUEUEOCCUPATION - QUEUE(1,1);
                QUEUE(1,:)= [];
                
            else
                STATE = 0;
            end
    end
end

% Performance parameters determination:
PLdata = 100 * LOSTPACKETS / TOTALPACKETS;  % in percentage
PLvoip = 100 * LOSTPACKETSvoip / TOTALPACKETSvoip;
APDdata = 1000 * DELAYS / TRANSPACKETS;     % in milliseconds
APDvoip = 1000 * DELAYSvoip / TRANSPACKETSvoip;
MPDdata = 1000 * MAXDELAY;                  % in milliseconds
MPDvoip = 1000 * MAXDELAYvoip;
TT = 1e-6 * TRANSBYTES * 8 / Clock;         % in Mbps

end

function out = GeneratePacketSize()
    aux = rand();
    aux2 = [65:109 111:1517];
    if aux <= 0.19
        out = 64;
    elseif aux <= 0.19 + 0.23
        out = 110;
    elseif aux <= 0.19 + 0.23 + 0.17
        out = 1518;
    else
        out = aux2(randi(length(aux2)));
    end
end
