#As taught in class,  the problem can be solved recursively by calculating the minimum of any of the two cases that occur while calculating the csrt
#Time Complexity: O(m*2^n)
#Space Complexity: O(n)
def paint(costs):
    if costs is None or len(costs)==0: return 0
    case1 = helper(costs,0,0,0)
    case2 = helper(costs,0,1,0)
    case3 = helper(costs,0,2,0)
    return min(case1,case2,case3)

def helper(cost,row,lastColor,mini):
    if (row==len(cost)):
        return mini


    case1 = 9999
    case2 = 9999
    case3 = 9999
    if (lastColor==0):
        case2 = helper(costs,row+1,1,mini+cost[row][1])
        case3 = helper(costs,row+1,2,mini+cost[row][2])
    if (lastColor==1):
        case1 = helper(costs,row+1,1,mini+cost[row][0])
        case3 = helper(costs,row+1,2,mini+cost[row][2])
    if (lastColor==2):
        case1 = helper(costs,row+1,1,mini+cost[row][0])
        case2 = helper(costs,row+1,2,mini+cost[row][1])
    return min(case1,case2,case3)

costs = [[7,6,2]]
cost = paint(costs)
print(cost)
