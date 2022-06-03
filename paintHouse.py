# time complexity is o(n), where n is the number of houses
# space complexity is o(1)

l = [[7, 2, 17], [35,6,25],[14,39,19],[20,1,31]]
def mincost(l):
    houses=len(l)
    colorR = l[len(l)-1][0]
    colorG = l[len(l)-1][1]
    colorB = l[len(l)-1][2]
    for i in range(houses-2,-1,-1):
        tempR = colorR
        tempG = colorG
        tempB = colorB
        colorR = l[i][0] + min(tempG, tempB)
        colorG = l[i][1] + min(tempR,tempB)
        colorB = l[i][2] + min(tempR,tempG)
    return min(colorR, colorG, colorB)
print(mincost(l))