class Solution {
    public int change(int amount, int[] coins) {
         int[] combination = new int[amount +1];
        Arrays.fill(combination, 0);
        
         combination[0]=1;
        for(int coin : coins){

            for(int i=1;i<amount+1;i++){

                if(coin<=i){
                    combination[i] += combination[i-coin]; 
                }
            }
        }
        return combination[amount];
    }
}