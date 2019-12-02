//recursive solution - coin change 2

class Solution {
public:
    int change(int amount, vector<int>& coins) {

        return helper(amount, coins, 0);

    }

private:

    int helper(int amount, vector<int>& coins, int i ){
        //base case
        if(i > coins.size() - 1 || amount < 0) return 0;
        if(amount == 0) return 1;


        //case1: choose a coin
        int case1 = helper(amount = coins[i], coins, i);

        //case2: not choosing a coin
        int case2 = helper(amount, coins, i+1);

        return case1 + case2;

    }
};

//Time Complexity: O(amount^n)
//Space Complexity: O(amount)
//runtime error: stack overflow error on Leetcode
