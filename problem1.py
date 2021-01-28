// Time Complexity : O(n)
// Space Complexity : O(1)      //as we are modifying the input list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs)==0 or len(costs[0])==0 :
            return 0
        n=len(costs)
        m=len(costs[0])
        
        for i in range(1,n):
            #Red
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2])       //total cost for choosing red colour for current house will be equals to cost of choosing red house + minimum of cost of other two colous for previous house
            #Blue
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])       //total cost for choosing Blue colour for current house will be equals to cost of choosing Blue house + minimum of cost of other two colous for previous house
            #Green
            costs[i][2]+=min(costs[i-1][0],costs[i-1][1])     //total cost for choosing green colour for current house will be equals to cost of choosing green house + minimum of cost of other two colous for previous house
                
        return min(costs[n-1][0],min(costs[n-1][1],costs[n-1][2]))    //total price will be minimum of all three colors for last house
