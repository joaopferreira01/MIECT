.data
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
	.eqv	stud_size,44	# valor random acho eu
	.eqv	print_string,4
	.eqv	print_intu10,36
	.eqv	print_char,11
	.eqv	print_float,2
	.eqv	read_int,5
	.eqv	read_string,8
	.eqv	read_float,6
	.eqv	MAX_STUDENTS,2
students: .space	176
str1:	.asciiz	"N. Mec: "
str2:	.asciiz	"Primeiro Nome: "
str3:	.asciiz	"Ultimo Nome: "
str4:	.asciiz	"Nota: "
str5:	.asciiz	""
media:	.float	0
max_grade:	.float	-20.0
	.text
	.globl main
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	la	$a0,students
	li	$a1,MAX_STUDENTS
	jal	read_data
	
	la	$a0,students
	li	$a1,MAX_STUDENTS
	la	$a2,media
	jal	max
	move	$s0,$v0
	
	move	$a0,$s0
	jal	print_student
	
	
	
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	li	$v0,0
	jr	$ra
























##############################################################################
# void read_data(student *, int);
# *st: $a0, ns: $a1  ,  i: $t0, tempStud: $t1, tempMember: $t2, 
read_data:
	li	$t0,0
	move	$t5,$a0
	move	$t6,$a1
read_data_for:	
	bge	$t0,$t6,read_data_efor
	
	mulu	$t1,$t0,stud_size
	addu	$t1,$t1,$t5		# $t1 = *st[i]
	
	la	$a0,str1
	li	$v0,print_string
	syscall				# print_string("N. Mec: ");
	
	li	$v0,read_int
	syscall
	addiu	$t2,$t1,id_number
	sw	$v0,0($t2)		# st[i].id_number = read_int();
	
	la	$a0,str2
	li	$v0,print_string
	syscall				# print_string("Primeiro Nome: ");
	
	li	$v0,read_string
	addiu	$a0,$t1,first_name
	li	$a1,17
	syscall				# read_string(st[i].first_name, 17);
	
	la	$a0,str3
	li	$v0,print_string
	syscall				# print_string("Ultimo Nome: ");
	
	li	$v0,read_string
	addiu	$a0,$t1,last_name
	li	$a1,14
	syscall				# read_string(st[i].last_name, 14);
	
	la	$a0,str4
	li	$v0,print_string
	syscall				# print_string("Nota: ");
	
	li	$v0,read_float
	syscall
	addiu	$t2,$t1,grade
	swc1	$f0,0($t2)		# st[i].grade = read_float();
	
	
	addi	$t0,$t0,1
	j	read_data_for
read_data_efor:
	jr	$ra








##################################################################
# studentMax: $f0, *st: $a0, ns: $a1, *media: $a2  /// *p: $t0, *pmax: $t1, max_grade: $f2, sum: $f4, grade: $f6
# student *max(student *st, int ns, float *media)
max:
	l.s	$f2,max_grade
	l.s	$f4,media
	
	move 	$t0,$a0			# p = st;
	mul	$t1,$a1,44
	addu	$t1,$t1,$a0		# $t1 = (st + ns)
max_for:
	bgeu	$t0,$t1,max_efor	# p < (st + ns)
	
	lwc1	$f6,grade($t0)		# $f2 = p->grade
	add.s	$f4,$f4,$f6		# sum += p->grade;
	
max_if:
	c.le.s	$f6,$f2
	bc1t	max_eif
	mov.s	$f2,$f6			# max_grade = p->grade;
	move	$t2,$t0			# pmax = p;
max_eif:
	addiu	$t0,$t0,44		# p++;
	j	max_for
max_efor:
	mtc1	$a1,$f8
	cvt.s.w	$f8,$f8
	div.s	$f0,$f4,$f8
	move	$v0,$t2
	jr	$ra








###################################################################
# *p: $a0  ///  *p: $t0  
# void print_student(student *p)
print_student:
	move	$t0,$a0
	
	lw	$a0,id_number($t0)
	li	$v0,print_intu10
	syscall
	
	addiu	$a0,$t0,first_name
	li	$v0,print_string
	syscall
	
	addiu	$a0,$t0,last_name
	li	$v0,print_string
	syscall
	
	lwc1	$f12,grade($t0)
	li	$v0,print_float
	syscall
	
	jr	$ra
