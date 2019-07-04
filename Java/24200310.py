t=int(input())
for i in range (0,t):
    n=int(input())
    w=list(map(int, input().split()))
    temp=min(w)
    sum=0
    for j in w:
        sum+=j-temp
    print(sum)