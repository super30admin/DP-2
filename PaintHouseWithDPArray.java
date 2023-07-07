// Time Complexity : O(n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
public class PaintHouseWithDPArray {

    public static int minCost(int[][] costs) {

       int houses = costs.length;
       int[][] dpArr = new int[houses][3];

       dpArr[houses-1][0] = costs[houses-1][0];
       dpArr[houses-1][1] = costs[houses-1][1];
       dpArr[houses-1][2] = costs[houses-1][2];
       for(int i=houses-2; i>=0; i--)
       {
           dpArr[i][0] = costs[i][0] + Math.min(dpArr[i+1][1],dpArr[i+1][2]);
           dpArr[i][1] = costs[i][1] + Math.min(dpArr[i+1][0],dpArr[i+1][2]);
           dpArr[i][2] = costs[i][2] + Math.min(dpArr[i+1][0],dpArr[i+1][1]);

       }
       return Math.min(dpArr[0][0],Math.min(dpArr[0][1],dpArr[0][2]));
    }

    public static void main(String args[])
    {
        int costs[][] = {{17,2,17},{16,16,5},{14,3,19}};
        int amount = 5;
        System.out.println(minCost(costs));
    }
}
