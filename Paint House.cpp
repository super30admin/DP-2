//256. Paint House


/*
Greedy doesnt work, exhaustive TLE
Follow DP
Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
public:
    /*
    int helper(vector<vector<int>>& costs, int idx, int coloridx, int costTillNow){
        //base
        if(idx == costs.size()) return costTillNow;

        //logic
        //first red
        if(coloridx == 0){
            //next colors would be blue or green
            return min(helper(costs, idx+1, 1, costTillNow+costs[idx][coloridx]),
            helper(costs, idx+1, 2, costTillNow+costs[idx][coloridx]));
        }

        //next blue
        if(coloridx == 1){
            //next colors would be green or red
            return min(helper(costs, idx+1, 0, costTillNow+costs[idx][coloridx]),
            helper(costs, idx+1, 2, costTillNow+costs[idx][coloridx]));
        }

        //next blue
        if(coloridx == 2){
            //next colors would be blue or red
            return min(helper(costs, idx+1, 1, costTillNow+costs[idx][coloridx]),
            helper(costs, idx+1, 0, costTillNow+costs[idx][coloridx]));
        }

        return INT_MAX;

    }
    */

    int minCost(vector<vector<int>>& costs) {
        
        /*
        //exhaustive approach
        //TC: no of colors * 2 power (no of houses) = 3*2^n

        int rcost =helper(costs, 0, 0, 0);
        int bcost =helper(costs, 0, 1, 0);
        int gcost =helper(costs, 0, 2, 0);

        return min(rcost, min(bcost,gcost));
        */


        /*
        //bottom up
        //TC: O(n*3) = O(n); SC: O(n*3)=O(n)

        int n = costs.size();
        vector<vector<int>> dp(n, vector<int>(3));

        //fill the bottom row 
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i=n-2; i>=0; i--){
            //red paint
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]);
            //blue
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2]);
            //green
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0]);

        }

        return min(dp[0][0], min(dp[0][1],dp[0][2]));

        */
        //bottom up - space optimized
        int n = costs.size();
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        for(int i=n-2; i>=0; i--){
            int tempR = costR;
            costR = costs[i][0]+min(costB,costG);
            int tempB = costB;
            costB = costs[i][1]+min(tempR,costG);
            costG = costs[i][2]+min(tempB,tempR);
        }

        return min(costR,min(costB,costG));
    }
};