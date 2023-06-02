# Time Complexity : O(c.n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> changeMethodCount(amount+1, 0);
        changeMethodCount[0] = 1;
        for(int coin: coins)
        {
            for(int smallAmount = coin; smallAmount <= amount; smallAmount++)
            {
                changeMethodCount[smallAmount] = changeMethodCount[smallAmount] + changeMethodCount[smallAmount-coin];
            }
        }
        return changeMethodCount[amount];
    }
};