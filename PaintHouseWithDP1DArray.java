// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class PaintHouseWithDP1DArray {

    public static int minCost(int[][] costs) {

        int houses = costs.length ;
        int[] dpArr = new int[costs[0].length];

        dpArr[0] = costs[houses-1][0];
        dpArr[1] = costs[houses-1][1];
        dpArr[2] = costs[houses-1][2];

        for(int i=houses-2; i>=0; i--)
        {
            int tempR = costs[i][0] + Math.min(dpArr[1],dpArr[2]);
            int tempG = costs[i][1] + Math.min(dpArr[0],dpArr[2]);
            int tempB = costs[i][2] + Math.min(dpArr[0],dpArr[1]);

            dpArr[0] = tempR;
            dpArr[1] = tempG;
            dpArr[2] = tempB;
        }
        return Math.min(dpArr[0],Math.min(dpArr[1],dpArr[2]));

    }
        public static void main(String args[])
    {
        int costs[][] = {{17,2,17},{16,16,5},{14,3,19}};
        int amount = 5;
        System.out.println(minCost(costs));
    }
}
