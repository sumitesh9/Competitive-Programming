def countSetBits(n): 
    if(n==0):
        return 0
    else: 
        return 1 + countSetBits(n & (n - 1)) 
t=int(input())
for i in range(0,t):
    e=0
    o=0
    q=int(input())
    h=set()
    for j in range(0,q):
        x=int(input())
        xset=set([x])
        if(xset.issubset(h)==False):
            h.add(x)
            if(countSetBits(x)%2==1):
                o=o+1
            else:
                e=e+1
            h1=h.copy()
            for y in h1:
                if(y!=x):
                    h.add(y^x)
                    if(countSetBits(y^x)%2==1):
                        o=o+1
                    else:
                        e=e+1
        print(e, o)