import math
t = int(input())
for i in range(0, t):
    n = int(input())
    k = list(map(float, input().split(" ")))
    c = list(map(float, input().split(" ")))
    lambdasqr = 0.0
    sumk = 0.0
    sumck = 0.0
    sumc = sum(c)
    for j in range(0, n):
        sumk = sumk + (1 / k[j])
        sumck = sumck + (c[j]*k[j])
    if(int(sumck) == 0):
        print(0.0, end=" ")
        for j in range(0, n):
            print(0.0, end=" ")
    else:
        lambdasqr = sumk / (4.0*sumck)
        if(lambdasqr <= 0):
            print(-1)
        else:
            x = []
            for j in range(0, n):
                x.append((1.0 / (4.0*lambdasqr*k[j]*k[j])) - c[j])
            temp = 0.0
            for j in range(0, n):
                temp = temp + math.sqrt(x[j] + c[j])
            print(temp, end=" ")
            for j in range(0, n):
                if(j != n-1):
                    print(x[j], end=" ")
                else:
                    print(x[j])