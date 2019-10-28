n = int(input())
l = []
for i in range(0, n):
	t = int(input())
	l.append(t)
l.sort(reverse = True)
m = 0
curr = 0
ind = 1
for i in l:
	curr = i * ind
	if(curr > m):
		m = curr
	ind += 1
print(m)