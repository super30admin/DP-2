#Time complexity: O(n) where  n is the number of houses
#Space complexity: O(1) as the colors are only 3
#Works on leetcode: yes
#Approach:Here dp is just a tuple of 3 cost values. At each house, we get minimum cost for all 3 colors which is achieved by
# adding current cost of one color and minimum of costs from other two colors from previous house. 
class Solution:
	#function to find the minimum cost to paint houses using 3 colors given no adjacent house has same colors
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        dp = costs[0]
        for i in range(1,len(costs)):
            prev = dp[:]
            for j in range(len(costs[0])):
                dp[j] = costs[i][j] + min(prev[:j]+prev[j+1:])
        return min(dp)
    #Base recurive method
    def minCost2(self, costs: List[List[int]]) -> int:
        case1 = self.helper(costs,0,0,0)
        case2 = self.helper(costs,0,0,1)
        case3 = self.helper(costs,0,0,2)
        return min(case1, case2, case3)
    #helper recursive function for base solution
    # Time = O(2^n)
    # Space = O(n) for recursive stack
    def helper(self, costs, minn, row, lastcolor):
        if row==len(costs):
            return minn
        case1, case2, case3 = float('inf'), float('inf'), float('inf')
        if lastcolor==0:
            case1 = min(self.helper(costs, minn+costs[row][1], row+1, 1), self.helper(costs, minn+costs[row][2], row+1, 2))
        if lastcolor==1:
            case2 = min(self.helper(costs, minn+costs[row][0], row+1, 0), self.helper(costs, minn+costs[row][2], row+1, 2))
        if lastcolor==2:
            case3 = min(self.helper(costs, minn+costs[row][0], row+1, 0), self.helper(costs, minn+costs[row][1], row+1, 1))
        return min(case1, case2, case3)