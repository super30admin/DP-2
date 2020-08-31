//256_Paint_House.cpp
//Time complexity: O(N) , N number of houses
//Space complexity: O(1)

#include <iostream>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        
        //using 1D array
        vector<int> dp(3,0);
        
        for(int i=1;i<costs.size()+1;i++){
             int temp0=dp[0],temp1=dp[1],temp2=dp[2];
             dp[0]=costs[i-1][0]+ min(temp1,temp2);
             dp[1]=costs[i-1][1]+ min(temp0,temp2);
             dp[2]=costs[i-1][2]+ min(temp0,temp1);
        }
        return min(dp[0],min(dp[1],dp[2]));
        
        /*using 2D array
        vector<vector<int>> dp(costs.size()+1,vector<int>(3,0));
        
        for(int i=1;i<costs.size()+1;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    dp[i][j]=costs[i-1][j]+min(dp[i-1][1],dp[i-1][2]);
                }
                if(j==1){
                    dp[i][j]=costs[i-1][j]+min(dp[i-1][0],dp[i-1][2]);
                }
                if(j==2){
                    dp[i][j]=costs[i-1][j]+min(dp[i-1][0],dp[i-1][1]);
                }
            }
        }
        return min(dp[costs.size()][0],min(dp[costs.size()][1],dp[costs.size()][2]));
        */
        
    }
};
int main(int argc, const char * argv[]) {
    vector<vector<int>> nums{{17,2,17},{16,16,5},{14,3,9}};
  //  int amount=7;
    Solution s;
    cout << s.minCost(nums) << "\n";
    return 0;
}
