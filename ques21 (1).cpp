Time complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int compare(int a,int b,int c)
    {
        if(a<=b && a<=c)
            return a;
        else if(b<=a && b<=c)
            return b;
        else
            return c;
    }
    int minCost(vector<vector<int>>& costs) {
        int n=costs.size();
        int dp[n+1][3];
	    for(int j=0;j<3;j++)
	    {
	        dp[0][j]=0;
	    }
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=0;j<3;j++)
	        {
	            if(j==0)
	            {
                    dp[i][j]=costs[i-1][0]+min(dp[i-1][1],dp[i-1][2]);
	            }
	            else if(j==1)
	            {
	                dp[i][j]=costs[i-1][1]+min(dp[i-1][0],dp[i-1][2]);
	            }
	            else
	            {
	                dp[i][j]=costs[i-1][2]+min(dp[i-1][0],dp[i-1][1]);
	            }
	        }
	    }
        int result=compare(dp[n][0],dp[n][1],dp[n][2]);
        return result;
    }
};

int main() {
    vector<vector<int>>m={{17,2,17},{16,16,5},{14,3,19}};
    Solution soln;
    int result=soln.minCost(m);
    cout<<result;
	return 0;
}