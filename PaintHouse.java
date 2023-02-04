public class PaintHouse {
    public static int painthouse(int[][] costs){
        int m = costs.length; // no of houses
        int n = 3;
        int[][] dp = new int[m][n];
        if(costs.length == 0||costs==null) return 0;
        for(int j = 0;j<n;j++){
            dp[0][j] = costs[0][j];
        }
        for(int i = 1;i<m;i++){
            dp[i][0] = costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        return Math.min(dp[m-1][0],Math.min(dp[m-1][1],dp[m-1][2]));
    }

    public static void main(String[] args) {
        System.out.println(PaintHouse.painthouse(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
