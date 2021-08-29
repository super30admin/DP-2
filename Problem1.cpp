// Paint House


// Time Complexity : O(n) // since columns are constant
// Space Complexity : O(n) // same
// Did this code successfully run on Leetcode : Don't have premium hence ran it on leetcode ripoff, lintcode.
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    int minCost(vector<vector<int>> &costs) {
        // write your code here
        if(costs.size() == 0) return 0; // if matrix is empty return 0
        for(int i=costs.size() - 2; i>=0; i--){
            
                costs[i][0] += min({costs[i+1][1], costs[i+1][2]});    // calculate the cost of first row
                costs[i][1] += min({costs[i+1][0], costs[i+1][2]});    // calculate the cost of second row
                costs[i][2] += min({costs[i+1][1], costs[i+1][0]});    // calculate the cost of third row
            
        }
        return min({costs[0][0], costs[0][1], costs[0][2]});  // return the minimum of red, blue, green
    }
};
