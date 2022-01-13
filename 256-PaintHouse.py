#leetcode 256
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == None: return 0
        n = len(costs)
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][1], costs[i + 1][0])
        return min(costs[0][0], min(costs[0][1], costs[0][2]))
    
# T.C => O(n)
# S.C => O(1)
#Approach => we are starting from n -1 row to calculate the min and then decreasing the i or each row to calculate the min and storing it #in place. for ever 0 position the  newxt rows 1 and 2 are stored. Sacme aplies for position 1 and 2. 
#If we dont want to change it in place we  can allocate extra array and use that to store value