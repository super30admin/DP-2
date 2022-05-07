//Brute Force
//Recursion
//Time = Exponential
//Space = Size of recursion stack


class Solution {
public:
    int change(int amount, vector<int>& coins) {
        return helper(amount,coins,0);
    }
    
    int helper(int amount, vector<int> &coins, int index){
        //base
        if(index==coins.size() || amount<0) return 0;
        if(amount==0) return 1;
        //logic
        //case1 
        int case1 = helper(amount,coins,index+1);
        //case2
        int case2 = helper(amount-coins[index],coins,index);
        return case1+case2;
    }
};


//Optimized approach 
//Time = O(MN)
//SPACE = O(MN)

class Solution {
public:
    int change(int amount, vector<int>& coins) 
    {
        vector<vector<int>> dp(coins.size()+1, vector<int> (amount+1));
        for(int i=0;i<dp.size();i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<dp.size();i++){
            for(int j=1;j<dp[0].size();j++){
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]; 
                }
            }
        }
        return dp[dp.size()-1][dp[0].size()-1];        
    }
};

//More Optimized approach
//TC = O(M*N)  
//SC = O(N)
N = all possible amounts
M = All possible currencies

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp(amount+1);
        dp[0]=1;
        for(int i=1;i<=coins.size();i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                  dp[j] += dp[j-coins[i-1]];
                }
            }
        }
        return dp[dp.size()-1];
    }
};
