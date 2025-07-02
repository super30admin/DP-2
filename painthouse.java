// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Appproach;Start from the second-last house and move upward (bottom-up DP).
// For each color in the current house, add the minimum cost of painting the next house with a different color.
// Update the current house's cost with this new value.
// Finally, return the minimum of the three costs at the top (first) house.
class Solution{
    public int minCost(int [][] costs){
        if(costs==null || costs.length==0){
            return 0;
        }
        int n=costs.length;
        for(int i=n-2;i>=0;i--){
        costs[i][0]= costs[i][0]+Math.min(costs[i+1][1] ,costs [i+1][2]);
        costs[i][1]= costs[i][1]+Math.min(costs[i+1][0] ,costs [i+1][2]);
        costs[i][2]= costs[i][2]+Math.min(costs[i+1][0] ,costs [i+1][1]);

        }
        return Math.min(costs[0][0] , Math.min(costs[0][1], costs[0][2]));
    }
}
public class painthouse{
    public static void main(String[] args) {
        int[][] costs = {
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}
        };

        Solution sol = new Solution();
        int result = sol.minCost(costs);
        System.out.println("Minimum cost to paint all houses: " + result);
    }
}