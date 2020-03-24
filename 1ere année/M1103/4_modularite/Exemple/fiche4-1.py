
from func import *
from utils.operations import ajoute_deux

age = input("Quel est votre age? : ")
print("Vous avez %d ans", age)

age_plus_un = ajoute_un(age)

print("Dans un an vous aurez" ,age_plus_un, "ans")

age_plus_deux = ajoute_deux(age)

print("Dans deux ans vous aurez ",age_plus_deux, "ans")
