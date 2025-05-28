class PaintHouse {
    
    public int minCost(int[][] costs) {

        int n = costs.length;

       // int[][] dp = new int[n][3];
        int redPaint = costs[n-1][0];
        int bluePaint = costs[n-1][1];
        int greenPaint = costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tempRed = redPaint;
            redPaint = costs[i][0]+Math.min(bluePaint,greenPaint);
            int tempBlue = bluePaint;
            bluePaint = costs[i][1]+Math.min(tempRed,greenPaint);
            greenPaint = costs[i][2]+Math.min(tempBlue,tempRed);
        }

        return Math.min(redPaint,Math.min(bluePaint,greenPaint));

    }
    //time complexity : O(n)
    //space complexity : O(n)
    // public int minCost(int[][] costs) {

    //     int n = costs.length;

    //     int[][] dp = new int[n][3];
    //     dp[n-1][0] = costs[n-1][0];
    //     dp[n-1][1] = costs[n-1][1];
    //     dp[n-1][2] = costs[n-1][2];

    //     for(int i=n-2;i>=0;i--){
    //         dp[i][0] = costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
    //         dp[i][1] = costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
    //         dp[i][2] = costs[i][2]+Math.min(dp[i+1][1],dp[i+1][0]);
    //     }

    //     return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));

    // }

    //time complxity : O(2^n) -> m*2^n -> m is number of colors
    // private int helper(int[][] costs, int idx, int color){
    //     //base
    //     if(idx==costs.length) return 0;
    //     //logic
    //     //toChoose 
    //     if(color==0){
    //         //blue
    //       return costs[idx][0] + Math.min(helper(costs,idx+1,1),helper(costs,idx+1,2));
    //         //green

    //     }
    //     if(color==1){
    //         return costs[idx][1] + Math.min(helper(costs,idx+1,0),helper(costs,idx+1,2));
         
    //     }
    //     if(color==2){
    //         return costs[idx][2] + Math.min(helper(costs,idx+1,1),helper(costs,idx+1,0));
         
    //     }

    //     return -1;
    // }

    // public int minCost(int[][] costs) {

    //     int paintRed = helper(costs, 0, 0);
    //     int paintBlue = helper(costs, 0, 1);
    //     int paintGreen = helper(costs, 0, 2);

    //     return Math.min(paintRed, Math.min(paintBlue, paintGreen));

    // }