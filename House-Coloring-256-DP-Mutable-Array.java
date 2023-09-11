class Solution {
    public int minCost(int[][] costs) {

        // If the costs array is null return 0

        if(costs==null || costs.length==0)
        {
            return 0;
        }

        int n = costs.length; 
        int colorRed = 0, colorBlue = 0, colorGreen = 0;
        if(n==1)
        {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }

        if(n>=2)
        {
            int row = n-2;

            while(row>=0)
            {
             
             costs[row][0] =  costs[row][0] + Math.min (costs[row+1][1], costs[row+1][2]); 
             costs[row][1] = costs[row][1] + Math.min (costs[row+1][0], costs[row+1][2]); 
             costs[row][2] = costs[row][2] + Math.min (costs[row+1][0], costs[row+1][1]); 
             System.out.println(row + " "+ colorRed + " "+ colorBlue+ " "+ colorGreen);
            row--;
            }
        }
        
      //return Math.min(colorRed,Math.min(colorBlue,colorGreen));
      return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));

    

}
}
