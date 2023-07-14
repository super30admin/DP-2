// Time Complexity : O(2^(coins.length + amount))
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : No (TLE)

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        return helper(amount, 0, coins);
    }
    int helper(int amount, int index, vector<int>& coins) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (index >= coins.size())
            return 0;

        int count = helper(amount, index + 1, coins) + helper(amount - coins[index], index, coins);
        return count;
    }
};