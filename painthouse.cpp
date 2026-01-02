class Solution {
public:
    int minCost(vector<vector<int>> &costs) {
        int m = costs.size();
        if (costs.empty()) return 0; //nothing to return 

        vector<vector<int>> dp(m,vector<int>(3));//matrix of size 'm x 3'

        dp[m-1][0] = costs[m-1][0];//edge case where the last house is being painted,hence the total price becomes the price of one red house
        dp[m-1][1] = costs[m-1][1];//similarly for blue
        dp[m-1][2] = costs[m-1][2];//similarly for green

        for(int i = m - 2 ; i>=0 ;i --){
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2]);//we must paint house i+1 either BLUE or GREEN
            dp[i][1] = costs[i][1] + min(dp[i+1][2],dp[i+1][0]);//choose min cost between RED and GREEN for house i+1
            dp[i][2] = costs[i][2] + min(dp[i+1][1],dp[i+1][0]);//choose min cost between RED and BLUE for house i+1
        }

        return min(dp[0][0],min(dp[0][1],dp[0][2]));//FINAL MIN COST
    }
};