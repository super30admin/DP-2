Time Complexity-O(m*n)
Space Complexity-O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;
        int red=costs[0][0],blue=costs[0][1],green=costs[0][2];
        for(int i=1;i<costs.length;i++)
        {
            int cred =costs[i][0]+Math.min(blue,green);
            int cblue =costs[i][1]+Math.min(red,green);
            int cgreen =costs[i][2]+Math.min(red,blue);
            red=cred;blue=cblue;green=cgreen;
            
        }
        
        
        return Math.min(red,Math.min(blue,green));
    }
}
