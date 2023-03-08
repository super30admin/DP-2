256. Paint House

TC O(n)
SC O(nx3) since its only 3 colors of paint. 

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size(); // no of houses
        if (n==0) return 0;
        int m = 3;
        int dp[n][m];

        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        for (int i=n-2; i>=0; i--) {
            dp[i][0]= costs[i][0] + min(dp[i+1][1], dp[i+1][2]);
            dp[i][1]= costs[i][1] + min(dp[i+1][0], dp[i+1][2]);
            dp[i][2]= costs[i][2] + min(dp[i+1][1], dp[i+1][0]);
        }
        return min(dp[0][0], min(dp[0][1], dp[0][2]));
    }
}; 

TC O(n)
SC O(1)

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size(); // no of houses
        if (n==0) return 0;

        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        for (int i=n-2; i>=0; i--) {
            int tempR =  costR;
            costR= costs[i][0] + min(costB, costG);
             int tempB =  costB;
            costB= costs[i][1] + min(tempR, costG);
            costG= costs[i][2] + min(tempB, tempR);
        }
        return min(costB, min(costR, costG));
    }
};
