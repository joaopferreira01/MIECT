	.data
str:	.asciiz "String de teste"
	.text
	.globl main
	
main:
	addi 	$sp,$sp,-4
	sw	$ra,0($sp)
	la	$a0,str
	jal	strlen
	lw	$ra,0($sp)
	addi	$sp,$sp,4
	move	$a0,$v0
	li	$v0,1
	syscall
	jr	$ra

strlen:
	li	$v0,0
	move 	$t1,$a0
	
while:
	lb	$t2,0($t1)
	beq	$t2,'\0',endwhile
	addi	$t1,$t1,1
	addi	$v0,$v0,1
	j	while
	
endwhile:
	jr	$ra