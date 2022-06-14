	.data
	
str:	.asciiz "Arquitetura de computadores I"
	
	.text
	.globl main

main:

	addiu	$sp,$sp,-4
	sw	$ra,0($sp)				# prólogo
	
	la	$a0,str
	jal	strlen					# len = strlen(str)
	
	move	$a0,$v0
	
	li	$v0,1					# print_int10(temp)
	syscall		
	
	li	$v0,0					# return 0
	
	lw 	$ra,0($sp)				# epílogo
	addiu 	$sp,$sp,4
	jr 	$ra
	
	
	
####################################################################
strlen:							# strlen(char *s)
							# $a0 -> char *s
							# $v0 -> len
							# len = 0
	li	$v0,0
strlen_w1:
	lb	$t0,0($a0)				# $t0 = *s
	beq	$t0,$0,strlen_ew1
	addiu 	$a0,$a0,1				# s++
	addi	$v0,$v0,1				# len++

	j	strlen_w1
strlen_ew1:
	
	jr 	$ra
