.data
	a: .word 2
	b: .word 3
	c: .word 8
	i: .word 0
	
.text main:

	lw $t1,a
	lw $t2,b
	lw $t3,c
	li $t4,0
	
	for:
	beq $t0,5,fin
	addi $t4,$t4,1
	add $t1,$t1,$t2
	j for
	fin:
	
	