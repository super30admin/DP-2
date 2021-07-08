/**
 * Time complexity :  O(mxn)
 * Space Complexity : O(n)
 * leet code execution : successfull
 * Steps: Intialise DP matrix with size M x N where M is size of coins array and n is amount. for DP calculation 0 is added making the total size of DP matrix to be m+1 x n+1
 *                  Every value in matrix is calculated by dedcuting coin value from be preceeding value [it
 *                  s coin number]. during this procedure the above or previous coin-1 index value is also added. the last mxn will have the ans.
 */
class CoinChange518 {

    public int change(int arr[], int amt){
        if(arr==null) return 0;
        int m = arr.length;
        System.out.println("arr.length"+m);
        int n = amt;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<arr[i-1])
                    dp[i][j] =  dp[i-1][j];
                else 
                    dp[i][j] = dp[i-1][j]+dp[i][j-arr[i-1]];
            }
        }
        return dp[m][n];
    }


/** 
public int change(int arr[], int amt){

    return helper(arr,amt,0);

}




    private int helper(int j[], int amt, int i) {
        if(j.length==0||j==null) return 0;

        if(amt==0)return 1;
        if(amt < 0 ||i>=j.length) return 0;

        //base
    
        //logic
        int case1 = helper(j, amt-j[i], i);
        int case2 = helper( j,amt, i+1);
        return case1+case2;
    }
*/
    public static void main(String[] args) {
        CoinChange518 cc = new CoinChange518();
        int arr[] = {1,2,5};
        System.out.println(cc.change(arr, 5));

    }
}