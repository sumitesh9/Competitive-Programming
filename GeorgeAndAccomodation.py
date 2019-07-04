n=int(input())
c=0
for i in range(0,n):
    p,q=map(int,input().split())
    if((q-p)>=2):
        c=c+1
print(c)