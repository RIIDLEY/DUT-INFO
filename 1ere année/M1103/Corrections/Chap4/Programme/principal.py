# from cesar import *

# cle  = 5
# s = "C'est super python !"
# print(s)
# chiffre = chiffre_cesar(s,cle)
# print("chiffrement : ", chiffre)

# s_decode = dechiffre_cesar(chiffre,cle)
# print ("déchiffrement : ", s_decode)

# if s != s_decode : 
#     print("On a un problème dans le code/décodage")
# else:
#     print("Le chiffrement/décodage a bien fonctionné")


import sys
sys.path.append("../")


from Cryptographie.rot13 import *

s = "Coder, decoder, c'est super !"
print(s)
chiffre = chiffre_ROT13(s)
print("chiffrement : ", chiffre)

s_decode = dechiffre_ROT13(chiffre)
print ("déchiffrement : ", s_decode)

if s != s_decode : 
    print("On a un problème dans le code/décodage")
else:
    print("Le chiffrement/décodage a bien fonctionné")
