
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
public class PaintHouse{
    public int minPaint(int [][] cost){
        if(cost.length==0|| cost==null){
            return 0;
        }
        int n=cost.length;
        int dp[][]=new int[n][3];
        for(int i=0;i<cost.length;i++){
            dp[n-1][i]=cost[n-1][i];

        }
        for(int i=n-2;i>=0;i--){
            dp[i][0]=cost[i][0]+Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1]=cost[i][1]+Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2]=cost[i][2]+Math.min(dp[i+1][1],dp[i+1][0]);
        }
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }


    public static void main(String[] args) {
        PaintHouse obj=new PaintHouse();
        int coins[][]={{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(obj.minPaint(coins));
    }
}