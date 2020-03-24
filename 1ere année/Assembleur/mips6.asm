.data
	src: .word 0,1,2,3,4,5,6,7,8,9
	dest: .space 40	
.text 
main:
	la $a1,src
	la $a2,dest
	li $t0,0
	
loop: 	lw $t1,($a1)	#t1=mem(a1)
	sw $t1,($a2)	#mem(a2)=t1
	addi $a1,$a1,4 	#a1+=4
	addi $a2,$a2,4 	#a2+=4
	addi $t0,$t0,1	#t0++
	slti $t1,$t0,10 #if t0<10
	bne $t1,$0,loop #goto loop
	
loop1: 	li $v0, 1
	
	move $a0, $a1	
	syscall	
	addi $a1,$a1,1
	slti $t1,$a1,8
	bne $t1,$0,loop1