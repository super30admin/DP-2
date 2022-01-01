class CoinChange2 {
    HashMap<String,Integer> memo = new HashMap();
    public int change(int amount, int[] coins) {
        return helper(amount,coins,0);
    }
    
    public int helper(int amount, int [] coins,int index){
        if(memo.containsKey(amount+"-"+index)){
            return memo.get(amount+"-"+index);
        }
        if(amount==0){
            return 1;
        }
        
      
        
        
        int result=0;
        int ret=0;
        for(int i=index;i<coins.length;i++){
            
            if(amount-coins[i]>=0){
            ret = helper(amount-coins[i],coins,i);
        
            result += ret;
            }
        }
        
        memo.put(amount+"-"+index,result);
        
        return result;
    }
}