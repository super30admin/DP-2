// Time Complexity : The time complexity is O(n) where n is the number of houses.
// Space Complexity : The space Complexity is O(n) where n is the number of houses.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {

        if(costs.length == 0 || costs[0].length == 0){
            return 0;
        }

        // Array which stores the optimal costs for every house
        int[][] dp = new int[costs.length+1][costs[0].length];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i=0;i<costs.length;i++){

            // The cost of current house depends on the cost of previous houses painted
            dp[i+1][0] = costs[i][0] + Math.min(dp[i][1],dp[i][2]);
            dp[i+1][1] = costs[i][1] + Math.min(dp[i][0],dp[i][2]);
            dp[i+1][2] = costs[i][2] + Math.min(dp[i][0],dp[i][1]);

        }

        return Math.min(dp[costs.length][0],Math.min(dp[costs.length][1],dp[costs.length][2]));

    }

}

// Time Complexity : The time complexity is 2^n where n is the number of houses.
// Space Complexity : The space complexity is O(n) since we use an internal stack for recursive calls.
// Did this code successfully run on Leetcode : No(Time Limit Exceeded)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {

        if(costs.length == 0 || costs[0].length == 0){
            return 0;
        }

        return recursive(costs,0,-1);

    }

    public int recursive(int[][] costs,int index,int prev){

        if(index == costs.length){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<costs[0].length;i++){

            // The next colour of the house should be defferent from that of the previous
            if(i != prev){
                // Minimum cost to paint the house
                min = Math.min(min,recursive(costs,index+1,i)+costs[index][i]);
            }

        }

        return min;
    }
}
