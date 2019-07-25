def maxCrossingSum(arr,l,m,h):
	sm=0;left_sum=-100000
	for i in range(m,l-1,-1):
		sm+=arr[i]
		if(sm>left_sum):
			left_sum=sm
	sm=0;right_sum=-100000
	for i in range(m+1,h+1):
		sm+=arr[i]
		if(sm>right_sum):
			right_sum=sm
	return left_sum+right_sum

def maxSubarray(arr,l,h):
	if(l==h):
		return arr[l]
	m=(l+h)//2
	return max(maxSubarray(arr,l,m),maxSubarray(arr,m+1,h),maxCrossingSum(arr,l,m,h))

t=int(input())
for i in range(0,t):
	arr=list(map(int,input().split()))
	print(maxSubarray(arr,0,len(arr)-1))