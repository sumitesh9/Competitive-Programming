n = int(input())
l = list(map(int, input().split(" ")))
sum = 0.0
for i in range(0,n):
    sum = sum + (1 / l[i])
sum = 1 / sum
print(sum)