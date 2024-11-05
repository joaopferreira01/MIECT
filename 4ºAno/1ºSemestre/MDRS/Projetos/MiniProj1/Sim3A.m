function [PLdata, PLvoip , APDdata, APDvoip , MPDdata, MPDvoip , TT] = Sim3(lambda,C,f,P,n,B)
% INPUT PARAMETERS:
%  lambda - packet rate (packets/sec)
%  C      - link bandwidth (Mbps)
%  f      - queue size (Bytes)
%  P      - number of packets (stopping criterium)
% OUTPUT PARAMETERS:
%  PLdata   - packet loss (%) of data packets
%  PLvoip  - Packet Loss (%) of VOip packets
%  APDdata  - average  data packet delay (milliseconds)
%  APDvoip  - average voip packet delay(miliseconds)
%  MPDdata  - maximum data packet delay (miliseconds)
%  MPDvoip  - maximum voip packet delay (miliseconds)
%  TT   - transmitted throughput (Mbps)

%Events:
ARRIVAL= 0;       % Arrival of a packet            
DEPARTURE= 1;     % Departure of a packet

%State variables:
STATE = 0;          % 0 - connection is free; 1 - connection is occupied
QUEUEOCCUPATION= 0; % Occupation of the queue (in Bytes)
QUEUE= [];          % Size and arriving time instant of each packet in the queue

%Statistical Counters:
TOTALPACKETS= 0;     % No. of packets arrived to the system
TOTALPACKETSvoip=0;
LOSTPACKETS= 0;      % No. of packets dropped due to buffer overflow
LOSTPACKETSvoip=0;
TRANSPACKETS= 0;     % No. of transmitted packets
TRANSPACKETSvoip=0;
TRANSBYTES= 0;       % Sum of the Bytes of transmitted packets

DELAYS= 0;           % Sum of the delays of transmitted packets
DELAYSvoip=0;
MAXDELAY= 0;         % Maximum delay among all transmitted packets
MAXDELAYvoip=0;

% Initializing the simulation clock:
Clock= 0;

% Initializing the List of Events with the first ARRIVAL:
tmp= Clock + exprnd(1/lambda);
EventList = [ARRIVAL, tmp, GeneratePacketSize(), tmp, 0];

%generate VOip packets
for i=1:n
    tmp = unifrnd(0, 0.02);
    EventList = [EventList; ARRIVAL, tmp, randi([110, 130]), tmp, 1  ];
end

%Similation loop:
while (TRANSPACKETS+TRANSPACKETSvoip)<P % Stopping criterium
    EventList= sortrows(EventList,2);  % Order EventList by time
    Event= EventList(1,1);              % Get first event 
    Clock= EventList(1,2);              %    and all
    PacketSize= EventList(1,3);        %    associated
    ArrInstant= EventList(1,4);    %    parameters.
    type= EventList(1,5);          %   get the packet type

    EventList(1,:)= [];                 % Eliminate first event
    switch Event
        case ARRIVAL                     % If first event is an ARRIVAL
            if type == 0  % Data packet
                TOTALPACKETS= TOTALPACKETS+1;
                tmp= Clock + exprnd(1/lambda);
                EventList = [EventList; ARRIVAL, tmp, GeneratePacketSize(), tmp, 0];
                if STATE==0
                    STATE= 1;
                    EventList = [EventList; DEPARTURE, Clock + 8*PacketSize/(C*10^6), PacketSize, Clock, 0];
                else
                    if QUEUEOCCUPATION + PacketSize <= f
                        QUEUE= [QUEUE;PacketSize , Clock, 0];
                        QUEUEOCCUPATION= QUEUEOCCUPATION + PacketSize;
                    else
                        LOSTPACKETS= LOSTPACKETS + 1;
                    end
                end
            elseif type == 1 % VoIP packet
                TOTALPACKETSvoip= TOTALPACKETSvoip+1;
                tmp= Clock + unifrnd(0.016,0.024);
                EventList = [EventList; ARRIVAL, tmp, randi([110,130]), tmp, 1];
                if STATE==0
                    STATE= 1;
                    EventList = [EventList; DEPARTURE, Clock + 8*PacketSize/(C*10^6), PacketSize, Clock, 1];
                else
                    if QUEUEOCCUPATION + PacketSize <= f
                        QUEUE= [QUEUE;PacketSize , Clock, 1];
                        QUEUEOCCUPATION= QUEUEOCCUPATION + PacketSize;
                    else
                        LOSTPACKETSvoip= LOSTPACKETSvoip + 1;
                    end
                end
            end
           
        

        case DEPARTURE                     % If first event is a DEPARTURE
            if type == 0 % Data Packet
                if rand()<(1-B)^(PacketSize*8) % check if all bits are transmitted
                    TRANSBYTES= TRANSBYTES + PacketSize;
                    DELAYS= DELAYS + (Clock - ArrInstant);
                    if Clock - ArrInstant > MAXDELAY
                        MAXDELAY= Clock - ArrInstant;
                    end
                    TRANSPACKETS= TRANSPACKETS + 1;
                else 
                    LOSTPACKETS = LOSTPACKETS+1;
                end
                if QUEUEOCCUPATION > 0
                    EventList = [EventList; DEPARTURE, Clock + 8*QUEUE(1,1)/(C*10^6), QUEUE(1,1), QUEUE(1,2), QUEUE(1,3)];
                    QUEUEOCCUPATION= QUEUEOCCUPATION - QUEUE(1,1);
                    QUEUE(1,:)= [];
                else
                    STATE= 0;
                end
            elseif type == 1  % VoIP Packet
                if rand()<(1-B)^(PacketSize*8)
                    TRANSBYTES= TRANSBYTES + PacketSize;
                    DELAYSvoip= DELAYSvoip + (Clock - ArrInstant);
                    if Clock - ArrInstant > MAXDELAYvoip
                        MAXDELAYvoip= Clock - ArrInstant;
                    end
                    TRANSPACKETSvoip= TRANSPACKETSvoip + 1;
                else
                    LOSTPACKETSvoip = LOSTPACKETSvoip +1;
                end
                if QUEUEOCCUPATION > 0
                    EventList = [EventList; DEPARTURE, Clock + 8*QUEUE(1,1)/(C*10^6), QUEUE(1,1), QUEUE(1,2), QUEUE(1,3)];
                    QUEUEOCCUPATION= QUEUEOCCUPATION - QUEUE(1,1);
                    QUEUE(1,:)= [];
                else
                    STATE= 0;
                end
            end
    end
end

%Performance parameters determination:
PLdata= 100*LOSTPACKETS/TOTALPACKETS;  % in percentage
PLvoip = 100*LOSTPACKETSvoip/TOTALPACKETSvoip;
APDdata= 1000*DELAYS/TRANSPACKETS;     % in milliseconds
APDvoip = 1000*DELAYSvoip/TRANSPACKETSvoip;
MPDdata= 1000*MAXDELAY;                % in milliseconds
MPDvoip=1000*MAXDELAYvoip;
TT= 1e-6*TRANSBYTES*8/Clock;    % in Mbps

end

function out= GeneratePacketSize()
    aux= rand();
    aux2= [65:109 111:1517];
    if aux <= 0.19
        out= 64;
    elseif aux <= 0.19 + 0.23
        out= 110;
    elseif aux <= 0.19 + 0.23 + 0.17
        out= 1518;
    else
        out = aux2(randi(length(aux2)));
    end
end