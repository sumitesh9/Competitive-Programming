t=int(input())
for i in range (0,t):
    x,y,k,n = map(int, input().split())
    l=0
    for j in range (0,n):
        p,pr=map(int, input().split())
        if p>=x-y and pr<=k:
           l=1
    if l==1:
        print("LuckyChef")
    else:
        print("UnluckyChef")