{
if(costs == null || costs.length == 0) return 0;
int n = costs.length;

int[] dp = new int[3];

dp[0] = costs[n-1][0];
dp[1] = costs[n-1][1];
dp[2] = costs[n-1][2];

for (int i = n-2; i >=0; i--){
int tempR = dp[0];

dp[0] = Math.min( dp[1], dp[2])+ costs [i] [0];
int tempB = dp[1];
dp[1] = Math.min( tempR, dp[2])+ costs [i] [1];
dp[2] = Math.min( tempB, dp[0])+ costs [i] [2];

}
return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
}

