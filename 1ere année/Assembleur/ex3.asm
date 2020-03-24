.data
	a: .word 2
	b: .word 3
	c: .word 8
	
.text main:
	lw $t1,a
	lw $t2,b
	lw $t3,c
	
	slt $t0,$t1,$t2
	beq $t0, $0,fin
	bne $t3,$0,fin 
	addi $t3,$0,1
	fin: