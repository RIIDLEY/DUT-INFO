from Cryptographie.cesar import *

def chiffre_ROT13(message):
    return chiffre_cesar(message,13)

def dechiffre_ROT13(message):
    return chiffre_ROT13(message)