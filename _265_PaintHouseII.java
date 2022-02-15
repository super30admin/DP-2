// space complexity - o(n*k)
    //time - o(n*k)
    //Ran on leeetcode successfully : Yes
    // Problem faced  : No
    //Approach : take a 2d dp array, the value of cell will be equal to sum of cost of painting by the current cell and
    //minimum the cost of painting the house from previous row of different color.
    //Now since there are k houses, maintain two variable for mincost1 and mincost2 for the previous row.

class Solution {
    public int minCostII(int[][] costs) {

        int[][] dp = new int[costs.length][costs[0].length];

        int minRow1 = Integer.MAX_VALUE;
        int minColorRow1 = -1;
        int minRow2 = Integer.MAX_VALUE;
        int minColorRow2 = -1;

        for(int i=0; i<dp.length; i++){

            int min1 = Integer.MAX_VALUE;
            int minColor1 = -1;
            int min2 = Integer.MAX_VALUE;
            int minColor2 = -1;

            for(int j=0; j<costs[0].length; j++){

                if(i==0){
                    dp[i][j] = costs[i][j];
                }
                else{
                 if(j != minColorRow1) {
                     dp[i][j] = minRow1 + costs[i][j];
                 }
                 else{
                    dp[i][j] = minRow2 + costs[i][j];
                 }

                }
                if(min1 >= dp[i][j]){
                    min2 = min1;
                    minColor2 = minColor1;
                    min1 = dp[i][j];
                    minColor1 = j;
                }
                else if(min2 >= dp[i][j]){
                    min2 = dp[i][j];
                    minColor2 = j;
                }
            }
            minRow1 = min1;
            minColorRow1 = minColor1;
            minRow2 = min2;
            minColorRow2 = minColor2;
        }
        return minRow1;
    }

    //Same as above but with constant space , no need for dp array
    // space complexity - o(1)
        //time - o(n*k)
        //Ran on leeetcode successfully : Yes
        // Problem faced  : No
        //Approach : take a 2d dp array, the value of cell will be equal to sum of cost of painting by the current cell and
        //minimum the cost of painting the house from previous row of different color.
        //Now since there are k houses, maintain two variable for mincost1 and mincost2 for the previous row.

    public int minCostII(int[][] costs) {



        int minRow1 = Integer.MAX_VALUE;
        int minColorRow1 = -1;
        int minRow2 = Integer.MAX_VALUE;
        int minColorRow2 = -1;

        for(int i=0; i<costs.length; i++){

            int min1 = Integer.MAX_VALUE;
            int minColor1 = -1;
            int min2 = Integer.MAX_VALUE;
            int minColor2 = -1;

            for(int j=0; j<costs[0].length; j++){

                int temp = -1;

                if(i==0){
                    temp = costs[i][j];
                }
                else{
                 if(j != minColorRow1) {
                     temp = minRow1 + costs[i][j];
                 }
                 else{
                    temp = minRow2 + costs[i][j];
                 }

                }
                if(min1 >= temp){
                    min2 = min1;
                    minColor2 = minColor1;
                    min1 = temp;
                    minColor1 = j;
                }
                else if(min2 >= temp){
                    min2 = temp;
                    minColor2 = j;
                }
            }
            minRow1 = min1;
            minColorRow1 = minColor1;
            minRow2 = min2;
            minColorRow2 = minColor2;
        }
        return minRow1;
    }
}
