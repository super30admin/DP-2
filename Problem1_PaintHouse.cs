// Approach : bottom up dp
// Time Complexity: O(n) where n is the number of houses
// Space Complexity: O(n)
public class Solution {
    public int MinCost(int[][] costs) {
        int n = costs.Length;
        int[][] min = new int[n][];
        min[0] = costs[0];
        
        // min[i][j] represents the minimum cost to paint houses from 0 to i, ending with the ith house as color j (R, G, B)
        for(int i=1; i<n; i++){
            min[i] = new int[3];
            
            //red
            min[i][0] = costs[i][0] + Math.Min(min[i-1][1], min[i-1][2]);
            
            //blue
            min[i][1] = costs[i][1] + Math.Min(min[i-1][0], min[i-1][2]);
            
            //green
            min[i][2] = costs[i][2] + Math.Min(min[i-1][1], min[i-1][0]);
        }
        
        return Math.Min(min[n-1][0], Math.Min(min[n-1][1], min[n-1][2]));
    }
}
