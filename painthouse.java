//TC:O(n)
//SC:O(1)
//successfully ran on leetcode
class Solution
{
public int minCost(int[][] costs)
{
if(costs==null ||  costs.length==0 || costs[0].length==0)
  return 0;

int n=costs.length;

for(int i=1;i<n;i++)
{
  //cost of red
  cost[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
  //cost of green
  cost[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
  //cost of blue
  cost[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
}
//min of last row for all 3 colors
return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
}
}
