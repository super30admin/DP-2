// Time Complexity : O(n*m) n: amount m: no of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
// Having trouble with top down


// Your code here along with comments explaining your approach
// At any amount, number of combination for a coin is no of comination till now plus no of combinations for amount minus coin value

//Bottom up
public int change(int amount, int[] coins) {
    int[] count = new int[amount+1];
    count[0] = 1;
    for(int j = 0; j< coins.length;j++){
        for(int i = 1; i<= amount; i++){
            if(i>=coins[j]){
                count[i] += count[i-coins[j]];
            }
        }
    }
    return count[amount];
}