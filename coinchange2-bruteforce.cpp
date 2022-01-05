class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        int result = helper(coins, amount, 0, 0);
        return result;
    }
    
    int helper(vector<int> coins, int amount, int index, int coinsUsed) {       
        
        // base
        
        if(amount == 0) return 1;
        
        if(amount< 0 || index > coins.size()-1) return 0;
        
        // take
        int case1 = helper(coins, amount - coins[index], index, coinsUsed + 1);
        
        // not take
        int case2 = helper(coins, amount, index + 1, coinsUsed);
        
        return case1 + case2;
    }
};
// O(n^2) as we are checking all combinations
