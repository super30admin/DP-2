// Time Complexity: O(m * n)
// Space Complexity: O(m * n) m and n are matrix indexes
class Solution {
    public int minCost(int[][] costs) {
        int [][] dp = new int[costs.length][costs[0].length];
        for (int i=0; i<costs[0].length; i++){
            dp[0][i] = costs[0][i];
        }
        for (int i=1;i < costs.length; i++) {
            for (int j=0; j < costs[0].length; j++){
                if (j==0){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                }
                if (j==1){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                }
                if (j==2){
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        int answer = 0;
        answer = Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]);
        answer = Math.min(answer, dp[costs.length - 1][2]);
        return answer;

    }
}