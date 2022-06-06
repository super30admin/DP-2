public class PainHouse {
    //Time Complexity-O(n)
    //Space Complexity-O(1)
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0){
            return 0;
        }
        int n=costs.length;
        //int[][] dp=new int[n][3];

        // dp[n-1][0]=costs[n-1][0];
        // dp[n-1][1]=costs[n-1][1];
        // dp[n-1][2]=costs[n-1][2];

        int colorR=costs[n-1][0];
        int colorB=costs[n-1][1];
        int colorG=costs[n-1][2];

        for(int i=n-2;i>=0;i--){
            int tempR=colorR;
            int tempB=colorB;
            colorR=costs[i][0]+Math.min(colorB,colorG);
            colorB=costs[i][1]+Math.min(tempR,colorG);
            colorG=costs[i][2]+Math.min(tempR,tempB);

            // dp[i][0]=costs[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
            // dp[i][1]=costs[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
            // dp[i][2]=costs[i][2]+Math.min(dp[i+1][0],dp[i+1][1]);
        }

        // return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        return Math.min(colorR,Math.min(colorB,colorG));
    }
}
