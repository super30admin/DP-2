//TC: O(nm) where n is number of denominations and m is amount+1
//SC: O(m) where m is amount + 1

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        //find number of combinations that make up the smallest amount. Then iterate through the set of coins, and find the amount required to make up [x-coins[j]] and add this to the spot for the xth coin.
        sort(coins.begin(), coins.end());
        
        int arrCoin[amount+1];
        for(int i=0; i<amount+1; i++)
            arrCoin[i] = 0;
        
        //since theres one way to make 0, which is by not choosing any coin.
        arrCoin[0] = 1;

        //approach: first find number of ways we can get amount for first coin. Then find number of ways we can get amount using first AND second coin together. Add the elements together in the same array position.
        
        for(int i=0; i<coins.size(); i++){
            //since amount+1 is the size of arrCoin
            for(int j=coins[i]; j<amount+1; j++){
                    arrCoin[j] = arrCoin[j] + arrCoin[j - coins[i]];
            } 
        }
        
        return arrCoin[amount];
            
    }
};