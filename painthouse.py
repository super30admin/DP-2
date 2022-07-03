if (len(costs) == 0):
    print (0)
n =len(costs)
for i in range(n-2,0):
    costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2])
    costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2])
    costs[i][2] = costs[i][2] + min(costs[i+1][1],costs[i+1][0])
print ( min(costs[0][0]),min(costs[0][1]),min(costs[0][2]))