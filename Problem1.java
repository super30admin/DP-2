// Time Complexity : O(colours^houses)
// Space Complexity : O(colours)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :  This is Brute Force so Time limit exceed


// Simple Recursion with backtracking Top-Down Approach


class Solution1{
    public int housePaint(int[][] cost, int row,int prevHouseColour) {

        if(row==cost.length){
            return 0;
        }

        int minimum=Integer.MAX_VALUE;

        for(int j=0; j<cost[0].length; j++){

            // do not consider the colour if it has been used by the previous house

            if(j!=prevHouseColour){
                // cost required to paint the houses from here
                int minAmount= cost[row][j]+housePaint(cost,row+1,j);
                // update the minimum among the 2 paths
                minimum= Math.min(minAmount,minimum);
            }
        }
        //return the minimum cost to paint houses starting from here
        return minimum;
    }
}



// Time Complexity : O(colours*houses)
// Space Complexity : O(colours*houses)
// Did this code successfully run on Leetcode : No premium availble but ran on VS Code
// Any problem you faced while coding this :  No


// Bottom-Up Approach: Back to front
// We will maintain a 2d array for dp values.
// recursion dp at any house will return the minimum cost required to paint tall the houses until that point

class Solution2{
    public int housePaint(int[][] cost) {

        // we will store an extra so as to make dp[i+1][j] valid just like in house robber problem

        int[][] dp= new int[cost.length+1][cost[0].length];


        //start from the last house
        for(int i=cost.length-1; i>=0; i--){
            dp[i][0]= cost[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]= cost[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]= cost[i][2]+Math.min(dp[i+1][1],dp[i+1][0]);
        }
        //return the minimum of the first row
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}



// Bottom-Up Approach

// Time Complexity : O(colours*houses)
// Space Complexity : O(colours)
// Did this code successfully run on Leetcode : No premium availble but ran on VS Code
// Any problem you faced while coding this :  No

// We will maintain a 1d array for dp values instead of 2d array
// initially dp[] will contains values of last house since this is back-front method
// And a curr[] for current house will be computed using dp[] of next house

class Solution3 {
    
    public int housePaint(int[][] cost) {

        // storing the last house in dp

        int[] dp= cost[cost.length-1];


        for(int i=cost.length-2; i>=0; i--){

            //at this point dp[] will contains values of next row.
            //we will compute dp values for of i-th row using (i+1)th values i.e dp values from dp[] and cost[][]
            

            int[] curr= new int[cost.length];

            curr[0]= cost[i][0]+Math.min(dp[1],dp[2]);
            curr[1]= cost[i][1]+Math.min(dp[0],dp[2]);
            curr[2]= cost[i][2]+Math.min(dp[1],dp[0]);

            //update our dp from current
            
            dp=curr;
        }
        return Math.min(dp[0],Math.min(dp[1],dp[2]));
    }
}

public class Problem1{
    public static void main(String[] args) {
        int[][] cost= {{17,2,17},{16,16,5},{7,6,1}};
        Solution1 s1= new Solution1();
        System.out.println(s1.housePaint(cost,0,-1));
        Solution2 s2= new Solution2();
        System.out.println(s2.housePaint(cost));
        Solution3 s3= new Solution3();
        System.out.println(s3.housePaint(cost));
    }
}