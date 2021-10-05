class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int m = costs.size(); 
        int n = 3;
        int dp[m][n];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0){
                    dp[i][j] = min(dp[i-1][1], dp[i-1][2])+costs[i][j];
                }
                else if(j==1){
                    dp[i][j] = min(dp[i-1][0], dp[i-1][2])+costs[i][j];
                }
                else if(j==2){
                    dp[i][j] = min(dp[i-1][1], dp[i-1][0])+costs[i][j];
                }
            }
        }
        
        return min(min(dp[m-1][0], dp[m-1][1]), dp[m-1][2]);
    }
};

// TC: (3 * n) where n is the number of houses
// SC: (3 * n)
