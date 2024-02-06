//SC: O(1)
//TC: O(n)
Class Solution
{
public int minCost(int [][] costs)
{
int n=costs.length;
int costR=costs[0][0];
int costB=costs[0][1];
int costG=costs[0][2];
for(int i=1;i<n;i++ )
{
int tempR=costR;
costR=costs[i][0]+Math.min(costB,costG);
int tempB=costB;
costB=costs[i][1]+Math.min(tempR,costG);
costG=costs[i][2]+Math.min(tempR,tempB);
}
return Math.min(costR,Math.min(costB,costG));
}
}
