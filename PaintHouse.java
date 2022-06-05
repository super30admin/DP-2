// Time Complexity : O(N), where N is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class CoinChange2 {
    public int minCost(int[][] costs) {
        if(costs.length>1) {
            for(int i=1;i<costs.length;i++) {
                int num1 = costs[i-1][0];
                int num2 = costs[i-1][1];
                int num3 = costs[i-1][2];
                
                costs[i][0] += Math.min(num2,num3); 
                costs[i][1] += Math.min(num1,num3); 
                costs[i][2] += Math.min(num2,num1); 
            }
        }
        
        int n = costs.length-1;
        
        return Math.min(costs[n][0], Math.min(costs[n][1],costs[n][2]));
    }
}
