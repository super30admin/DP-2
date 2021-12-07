// Time Complexity : O(N) where N = costs.size()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Come up with recursive solution
2. Build up dp table
3. return the result
*/
class Solution {
public:
    int minCost(vector<vector<int>>& costs)
    {
        int len = costs.size();
        if (len == 1)
        {
            sort(costs[0].begin(), costs[0].end());
            return costs[0][0];
        }

        //modifying the input matrix.
        for (int i = 1; i < len; i++)
        {
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1]);
        }


        return min(costs[len - 1][0], min(costs[len - 1][1], costs[len - 1][2]));

    }
};


/*
// Time Complexity : O(N) where N = costs.size()
// Space Complexity : O(N) -> O(3N) to be precise. i.e (no of colors * N)
// solved using a temp matrix of size N*3.
*/

/*
class Solution {
public:
    int minCost(vector<vector<int>>& costs)
    {
        if (costs.size() == 1)
        {
            sort(costs[0].begin(), costs[0].end());
            return costs[0][0];
        }

        vector<vector<int>> dp(3, vector<int>(costs.size()));

        for (int j = 0; j < 3; j++)
            dp[j][0] = costs[0][j];

        for (int j = 1; j < costs.size(); j++)
        {
            for (int i = 0; i < 3; i++)
            {
                dp[i][j] = costs[j][i] + min(dp[(i + 1) % 3][(j - 1)], dp[(i + 2) % 3][(j - 1)]);
            }
        }

        int min_cost = INT_MAX;
        for (int i = 0; i < 3; i++)
        {
            min_cost = min(min_cost, dp[i][costs.size() - 1]);
        }

        return min_cost;
    }
};
*/


// recursive solution
/*
* class Solution {
public:
    int minCost(vector<vector<int>>& costs) 
    {
        int case1 = min(helper(costs, 0,0, 0),helper(costs,0,0, 1));
        int case2 = helper(costs, 0,0, 2);  
        
        return min(case1, case2);
        
    }
    
    int helper(vector<vector<int>> & nums, int index, int current_cost, int color)
    {
        // base case
        if(index>=nums.size())
            return current_cost;
            
        // logic
        if(color==0)
        {
            int case1 = min(helper(nums, index+1, nums[index][color]+current_cost, 1), helper(nums, index+1, nums[index][color]+current_cost, 2));
        
        return case1;
        }
        
          else if(color==1)
        {
            int case1 = min(helper(nums, index+1, nums[index][color]+current_cost, 0), helper(nums, index+1, nums[index][color]+current_cost, 2));
        
        return case1;
        }
        
          else if(color==2)
        {
            int case1 = min(helper(nums, index+1, nums[index][color]+current_cost, 0), helper(nums, index+1, nums[index][color]+current_cost, 1));
        
        return case1;
        }
    return 0;
            
    }
};
*/