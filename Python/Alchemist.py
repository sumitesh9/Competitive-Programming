n = int(input())
l = list(map(int, input().split(" ")))
l.sort()
sum = l[0]
for i in range(1 , n):
    sum = ((sum + l[i]) / 2);
print(sum)