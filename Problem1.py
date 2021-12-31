# Time Complexity : Exponential time complexity.
# Space Complexity : Exponential space complexity.
# Did this code successfully run on Leetcode : Time limit exception.
# Any problem you faced while coding this : Arrived at the brute-force solution. I was not able to come up with DP splution.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        def helper(index,costs,amount,notAllowed):
            # base
            if index == len(costs):
                return amount

            # logic
            case1 = helper(index+1,costs,amount + costs[index][0],0)
            case2 = helper(index+1,costs,amount + costs[index][1],1)
            case3 = helper(index+1,costs,amount + costs[index][2],2)
            if notAllowed == 0 :
                return min(case2,case3)
            elif notAllowed == 1:
                return min(case1,case3)
            elif notAllowed == 2:
                return min(case1,case2)
            else:
                return min(case1,case2,case3)
        return helper(0,costs,0,-1)
