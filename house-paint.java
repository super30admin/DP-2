//Time Complexity: O(N*C) C being the number of colors
class Solution
{
    public int minCost(int[][] costs)
    {
        if(costs.length == 0)
            return 0;
        int lastR = cost[0][0];
        int lastB = cost[0][1];
        int lastG = cost[0][2];
        for(int i =0; i< costs.length; i++)
        {
            int curR = Math.min(lastG,lastB) + costs[i][0];
            int curB = Math.min(lastR,lastG) + costs[i][1];
            int curG = Math.min(lastR,lastB) + costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(Math.min(lastR,lastB),lastG);
    }
}