def chiffre_cesar(m, n):
    
    c = ""
    for mi in m:
        if(97 <= ord(mi) <= 122):
            c += chr( (ord(mi) + n - ord('a')) % 26 + ord('a'))
        else:
            c += mi
    return c

def dechiffre_cesar(c, n):
    m = ""
    for ci in c:
        if(97 <= ord(ci) <= 122):
            m += chr( (ord(ci) - n - ord('a')) % 26 + ord('a'))
        else:
            m += ci
    return m

