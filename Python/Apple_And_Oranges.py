#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countApplesAndOranges function below.
def countApplesAndOranges(s,t,a,b,apples,oranges):
    ap=0
    ora=0
    for i, val in enumerate(apples):
        if(val+a>=s and val+a<=t):
            ap=ap+1
    for i, val in enumerate(oranges):
        if(val+b>=s and val+b<=t):
            ora=ora+1
    print(ap)
    print(ora)


s,t=map(int,input().split())
a,b=map(int,input().split())
m,n=map(int,input().split())
apples=list(map(int,input().split()))
oranges=list(map(int,input().split()))
countApplesAndOranges(s,t,a,b,apples,oranges)
