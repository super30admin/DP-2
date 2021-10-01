class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        
        dp[0]=costs[0];
        for(int i=1;i<costs.length;i++){
            dp[i][0]= costs[i][0]+  Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i][1]+ Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i][2]+ Math.min(dp[i-1][0],dp[i-1][1]);
        }
        int min= Math.min(dp[costs.length-1][0],dp[costs.length-1][1]);
        return Math.min(min,dp[costs.length-1][2]);
    }
}

//time complexity : O(n*3)=>O(n) where n is the no of houses and 3 are the colors of houses which is constant
//space complexity : O(n*3)=> O(n) where n is no of houses and 3 are the colors of houses which is constant
//ran successfully with leetcode 
//approach : DynamicProgramming --> Calculated the min by adding the current cost of the current house what we choose and adding the minimum of the previous 2 houses which color is different than the current color
//so that adjacent houses wont be having the same color
//Difficulties: Didnt faced any difficulties --struggled little bit for matrix and still dont know how to draw tree for this question

