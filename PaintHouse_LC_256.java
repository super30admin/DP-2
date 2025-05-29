public class PaintHouse_LC_256 {

/*
Exhaustive Solution
Time complexity - 2^n * colors which is 3* 2^n for every color we have two choices for all n items in the costs array
Space Complexity - O(1)
*/
    public int minCost(int[][] costs) {
        int colorR = helper(costs, 0, 0); //0 - index 0 - color
        int colorB = helper(costs, 0, 1); //1 == color
        int colorG = helper(costs, 0, 2);
        return Math.min(colorR, Math.min(colorB,colorG));
    }
    //index is on house
    private int helper(int [][] costs, int index, int color){
        //base condition
        if(index == costs.length) return 0;
        if(color == 0) {
            int caseB = helper(costs, index+1, 1);
            int caseG = helper(costs, index+1, 2);
            return costs[index][0] + Math.min(caseB, caseG);
        }
        if(color == 1) {
            int caseR = helper(costs, index+1, 0);
            int caseG = helper(costs, index+1, 2);
            return costs[index][1] + Math.min(caseR, caseG);
        }

        if(color == 2) {
            int caseR = helper(costs, index+1, 0);
            int caseB = helper(costs, index+1, 1);
            return costs[index][2] + Math.min(caseR, caseB);
        }
        return 686968696; //dummy , we will never reach here
    }
}

/*
Tabulation - Bottom up
Time Complexity -  O(3N) 3 colors and N is the length of costs
Space Complexity - O(3N)
*/
class SolutionBottomUP {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int dp[][] = new int[n][3]; //cost length rows and 3 columns
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i = n-2; i>= 0 ; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][1], Math.min(dp[0][2], dp[0][0]));
    }
}