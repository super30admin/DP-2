# TC-O(n)
# SC-O(1)

def housecolor(costs):
    if len(costs)==0:
        return 0
    m=len(costs)
    for i in range(1,m):
        costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
        costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
        costs[i][2] += min(costs[i - 1][1], costs[i - 1][0])
    return min( costs[m-1][0], costs[m-1][1],  costs[m-1][2])

# given=[[17,2,17],[16,16,5],[14,3,19]]
# out=housecolor(given)
# print(out)
