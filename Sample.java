//--------------PAINT HOUSE-----------------------//
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : to come up with O(1) space solution where we needed, temp- after numerous sysout, found out where i was wrong


// Your code here along with comments explaining your approach
//exhaustive //recursive
    // public int minCost(int[][] costs) {
    //    if(costs==null || costs.length==0) return 0;
    //    int colR= helper(costs, 0, 0, 0); // choose color red in top row
    //    int colB= helper(costs, 0, 1, 0); // choose color blue in top row
    //    int colG= helper(costs, 0, 2, 0); // choose color green in top row
    //    return Math.min(colR,Math.min(colB,colG));
    // }
    // private int helper(int[][] costs, int i, int color, int minCost){
    //     //base
    //     if(i==costs.length)
    //         return minCost;

    //     //logic
    //     if(color==0){
    //         //helper(costs, i+1, 1, minCost+ costs[i][0]); // total min cost is next recursion mincost + current cost = costs[i][0];

    //         //helper(costs, i+1, 1, minCost+ costs[i][0]);
    //         return Math.min(helper(costs, i+1,  1,minCost+ costs[i][0]),
    //         helper(costs, i+1, 2, minCost+ costs[i][0]));
    //     }

    //     if(color==1){
    //         //helper(costs, i+1, 1, minCost+ costs[i][0]); // total min cost is next recursion mincost + current cost = costs[i][0];

    //         //helper(costs, i+1, 1, minCost+ costs[i][0]);
    //         return Math.min(helper(costs, i+1, 0, minCost+ costs[i][1]),
    //         helper(costs, i+1, 2, minCost+ costs[i][1]));
    //     }

    //     if(color==2){
    //         //helper(costs, i+1, 1, minCost+ costs[i][0]); // total min cost is next recursion mincost + current cost = costs[i][0];

    //         //helper(costs, i+1, 1, minCost+ costs[i][0]);
    //         return Math.min(helper(costs, i+1, 0, minCost+ costs[i][2]),
    //         helper(costs, i+1, 1, minCost+ costs[i][2]));
    //     }
    //     return 272;
    // }

    //dp 
    // public int minCost(int[][] costs) {
    //     if(costs==null || costs.length==0) return 0;
    //     int n=costs.length;
    //     int[][] dp= new int[n][3];

    //     //putting up bottom row at first
    //     dp[n-1][0]=costs[n-1][0];
    //     dp[n-1][1]=costs[n-1][1];
    //     dp[n-1][2]=costs[n-1][2];


    //     for(int i=n-2;i>=0;i--){
    //         //starts with i=1(mid row) and checks for i+1 row minimum of different columns

    //         //column 1
    //         dp[i][0]=costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
    //         //column 2
    //         dp[i][1]= costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
    //         //column 3
    //         dp[i][2]= costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
    //     }

    //     //return minimum of top row which is best possible value of painting houses
    //     return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    // }

    // //dp with single array
    // public int minCost(int[][] costs) {
    //     if(costs==null || costs.length==0) return 0;
    //     int n=costs.length;
    //     int[] dp= new int[3];
    //     dp[0]=costs[n-1][0];
    //     dp[1]=costs[n-1][1];
    //     dp[2]=costs[n-1][2];

    //     for(int i=n-2;i>=0;i--){
    //         int temp1= dp[0];
    //         dp[0]=costs[i][0] + Math.min(dp[1],dp[2]);
    //         int temp2= dp[1];
    //         dp[1]= costs[i][1] + Math.min(temp1,dp[2]);
    //         dp[2]= costs[i][2] + Math.min(temp1,temp2);
    //     }
    //     return Math.min(dp[0], Math.min(dp[1],dp[2]));
    // }

    //dp with no extra space
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n=costs.length;
        //int[] dp= new int[3];
        int costR=costs[n-1][0];
        int costB=costs[n-1][1];
        int costG=costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tempR= costR;
            costR=costs[i][0] + Math.min(costB,costG);
            int tempB= costB;
            costB= costs[i][1] + Math.min(tempR,costG);
            costG= costs[i][2] + Math.min(tempR,tempB);
        }
        return Math.min(costR, Math.min(costB,costG));
    }

    // //dp with paths
    // public int minCost(int[][] costs) {
    //     if(costs==null || costs.length==0) return 0;
    //     int n=costs.length;
    //     int[][] dp= new int[n][3];
    //     int[][] path= new int[n][3];

    //     //putting up bottom row at first
    //     dp[n-1][0]=costs[n-1][0];
    //     dp[n-1][1]=costs[n-1][1];
    //     dp[n-1][2]=costs[n-1][2];
    //     path[n-1][0]=0;
    //     path[n-1][1]=0;
    //     path[n-1][2]=0;


    //     for(int i=n-2;i>=0;i--){
    //         //starts with i=1(mid row) and checks for i+1 row minimum of different columns

    //         //column 1
    //         //dp[i][0]=costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
    //         if(dp[i+1][1]<dp[i+1][2]){
    //             dp[i][0]=costs[i][0]+ dp[i+1][1];
    //             path[i][0]=1;
    //         }
    //         else{
    //             dp[i][0]=costs[i][0]+ dp[i+1][2];
    //             path[i][0]=2;
    //         }

    //         //column 2
    //         //dp[i][1]= costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
    //         if(dp[i+1][0]<dp[i+1][2]){
    //             dp[i][1]=costs[i][1]+ dp[i+1][0];
    //             path[i][1]=0;
    //         }
    //         else{
    //             dp[i][1]=costs[i][1]+ dp[i+1][2];
    //             path[i][1]=2;
    //         }
    //         //column 3
    //         //dp[i][2]= costs[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
    //         if(dp[i+1][0]<dp[i+1][1]){
    //             dp[i][2]=costs[i][2]+ dp[i+1][0];
    //             path[i][2]=0;
    //         }
    //         else{
    //             dp[i][2]=costs[i][2]+ dp[i+1][1];
    //             path[i][2]=1;
    //         }
    //     }
    //     // print path matrix
    //     for (int i = 0; i < path.length; i++){
 
    //         // Loop through all elements of current row
    //         for (int j = 0; j < path[i].length; j++)
    //             System.out.print(path[i][j] + " ");
    //         System.out.println();
    //     }

    //     //return minimum of top row which is best possible value of painting houses
    //     return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    // }