n = int(input())
l = list(map(int, input().split(" ")))
res = 0
current = l[0]
currentans = 0
for i in range(1, n):
    if(l[i] <= current):
        currentans = currentans + 1
        if(currentans > res):
            res = currentans
    else:
        currentans = 0
    current = l[i]
print(res)
