	.data
str1:.asciiz "Uma string qualquer"
str2:.asciiz "AC1"
	
	.text
	.globl main
main:
	la $a0,str2
	ori $v0,$0,4
	
	syscall
	jr $ra	 
	