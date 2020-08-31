//Time complexity: O(N*M) , N number of houses
//Space complexity: O(1)

#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
     int change(int amount, vector<int>& coins) {
        //Using 1D array
          vector<int> dp(amount+1,0);
        // int* dp=new int[amount+1];
        // for(int j=0;j<amount+1;j++){ dp[j]=0;}
         dp[0]=1;   //using zero coin,  zero amount can be abtained in one way
         for(int i=1;i<coins.size()+1;i++){
             for(int j=0;j<amount+1;j++){
                 if(j>=coins[i-1])
                     dp[j]=dp[j]+dp[j-coins[i-1]];
             }
         }
         return dp[amount];
         
         
         
        /*
        using 2D array
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1,0));
        for (int i = 0;i < coins.size() + 1;i++)
            dp[i][0] = 1;
        for (int i = 1;i < coins.size() + 1;i++) {
            for (int j = 1;j < amount + 1;j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

                }
            }
        }
        return dp[coins.size()][amount];*/
    }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    vector<int> nums{1,2,5};
    int amount=7;
    Solution s;
    cout << s.change(amount, nums) << "\n";
    return 0;
}
