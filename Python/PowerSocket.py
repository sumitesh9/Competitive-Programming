import math
a , b = map(int, input().split(" "))
c = 0
ans = 0
if(b == 1):
    print(0)
else:
    for i in range(0, 50):
        if(i == 0):
            c = c + a
            ans = ans + 1
        else:
            c = c + a - 1
            ans = ans + 1
        if(c >= b):
            break
    print(ans)