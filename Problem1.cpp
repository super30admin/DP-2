// Time Complexity : O(N) N is # of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Create a 2d matrix with 3 columns and n rows. 
// 2. select the minimum cost if that color is selected.

class Solution {
public:
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
     int minimum(int a,int b){
         if(a>b){
             return b;
         }return a;
     }
    int minCost(vector<vector<int>> &costs) {
        // write your code here
        int m=costs.size();
        if(m==0){
            return 0;
        }
        int n=costs[0].size();
        if(n==0){
            return costs[0][3];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                costs[i][j]=costs[i][j]+minimum(costs[i-1][(j+1)%n],costs[i-1][(j+2)%n]);
            }
        }
        return minimum(costs[m-1][0],minimum(costs[m-1][1],costs[m-1][2]));
    }
};