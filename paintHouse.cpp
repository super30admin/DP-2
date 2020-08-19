// Time Complexity : O(3^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: EACH POINT - TWO OPTIONS; ALSO START WITH INDEX=-1 SINCE FIRST ROW HAS TO CONSIDER ALL 3 ELEMENTS

// Your code here along with comments explaining your approach
// 1. Recursive solution - call recursive function for index = -1 to consider all 3 numbers on first row
// 2. Inside recursive function, run a loop for three colors and excecute for allowed color: add value to SUM and call function for next house
// 3. Base case is when house number exceeds n then update min cost  

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size() == 0)
            return 0;
        int minCost = INT_MAX;
        dfs(costs,0,-1,0,minCost);
        return minCost;
    }
    
    void dfs(vector<vector<int>>& costs, int row, int index, int sum, int& minCost){
        // base
        if(row >= costs.size()){
            minCost = min(minCost, sum);
            return;
        }
        // logic
        for(int j=0;j<3;j++){
            if(j == index)
                continue;
            sum += costs[row][j];
            dfs(costs,row+1,j,sum,minCost);
            sum -= costs[row][j];
        }
        
    }
};

// DP Solution
// Time Complexity : O(3n)
// Space Complexity : O(3n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: EACH ELEMENT OF CACHE MATRIX = MIN OF NEIGHBORS OF PREV ROW + CURR VALUE  

// Your code here along with comments explaining your approach
// 1. Create cache matrix with first row same as input
// 2. From row 2: each element = sum of curr val from costs and minimum of the 2 neighbors from prev row
// 3. Return min of last row

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
       if(costs.size() == 0)
           return 0;
        vector<vector<int>> cache(costs.size(),vector<int>(3,0));
        for(int j=0;j<3;j++)
            cache[0][j] = costs[0][j];
        for(int i=1;i<costs.size();i++){
            for(int j=0;j<3;j++){
                int min_prev = INT_MAX;
                for(int k=0; k<3; k++){
                    if(k==j)
                        continue;
                    min_prev = min(min_prev, cache[i-1][k]);
                }
                cache[i][j] = costs[i][j] + min_prev;
            }
        }

        int n = cache.size()-1;
        int min_cost = INT_MAX;
        for(int j=0;j<3;j++)
            min_cost = min(min_cost, cache[n][j]);
        return min_cost;
    }
};