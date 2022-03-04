class Solution {
    public int change(int amount, int[] coins) {
        
        int[] prev = new int[amount+1];
        
        prev[0] =1;
        
        for(int i=0;i<coins.length;i++){
            int[] curr = new int[amount+1];
            curr[0] = 1;
            
            for(int j=1;j<=amount;j++){
                
                //Not select
                int notSelect = prev[j];
                
                int select = j-coins[i]<0 ? 0 : curr[j-coins[i]];
                
                curr[j] = notSelect + select;
            }
            prev = curr;
        }
        
        return prev[amount];
        
    }
}
