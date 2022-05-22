# Time Complexity : O(number of houses * number of colors)
# Space Complexity : O(number of colors)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def minCost(self, costs):
        dpArray = costs[0]
        for i in range(1,len(costs)):
            curr = [0]*len(costs)
            curr[0]= min(dpArray[1],dpArray[2]) + costs[i][0]
            curr[1]= min(dpArray[0],dpArray[2]) + costs[i][1]
            curr[2]= min(dpArray[0],dpArray[1]) + costs[i][2]
            dpArray = curr
        return min(dpArray[0], min(dpArray[1], dpArray[2]))

obj1 = Solution()
print(obj1.minCost([[17,2,17],[16,16,5],[14,3,19]]))
print(obj1.minCost([[7,6,2]]))