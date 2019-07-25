t=int(input())
for i in range(0,t):
	str=input()
	c=0
	for j in range(0,len(str)):
		ch=str[j]
		if(ch=='a' or ch=='e' or ch=='i' or ch=='o' or ch=='u' or ch=='A' or ch=='E' or ch=='I' or ch=='O' or ch=='U'):
			c=c+(len(str)-j)*(j+1)
	print(c)