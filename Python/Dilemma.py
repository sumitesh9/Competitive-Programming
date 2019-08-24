t=int(input())
for i in range(0,t):
	s=input()
	res=int(s[0])
	for j in range(1,len(s)):
		res=res^int(s[j])
	if(res==0):
		print("LOSE")
	else:
		print("WIN")