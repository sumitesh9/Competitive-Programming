l,r=map(int,input().split())
ans=10000000000
for i in range(l,r):
    for j in range(i+1,r+1):
        p=(i*j)%2019
        ans=min(p,ans)
        if(ans==0):
            break
    else:
        continue
    break
print(ans)