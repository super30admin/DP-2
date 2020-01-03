Time Complexity-O(n*m) Here 'n' is the amount and 'm' is the size of the input vector
HSpace Complexity-O(n) Here 'n' is the amount
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int>dp(amount+1,0);
		dp[0]=1;
        for(auto x:coins)
        {
            for(int i=x;i<=amount;i++)
            {
                dp[i]=dp[i]+dp[i-x];
            }
        }
            return dp[amount];
    }
};

int main() {
	vector<int>m={1,2,5};
	int target=5;
	Solution soln;
	int result=soln.change(target,m);
	cout<<result;
	return 0;
}
