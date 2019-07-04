t=int(input())
for i in range (0,t):
    n, k=map(int, input().split())
    s=list(map(int, input().split()))
    sum1=sum(s)
    if(sum1<=k):
        print("Yes")
    else:
        print("No")			