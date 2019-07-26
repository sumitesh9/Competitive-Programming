n=int(input())
arr=list(map(int,input().split(" ")))
c=0
for i in range(1,n-1):
	if(arr[i]!=min(arr[i-1],arr[i],arr[i+1]) and arr[i]!=max(arr[i-1],arr[i],arr[i+1])):
		c=c+1
print(c)