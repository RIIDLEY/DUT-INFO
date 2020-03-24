import string
import crypt

def test(hash1):
	i=0
	j=0
	u=0
	while(i<len(string.ascii_lowercase)):
		while(j<len(string.ascii_lowercase)):
			while(u<len(string.ascii_lowercase)):
				mdp = string.ascii_lowercase[i]+string.ascii_lowercase[j]+string.ascii_lowercase[u]
				
				if(hash1==crypt.crypt(mdp, "$1$rXGhjmGD$")):
					print("le mdp est : " + mdp)
				u+=1
			u=0
			j+=1
		j=0
		i+=1

test("$1$rXGhjmGD$qtuklX26hky6/TDbGxjCo.")
