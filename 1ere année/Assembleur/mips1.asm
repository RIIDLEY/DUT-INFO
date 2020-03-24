.data
	a: .word 3	#variable
	b: .word 5	#variable
	c: .word 7	#variable
	tab: .word 1,2,3,4,5	#tbaleau

.text main:
	lw $s0,a	#ecrire dans le registre s0
	lw $s1,b	#ecrire dans le registre s1
	lw $s2,c	#ecrire dans le registre s2
	la $s3,tab	#ecrire dans le registre s3
	lw $t0, 12($s3) #ecrire dans le registre t0 	(4=tab[1], 8=tab[1], 12=tab[3]...) 
	
	add $s0, $s1, $s2	#calcule
	add $s0, $s0, $t0	#calcule
	sw $s0,a		#$0=a	
	li $v0, 1	#mode affichage
	move $a0, $s0	#affiche variable
	syscall		#affiche variable