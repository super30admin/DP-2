
//Time Complexity: O(n)
//Space Complexity:O(1)
class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;
        if(n==1)
            return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
       //r=0, g=1, b=2
        for(int i=1;i<n;i++)
        {
          // if i-1 house is painted red (i.e,0)
           costs[i][0]=Math.min(costs[i-1][1],costs[i-1][2])+costs[i][0];
            
             // if i-1 house is painted green (i.e,1)
             costs[i][1]=Math.min(costs[i-1][0],costs[i-1][2])+costs[i][1];
            
             // if i-1 house is painted blue (i.e,2)
             costs[i][2]=Math.min(costs[i-1][1],costs[i-1][0])+costs[i][2];
    
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    }
    
    /*
      Same code but when no. of colors is m
     public int minCost(int[][] costs) {
        int n=costs.length;
        if(n==1)
            return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
        int min=Integer.MAX_VALUE;
        int m=3;// no. of colors
        for(int i=1;i<n;i++)
        {
          
            for(int j=0;j<m;j++)
            {
                min=Integer.MAX_VALUE;
               for(int k=0;k<m;k++)
               {
                   if(j!=k)
                   min=Math.min(min,costs[i-1][k]);
               }
                costs[i][j]=costs[i][j]+min;
            }
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    }
    */
}