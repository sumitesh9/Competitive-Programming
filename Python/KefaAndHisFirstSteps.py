n = int(input())
l = list(map(int, input().split(" ")))
le = 1
m = 1
for i in range(1 , n):
	if(l[i] >= l[i - 1]):
		le = le + 1
	else:
		le = 1
	if(le > m):
		m = le
print(m)