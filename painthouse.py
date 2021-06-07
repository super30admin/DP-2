# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def painthouse(costs):
        #manipulate the input matrix to get min amount

        if len(costs)==0:
            return 0
        
        for i in range(len(costs)-2,-1,-1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0],costs[i+1][1])
            

        return min(costs[0])

costs = [[17,2,11],[16,5,20],[14,13,19]]
print(Solution.painthouse(costs))