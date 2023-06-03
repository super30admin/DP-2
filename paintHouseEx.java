class Solution {
    public int minCost(int[][] costs)
    {
        int costsR = helper(costs,0,0,0); //0
        int costsB = helper(costs,0,1,0); //1
        int costsG = helper(costs,0,2,0); //2
        return Math.min(costsR, Math.min(costsB,costsG));
    }
    private int helper(int[][] costs, int i, int color, int amount)
    {
          //base
          if (i == costs.length) return amount;
          //logic
          if(color == 0)
          {
            return Math.min(helper(costs, i+1, 1, amount+costs[i][0]),helper(costs, i+1, 2, amount+costs[i][0]));

          }
          if(color == 1)
          {
            return Math.min(helper(costs, i+1, 0, amount+costs[i][1]),helper(costs, i+1, 2, amount+costs[i][1]));

          }
          if(color == 2)
          {
            return Math.min(helper(costs, i+1, 0, amount+costs[i][2]),helper(costs, i+1, 1, amount+costs[i][2]));

          }
          return 8282;
    }
}