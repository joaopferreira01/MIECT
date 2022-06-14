	.data
	.eqv	SIZE, 9
arr:	.space	72
zero:	.float	0.0
k:	.double	0.0
result:	.float 	1.0
xn:	.double	1.0
aux:	.double	1.0
const1:	.double	0.5
	.text
	.globl 	main
	
	# Mapa de registos
	# $t0 - i
	# $t1 - arr
	# t2 - aux
	# t3 - &(arr[i])
	
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	li	$t0,0
	la	$t1,arr
	
for:
	bge	$t0,SIZE,endfor
	li	$v0,5			
	syscall				# read_int();
	mtc1	$v0,$f12			# 
	cvt.d.w	$f12,$f12			# $f4 = (double)read_int()
	
	sll	$t2,$t0,3
	addu	$t3,$t2,$t1
	s.d	$f12,0($t3)
	
	addi	$t0,$t0,1
	j	for
endfor:
	la	$a0,arr			# $a0 = a
	li	$a1,SIZE		# $a1 = SIZE
	jal	var			# var(a, SIZE)
	
	mov.d 	$f12,$f0
	li	$v0,3		
	syscall				# print_double()
	
	li	$a0,'\n'
	li	$v0,4		
	syscall			
	
	la	$a0,arr			# $a0 = a
	li	$a1,SIZE		# $a1 = SIZE
	jal	stdev			# stdev(a, SIZE)
	
	mov.d 	$f12,$f0
	li	$v0,3		
	syscall				# print_double()
	
	li	$v0,0			# return 0;
	
	lw	$ra,0($sp)		# repoe registo $ra 
	addiu	$sp,$sp,4		# repoe espaço na stack
	
	li	$v0,0			# return 0;
	jr	$ra			# fim do programa
#################################################

# Sub-rotina intermédia
# $a0 -> double *array 
# $a1 -> int nval
# ------------------------
# $f2 -> media
# $f4 -> soma	
# ------------------------
# $s0 -> double *array 
# $s1 -> int nval
# $s2 -> i
# $s3 -> i*8 -> *array[i]

var:
	addiu	$sp,$sp,-20
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
	sw	$s2,12($sp)
	sw	$s3,16($sp)
	
	
	
	jal	average		# average(array, nval)
	cvt.s.d	$f2,$f0		# media = (float)average(array, nval)
	
	l.d	$f4,zero		# soma = 0.0
	move	$s0,$a0		# $s0 = *array
	move	$s1,$a1		# $s1 = nval
	li	$s2,0		# int i = 0
	
for_v:
	bge	$s2,$s1,endfor_v
	
	sll	$s3,$s2,3
	addu	$s3,$s3,$s0
	
	l.d	$f6,0($s3)
	cvt.s.d	$f6,$f6
	sub.s	$f6,$f6,$f2
	mov.s	$f12,$f6
	li	$a0,2
	jal	xtoy
	
	add.s	$f4,$f4,$f0		# soma += xtoy((float)array[i] - media, 2);
	addiu	$s2,$s2,1
	j	for_v
	
endfor_v:
	cvt.d.s	$f4,$f4
	mtc1	$s1,$f8
	cvt.d.w	$f8,$f8	
	div.d	$f0,$f4,$f8
	
	lw	$ra,0($sp)		# // 
	lw	$s0,4($sp)		# // 
	lw	$s1,8($sp)		# //
	lw	$s2,12($sp)		# //
	lw	$s3,16($sp)		# // repoe os registos na pilha
	addiu	$sp,$sp,20		# // repoe espaço na pilha
	
	jr	$ra			# // fim do programa
	
	
	
#################################################
# $a0 - arr
# $a1 - SIZE ou nval

average:
	move	$t0,$a0
	move	$t1,$a1
	
ave_for:	
	ble	$t1,$0,ave_endfor
	addi	$t3,$t1,-1
	sll	$t3,$t3,3
	addu	$t2,$t3,$t0
	l.d	$f2,0($t2)
	add.d	$f0,$f0,$f2
	addi	$t1,$t1,-1
	j	ave_for
	
ave_endfor:
	mtc1	$a1,$f4
	cvt.d.w	$f4,$f4
	div.d	$f0,$f0,$f4
	jr	$ra

#################################################

# $f12 -> float x
# $a0 -> int y

xtoy:					# float xtoy(float x, int y) {
	addiu	$sp,$sp,-16		
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
								
	li	$s0,0			# i = 0;
	l.s	$f0,result		# result = 1.0
		
	jal	abso			# abs(y)
	move	$s1,$v0			# $s1 = $v0
xtoy_for:	
	bge	$s0,$s1,xtoy_endfor	# for(i=0, result=1.0; i < abs(y); i++) {
xtoy_if:	
	blez	$a1,xtoy_else		# if(y > 0) {	
	mul.s	$f0,$f0,$f12		# result *= x;
	j	xtoy_endif		
xtoy_else:				# else {
	div.s	$f0,$f0,$f2		# result /= x;
xtoy_endif:
	addiu	$s0,$s0,1		# i++		
	j	xtoy_for		
xtoy_endfor:
	
	lw	$ra,0($sp)
	lw	$s0,4($sp)
	lw	$s1,8($sp)
	addiu	$sp,$sp,16	
	
	jr	$ra			# 
	
#################################################

stdev:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	jal	var
	mov.d	$f12,$f0
	jal	sqrt
	
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra
	
	
#################################################
#f12 -> val
sqrt:					# double sqrt(double val) {
	li	$t0,0			# 	int i = 0;
	l.d	$f0,xn			# 	double xn = 1.0;
	l.d	$f2,aux			#	double aux = 1.0;
	l.d	$f4,zero		#	double zero = 0.0;
	l.d	$f6,const1
s_if:	
	c.le.d	$f12,$f4		#
	bc1t	s_else			# if(val > 0.0) {
s_do:					#	do {
	mov.d	$f2,$f0			# 		aux = xn;
	
	div.d	$f8,$f12,$f0		# // $f8 = val/xn
	add.d	$f8,$f8,$f0		# // $f8 = xn + val/xn
	mul.d	$f0,$f8,$f6		# xn = 0.5 * (xn + val/xn)
s_while:
	c.eq.d	$f2,$f0			# 
	bc1t	s_endif			# 
	addiu	$t0,$t0,1		# i++
	bge	$t0,25,s_endif		#
	j	s_do			# while((aux != xn) && (++i < 25));		

s_else:					# else {
	l.d	$f0,zero		# 	xn = 0.0; 
s_endif:
	jr	$ra			# fim da sub-rotina
	
#################################################
# sub-rotina terminal
abso:					# int abs(int val) {
	move	$v0,$a0			
abs_if:	
	bgez	$v0,abs_endif		# if(val < 0) {
	mul	$v0,$v0,-1		# val = -val; 
abs_endif:	
	jr	$ra			# fim da rub-rotina