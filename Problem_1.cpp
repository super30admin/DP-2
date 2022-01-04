//Time complexity is O(3*n) = O(n)
//Space complexity is O(1)

/*Approach:
First we try th exhaustive approach. The time complexity
is exponential. So we look for subproblems to confirm if it is a dp problem.
Once it is confirmed we look for the pattern through the tabular method.
Here we created three cases, first if we are choosing house to be painted red,
second if it is painted blue and third if it is painted green. The minimum cost
of all the cases in the first row will give the answer*/

//The code ran perfectly on leetcode.

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        for(int i = costs.size()-2; i>=0; i-- ){
            costs[i][0] += min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += min(costs[i+1][1], costs[i+1][0]);
        }
        
        return min(costs[0][0], min(costs[0][1], costs[0][2]));
        
    }
};