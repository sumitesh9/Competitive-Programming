n=int(input())
water=list(map(int,input().split()))
x=[]
temp=0
for i in range(1,n,2):
    temp+=water[i]
x.append(sum(water)-2*temp)
for j in range(n-1):
    x.append(2*water[j]-x[-1])
res=map(str,x)
print(' '.join(res))