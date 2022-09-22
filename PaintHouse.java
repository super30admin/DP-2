//time: O(n)
//Space: O(1)
public class Solution {
    public int MinCost(int[][] costs) {
        
        int min = Math.Min(costs[0][0], Math.Min(costs[0][1], costs[0][2]));
        for(int i=1; i < costs.Length; i++)
        {
            costs[i][0] = costs[i][0] + Math.Min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.Min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.Min(costs[i-1][0], costs[i-1][1]);
            
            min = Math.Min(costs[i][0], Math.Min(costs[i][1], costs[i][2]));
        }
        return min;
      
    }
}
