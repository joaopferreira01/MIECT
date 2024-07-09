.data
X1:	.float	1.5
	.text
	.globl main
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	la	$t0,X1
	l.s	$f12,0($t0)
	li	$a0,2
	jal	xtoy
	
	mov.s	$f12,$f0
	li	$v0,2
	syscall

	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra






################################################################################
# x: $f12, y: $a0, i: $s0, result: $f2, abs(y): $s1, _y: $s2
xtoy:					# float xtoy(float x, int y) {
	addiu	$sp,$sp,-16
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
	sw	$s2,12($sp)
	
	move	$s2,$a0
	
	li	$s0,0		# i = 0;
	li	$t0,1
	mtc1	$t0,$f2
	cvt.s.w	$f2,$f2		# result = 1.0;
	
	move	$a0,$s2
	jal	abs
	move	$s1,$v0
xtoy_for:	
	bge	$s0,$s1,xtoy_efor
xtoy_if:
	blez	$s2,xtoy_elif
	mul.s	$f2,$f2,$f12
	j	xtoy_eif
xtoy_elif:
	div.s	$f2,$f2,$f12
xtoy_eif:
	addi	$s0,$s0,1
	j	xtoy_for
xtoy_efor:
	mov.s	$f0,$f2
	
	lw	$ra,0($sp)
	lw	$s0,4($sp)
	lw	$s1,8($sp)
	lw	$s2,12($sp)
	addiu	$sp,$sp,16
	jr	$ra



##########################################################################
# val: $a0
abs:
abs_if:	bgez	$a0,abs_eif
	mul	$a0,$a0,-1
abs_eif:
	move	$v0,$a0
	jr	$ra
