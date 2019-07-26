s=input()
h=set()
for i in range(0,len(s)):
	h.add(s[i])
if(len(h)==2):
	print("Yes")
else:
	print("No")