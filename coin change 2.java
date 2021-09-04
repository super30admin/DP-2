time complexity: O(amount*coins)
space complexity: O(amount*coins)

class Solution { //Dynamic programming
    public int change(int amount, int[] coins) {
        int[][] results = new int[coins.length + 1][amount + 1]; //creating a result matrix
        
        results[0][0] = 1; //putting first element as 1
      
        for (int i = 1; i <= coins.length; i++) {
            results[i][0] = 1; 
            
            for (int j = 1; j <= amount; j++) {
                // if the coin's value is bigger than amount, copy the result from previous row directly.
                results[i][j] = results[i-1][j] + (j >= coins[i-1] ? results[i][j - coins[i-1]] : 0);
            }
        }
        
        return results[coins.length][amount]; //getting the last element
    }
}