
// Time Complexity : o(m*n)---> O(N)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

func change(amount int, coins []int) int {
    if len(coins) == 0{
        return 0
    }
    
    
    m := len(coins) //rows
    n := amount //columns
 
    
    dp := make([][]int,m+1)//rows
    for i,_ := range(dp){
        dp[i] = make([]int,n+1)//columns
    }
    
    for i:=0;i<m+1;i++{
        dp[i][0] = 1
    }
    
    for i:=1;i<m+1;i++{
        for j:=1;j<n+1;j++{
            if j < coins[i-1]{
                dp[i][j] = dp[i-1][j]
            }else{
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
            }
            
        }
    }
    
    return dp[m][n]
}
