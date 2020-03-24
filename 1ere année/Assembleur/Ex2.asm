.data
	a: .word 2
	b: .word 3

.text main :
	lw $s0,a
	lw $s1,b
	
	mul $s2,$s0,$s0 # a²
	mul $s3,$s2,$s0 # a³
	
	mul $s4,$s1,$s1 # b²
	mul $s5,$s4,$s1 # b³
	
	mul $s6,$s2,3	#3*a²
	mul $s6,$s6,$s1	#3*a²b
	mul $s7,$s0,3 #3*a
	mul $s7,$s7,$s4 #3*a*b²
	
	add $s3,$s3,$s6 #a²+3*a²b
	add $s3,$s3,$s7 #a²+3*a²b + 3*a*b²
	add $s3,$s3,$s5 #a²+3*a²b + 3*a*b² +b³
	
	li $v0,1
	move $a0,$s3
	syscall