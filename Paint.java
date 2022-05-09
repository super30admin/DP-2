// Time Complexity : O(n) where n= no of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class Paint {
    public int minCost(int[][] costs){
        int n = costs.length;
        costR= costs[n-1][0];
        costB= costs[n-1][0];
        costG= costs[n-1][0];

        for(int i=n-2; i>=0; i--){
            int temp= costR;
            int temp1 = costB;
            costR = cost[i][0]+ Math.min(costB, costG);
            costB = cost[i][1] + Math.min(temp,costG);
            costG = cost[i][2] + Math.min(temp,temp1);
        }
        return Math.min(costB, Math.min(costG, costR));
    }
}
