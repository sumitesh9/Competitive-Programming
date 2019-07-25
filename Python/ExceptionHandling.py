n=int(input())
l=[]
for i in range(n):
	l.append(int(input()))
copy=sorted(l,reverse=True)
for i in range(n):
	if(copy[0]==l[i]):
		print(copy[1])
	else:
		print(copy[0])