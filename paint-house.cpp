//Time complexity : O(n) as 3 colors remain constant
//Space complexity : O(1) constant space

//Approach:
            // Go for bottom up DP so that we can store minimum cost required for each house starting from last house
            // At every iteration, store minimum cost required if that house is selected
            // Return the minimum cost at the first house

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        // int case1 = recurse(costs, 0 , 0 , 0);
        // int case2 = recurse(costs, 0 , 1 , 0);
        // int case3 = recurse(costs, 0 , 2 , 0);
        if(costs.size() == 0)
        {
            return 0;
        }
        
        for(int i = costs.size() - 2; i >= 0; i--)
        {
            costs[i][0] += min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += min(costs[i + 1][0], costs[i + 1][1]);
        }
        
        return *min_element(costs[0].begin(), costs[0].end());
    }
    
//     int recurse(vector<vector<int>>& costs , int row, int color, int cost)
//     {
//         //base
//         if(row == costs.size())
//         {
//             return cost;
//         }
//         //logic
//         if(color == 0)
//         {
//             return min(recurse(costs, row + 1, 1 , cost + costs[row][0]), recurse(costs, row + 1, 2, cost + costs[row][0]));
//         }
//         if(color == 1)
//         {
//             return min(recurse(costs, row + 1, 0 , cost + costs[row][1]), recurse(costs, row + 1, 2, cost + costs[row][1]));
//         }
//         if(color == 2)
//         {
//             return min(recurse(costs, row + 1, 0 , cost + costs[row][2]), recurse(costs, row + 1, 1, cost + costs[row][2]));
//         }
        
//         return INT_MAX;
//     }
};