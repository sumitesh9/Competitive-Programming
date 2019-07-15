t=int(input())
for i in range(0,t):
	n=int(input())
	l=list(map(int,input().split()))
	mean=sum(l)/len(l)
	if mean%1!=0:
		print("Impossible")
	else:
		flag=0
		for i in range(0,n):
			if(l[i]==mean):
				print(i+1)
				flag=1
				break
		if(flag==0):
			print("Impossible")