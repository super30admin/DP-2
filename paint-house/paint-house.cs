public class Solution {
    public int MinCost(int[][] costs) {
        if(costs == null || costs.Length == 0)
        {
            return 0;
        }
        
        for(int i = 1; i<costs.Length;i++)
        {
           costs[i][0] += Math.Min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.Min(costs[i-1][2],costs[i-1][0]);
            costs[i][2] += Math.Min(costs[i-1][1],costs[i-1][0]);
        }
        
        int min = Int32.MaxValue;
        foreach(int i in costs[costs.Length-1])
        {
            min = Math.Min(min,i);
        }
        return min;
        
    }
}
