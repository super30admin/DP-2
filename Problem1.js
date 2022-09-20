var change = function(amount, coins) {
    if(coins.length == 0) return 0;
    let m = coins.length;
    let n = amount
    let dp = Array(m+1).fill().map(() => Array(n+1).fill(0));;
        
    for(let i=0;i<m+1;i++){
        dp[i][0] = 1;
    }
    for(let i=1;i<m+1;i++){
        for(let j=1;j<n+1;j++){
           if(j < coins[i-1]){
               dp[i][j] = dp[i-1][j]
           }else{
               dp[i][j]= dp[i-1][j] +  dp[i][j-coins[i-1]]
           }
        }
    }
    return dp[m][n];
};