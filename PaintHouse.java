class PainHouse {
    Map<String,Integer> memo = new HashMap();
    
    public int minCost(int[][] costs) {
       return   helper(costs,0,-1);
    }
    
    public int helper(int [][]costs, int houseNumber, int lastPaint){
        if(memo.containsKey(houseNumber+"="+lastPaint)){
            return memo.get(houseNumber+"="+lastPaint);
        }
        if(houseNumber==costs.length){
            return 0;
        }
        
        int minCost=Integer.MAX_VALUE;
        
        for(int i=0;i<costs[0].length;i++){
            
            if(lastPaint!=i){
           int amt = helper(costs,houseNumber+1,i)+costs[houseNumber][i];
            
            minCost = Math.min(minCost,amt);
            }
        }
        memo.put(houseNumber+"="+lastPaint,minCost);
        return minCost;
    }
}