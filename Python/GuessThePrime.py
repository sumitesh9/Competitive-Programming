import math 
def primeFactors(n,x2,modres):
    hs=set()
    while(n%2==0):
        if(x2%2==modres):
            hs.add(2)
        n=n//2 
    for k in range(3,int(math.sqrt(n))+1,2):
        while(n%k==0):
            if(x2%k==modres):
                hs.add(k)
            n=n//k 

    if(n>2):
        if(x2%n==modres):
            hs.add(n)
    return hs 
t=int(input())
for i in range(0,t):
    print(1, 31623, flush=True)
    res1=int(input())
    temp1=1000014129-res1
    pf1=primeFactors(temp1,1000014129,res1)
    if(len(pf1)==1):
        for q in pf1:
            print(2, q, flush=True)
            break
        check=input()
        if(check=="Yes"):
            continue
        if(check=="No"):
            break
    else:        
        print(1, 30000, flush=True)
        res2=int(input())
        temp2=900000000-res2
        pf2=primeFactors(temp2,900000000,res2)
        if(len(pf2)==1):
            for q in pf2:
                print(2, q, flush=True)
                break
            check=input()
            if(check=="Yes"):
                continue
            if(check=="No"):
                break
        else:
            pfres=pf1.intersection(pf2)
            for j in pfres:
                print(2, j, flush=True)
                break
            check=input()
            if(check=="Yes"):
                continue
            if(check=="No"):
                break