.data
	a: .word 2
	b: .word 3
	c: .word 8
	
.text main:
	lw $t1,a
	lw $t2,b
	lw $t3,c
	
	slt $t0,$0,$t1
	beq $t0,$0,else
	addi $t2,$t1,10
	j fin
	else:
	addi $t2,$t1,-10
	fin: