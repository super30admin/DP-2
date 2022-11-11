// Time Complexity : exponential
// Space Complexity : O(n) where n is the depth of the recursion tree
// Did this code successfully run on Leetcode : No, Time Limit Exceeded

//Recursive exhaustive search approach

class Solution {
private:
    int helper(vector<vector<int>>& costs, int index, int colour, int costIncurred){
        //base case - when we exhaust the array/houses
        if(index == costs.size())
            return costIncurred;
        
        //if we've picked colour x, we need to calculate the min path for the other two colours for the next index
        if (colour == 0)
            return min(helper(costs, index+1, 1, costIncurred+costs[index][0]), helper(costs, index+1, 2, costIncurred + costs[index][0]));
        else if (colour == 1)
            return min(helper(costs, index+1, 0, costIncurred+costs[index][1]), helper(costs, index+1, 2, costIncurred + costs[index][1]));
        else
            return min(helper(costs, index+1, 0, costIncurred+costs[index][2]), helper(costs, index+1, 1, costIncurred + costs[index][2]));
    }
public:
    int minCost(vector<vector<int>>& costs) {
        if (costs.size() == 0)
            return 0;
        //costs, index(house), colour, costIncurred
        //let colours R = 0, G = 1, B = 2
        
        //result is minimum of all 3 cases 
        //if we pick red
        int case0 = helper(costs, 0, 0, 0);
        //if we pick green
        int case1 = helper(costs, 0, 1, 0);
        //if we pick blue
        int case2 = helper(costs, 0, 2, 0);
        
        return min(case0, min(case1, case2));
    }
};

// Time Complexity : O(n) where n is the number of houses 
// Space Complexity : O(1) we are updating the same array - no additional space

/*
DP approach 
Lets go bottom-up and every element will be updated to the sum of that cost + minimum of the other two colours for the adjascent house 

17   2    17
16   16   5
14   3    19

Lets go bottom-up approach


1st iteration
17                  2                   17
16+min(3,19)=19     16+min(14,19)=30    5+min(14,3)=8
14                  3                   19

2nd iteration
17+min(30,8)=25     2+min(19,8)=10      17+min(30,19)=36
16+min(3,19)=19     16+min(14,19)=30    5+min(14,3)=8
14                  3                   19

Solution: Min of numbers in row 0

*/

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size() == 0)
            return 0;
        for(int i=costs.size()-2; i>=0; i--){
            costs[i][0] += min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += min(costs[i+1][0], costs[i+1][1]);
        }
        return min(costs[0][0],min(costs[0][1], costs[0][2]));
    }
};