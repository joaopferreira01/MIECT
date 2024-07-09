% distribuiçao acumulada
x = [5, 50, 100]
px = [0.9, 0.09, 0.01]
xd = [0 x 110]
pxd = [0 px 0]
fd = cumsum(pxd)
stairs(xd,fd,'r');