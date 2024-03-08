// (Approach 1) 
// Time Complexity : O(2^n * m)  
//                   ...  n n is number of homess
//                   ...  m is number of colors, this is fixed to 3
// Space Complexity :  O(1)  
//         
// (Approach 2) and (Approach 3) 
// Time Complexity : O(n * m)  == O(n * 3) == O(n)
//                   ...  n is number of homes
//                   ...  m is number of colors, this is fixed to 3
// Space Complexity : O(n * m) == O (n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Letcode : https://leetcode.com/problems/paint-house/

There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
For example, costs[0][0] is the cost of painting house 0 with the color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses
*/


// (Approach 1) : Brute-Force using recursive : Exhuastive way
// This solution faced TIme exceeded failure in Leetcode

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int costR = helper(costs, 0, 0, 0);
        int costG = helper(costs, 0, 1, 0);
        int costB = helper(costs, 0, 2, 0);

        return min(costR, min(costG, costB));
    }

    int helper(vector<vector<int>>& costs, int homeIdx, int color, int cost){
        if(homeIdx == costs.size()) return cost;

        if(color == 0){
            cost = min(helper(costs, homeIdx+1, 1, cost+costs[homeIdx][0]),
                        helper(costs, homeIdx+1, 2, cost+costs[homeIdx][0]));
        } else if(color == 1){
            cost = min(helper(costs, homeIdx+1, 0, cost+costs[homeIdx][1]),
                        helper(costs, homeIdx+1, 2, cost+costs[homeIdx][1]));
        } else if(color == 2){
            cost = min(helper(costs, homeIdx+1, 0, cost+costs[homeIdx][2]),
                        helper(costs, homeIdx+1, 1, cost+costs[homeIdx][2]));
        }
        return cost;
    }
};



// (Approach 2) : Dynamic Programming
// Programming is done considering only 3 choices of color.

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int colors = 3;
        int numHomes = costs.size();
        vector<vector<int>>dp (numHomes, vector<int>(colors));

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < numHomes; i++){
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1]);
        }
        return min(dp[numHomes-1][0], 
                    min(dp[numHomes-1][1], dp[numHomes-1][2]));
    }
};



// (Approach 3) : Dynamic Programming 
// Programming is done considering that color can be any number; therefore 
// accessing dp elemets is not done via hard coded way, another loop with index 'j' is used 
// to access elements in a row

#include <climits>
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int colors = 3;
        int numHomes = costs.size();
        vector<vector<int>>dp (numHomes, vector<int>(colors));

        for(int i = 0; i < colors; i++){
            dp[0][i] = costs[0][i];
        }

        for(int i = 1; i < numHomes; i++){
            for(int j = 0; j < colors; j++){
                dp[i][j] = costs[i][j] + min(dp[i-1][(j+1)%colors], dp[i-1][(j+2)%colors]);
            }
        }

        int result = INT_MAX;  
        for(int j = 0; j < colors; j++){
            result = min(result, dp[numHomes-1][j]);
        }
        return result;
    }
};