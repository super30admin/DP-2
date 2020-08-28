// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
        if len(costs)==0: #checking edge case
            return 0
        for i in range(1,len(costs)): #comparing between the above houses costs,to find minimum
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][0],costs[i-1][1])
        print(costs)
        return min(costs[len(costs)-1]) # returning the minimum in last row  of houses since we have added the cost till now