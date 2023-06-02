// Time Complexity : 2^n (exponential) n is the no. of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :yes(Time limit exceeded)


// Your code here along with comments explaining your approach
//Lets implement using recursion
//using recursion exhaustive approach
class Solution {
    public int minCost(int[][] costs) {
        //0->red, 1->green, 2-> blue
        int red = helper(costs,0,0,0);
        int green = helper(costs,0,1,0);
        int blue =   helper(costs,0,2,0);
        return Math.min(red, Math.min(green,blue));
        
    }
    private int helper(int[][] costs,int row, int color,int cost){
        //base
        if(row== costs.length){
            return cost;
        }
        //use 3 recursive functions and find the minimun from each recursive function.
        if(color==0){
            return Math.min(helper(costs,row+1,1,cost+costs[row][0]),helper(costs,row+1,2,cost+costs[row][0]));
        }
          if(color==1){
            return Math.min(helper(costs,row+1,0,cost+costs[row][1]),helper(costs,row+1,2,cost+costs[row][1]));
        }
         if(color==2){
            return Math.min(helper(costs,row+1,1,cost+costs[row][2]),helper(costs,row+1,0,cost+costs[row][2]));
        }
        return 5454;
    }
}

// Time Complexity : O(n) [ O(n*3) n is the no. of houses]
// Space Complexity : O(n) [ we are creating 2D DP array so O(n*3) n is the no. of houses]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Lets implement using 2D DP array where row has the no.of houses and column has the 3 colors where each cell represents the  cumulative cost.
/* We will use a bottom up approach.
1.Fill the last row in DP as is the costs array.
2. start from second last row and pick the minimum from the bottom row values apart from the same color and add min value to the cost
3. fill the remaining cells with same logic.

*/
class Solution {
    public int minCost(int[][] costs) {
    if( costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        for(int j=0;j<3;j++){
            //we ll start from the bottom so copy the last row of costs array into dp array
            dp[n-1][j] = costs[n-1][j];
        }
        //start from last second row
    for(int i = n-2; i>=0; i--){
        dp[i][0] =  costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
         dp[i][1] =  costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
             dp[i][2] =  costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
    }
    //since we used bottom up approach ,first row contains the minimum so look for minimum in first row and return.
return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
}
}



// Time Complexity : O(n) [ O(n*3) n is the no. of houses]
// Space Complexity : O(1) [since we are modifying the original costs array.]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Implement DP without building DP array and changing the original costs array. since the problem does not ask us to return the original costs array we can use this approach.
class Solution {
    public int minCost(int[][] costs) {
    if( costs == null || costs.length == 0) return 0;
        int n = costs.length;
        //start from last second row
    for(int i = n-2; i>=0; i--){
        costs[i][0] =  costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
         costs[i][1] =  costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
             costs[i][2] =  costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
    }
    //since we used bottom up approach ,first row contains the minimum so look for minimum in first row and return.
return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
}
}