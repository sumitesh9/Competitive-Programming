s=input()
c=0
for i in range(0,3):
	if(s[i]==s[i+1]):
		print("Bad")
		c=1
		break
if(c==0):
	print("Good")