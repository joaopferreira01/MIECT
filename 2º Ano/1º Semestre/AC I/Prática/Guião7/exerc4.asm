	.data
	.eqv	print_string,4
str1:	.asciiz	"Arquitetura de  "
str2:	.space	50
str3:	.asciiz	"\n"
str4:	.asciiz	"Computadores I"
	.text
	.globl main
	
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	la	$a0,str2
	la	$a1,str1
	jal	strcpy
	
	move	$a0,$v0
	
	li	$v0,print_string
	syscall
	
	la	$a0,str3
	li	$v0,print_string
	syscall
	
	la	$a0,str2
	la	$a1,str4
	jal	strcat
	
	move	$a0,$v0
	li	$v0,print_string
	syscall
	
	li	$v0,0
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra
	
	
	
	
###################################
	# strcpy(str2, str1)
strcpy:					# char *strcpy(char *dst char *src) {
	move	$t2, $a0		#
do:					#	do {
	lb	$t1, 0($a1)		#		$t1 = src[i];
	sb	$t1, 0($a0)		#		dts[i] = src[i];
	addiu	$a0, $a0, 1
	addiu	$a1, $a1, 1
while:	bne	$t1, '\0', do		#	} while(src[i] != '\0');
	move	$v0, $t2		#	return dst;
	jr	$ra			# }	fim do programa
	
	
#################################
	# print_string( strcat(str2, "Computadores I") )
strcat:
	addiu	$sp,$sp,-8
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	move	$s0,$a0

while1:
	lb	$t0,0($a0)
	beq	$t0,'\0',endw
	addiu	$a0,$a0,1
	j	while1
	
endw:
	jal	strcpy
	move	$v0,$s0
	lw	$ra,0($sp)
	lw	$s0,0($sp)
	addiu	$sp,$sp,8
	jr	$ra

