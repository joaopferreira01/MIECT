.data
x0:	.double	5.0
x1:	.double	9.0
x2:	.double	32.0
	.text
	.globl f2c

f2c:					# double f2c(double ft) {		
	l.d	$f2,x0			#	$f2 = 5
	cvt.s.w	$f2,$f2			#	$t0 = $x0
			
	l.d	$f4, x1			#	$f4 = 9
	cvt.s.w	$f4,$f4			#	$t0 = $x1
			
	l.d	$f6, x2			#	$f4 = 32
	cvt.s.w	$f6,$f6			#	$t0 = $x2
	
	sub.d	$f12, $f12, $f6		#	ft - 32.0
	div.d	$f2, $f2, $f4		#	$f2 = 5.0/9.0
	mul.d	$f0, $f2, $f12		#	return 5.0/9.0 * (ft - 32.0);
	jr	$ra			# } fim do programa