
# RECURSIVE SOLUTION

# Time Complexity: O(m * 2^n), m: no.of. columns, n: no.of.rows
# Space Complexity: No additional space except the space for Recursive stack
# Did problem run on Leetcode: yes, with TLE

class Solution:
    def minCost(self, costs):
        if not costs:
            return 0
        
        amount = float('inf')

        # Take one element from the 1st row, and call a recursive function with increasing i and amount calculated
        for j in range(0, len(costs)):             # j = 0, 1, 2
            amount = min(amount, self.helper(costs, 0, j, 0))
        return amount
        

    def helper(self, costs, i, j, amount):
        # BASE CASE,
        if i == len(costs):
            return amount

        # LOGIC,
        case1 = 0
        case2 = 0
        if j == 0:
            case1 += self.helper(costs, i+1, 1, costs[i][1]+amount)
            case2 += self.helper(costs, i+1, 2, costs[i][2]+amount)
        if j == 1:
            case1 += self.helper(costs, i+1, 0, costs[i][0]+amount)
            case2 += self.helper(costs, i+1, 2, costs[i][2]+amount)
        if j == 2:
            case1 += self.helper(costs, i+1, 0, costs[i][0]+amount)
            case2 += self.helper(costs, i+1, 1, costs[i][1]+amount)
            
        return min(case1, case2)


obj = Solution()
print(obj.minCost(costs=[[17,2,17],[16,16,5],[14,3,19]]))
