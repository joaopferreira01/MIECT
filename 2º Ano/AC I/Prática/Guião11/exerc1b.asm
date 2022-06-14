	.data
	.eqv id_number,0
	.eqv first_name,4
	.eqv last_name,22
	.eqv grade, 40
	.eqv print_str, 4
	.eqv read_int,5
	.eqv print_intu10, 36
	.eqv print_char, 11
	.eqv print_float, 2
stg:	.space 22
	.asciiz "Bonaparte"
	.space 5
	.float 5.1
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "
str4:	.asciiz	"\nPrimeiro Nome: "
	.text
	.globl main

main:
	la	$t0,stg
	la	$a0,str1
	li	$v0,print_str
	syscall
	
	li	$v0,read_int
	syscall
	
	sw	$v0,id_number($t0)
	
	la	$a0,str4
	li	$v0,print_str
	syscall
	
	addiu	$a0,$t0,first_name
	li	$v0,8
	li	$a1,18
	syscall
	
	la	$a0,str1
	li	$v0,print_str
	syscall
	lw	$a0,id_number($t0)
	li	$v0,print_intu10
	syscall
	
	la	$a0,str2
	li	$v0,print_str
	syscall
	addiu	$a0,$t0,last_name
	li	$v0,print_str
	syscall
	
	li	$a0,','
	li	$v0,print_char
	syscall
	
	addiu	$a0,$t0,first_name
	li	$v0,print_str
	syscall
	
	la	$a0,str3
	li	$v0,print_str
	syscall
	
	l.s	$f12,grade($t0)
	li	$v0,print_float
	syscall
	li	$v0,0
	jr	$ra
	