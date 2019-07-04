n=input()
if(len(n)<4):
    print("NO")
else:
    count=0
    for i in range(0,len(n)):
        if(n[i]=='4' or n[i]=='7'):
            count=count+1
    dig=0
    flag=0
    if(count==0):
        print("NO")
    else:
        while count>0:
            dig=count%10
            if(dig!=4 and dig!=7):
                flag=1
                break
            count=count//10
        if(flag==0):
            print("YES")
        else:
            print("NO")