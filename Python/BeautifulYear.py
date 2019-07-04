n=int(input())
def distinctDig(x):
    s=str(x)
    set={" "}
    for i in range(0,len(s)):
        if(s[i] in set):
            return False
        else:
            set.add(s[i])
    return True
while(distinctDig(n+1)==False):
    n=n+1
print(n+1)