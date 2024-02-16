// Brute Force solution
// TC: 2^N+M looking at all the possibilities
// SC: same as TC due to recursive stack

// DP SOlution
// Memoization
// TC: O(M*N)
// SC: O(M*N)
class Solution {
    HashMap<String,Integer> map ;

    public int change(int amount, int[] coins) {
        map = new HashMap<>();
        return helper(amount,coins,0);
    }
    private String getKey(int amount, int idx){
        return String.valueOf(amount) +" "+String.valueOf(idx);
    }

    private int helper(int amount,int[] coins,int idx){
        if(map.containsKey(getKey(amount,idx))) return map.get(getKey(amount,idx));
        else{
            if(idx==coins.length || amount < 0) return 0;
            if(amount == 0) {

                return 1;
            }
            else{
                //choose
                int case1 = helper(amount-coins[idx],coins,idx);
                //not choose
                int case2 = helper(amount,coins,idx+1);
                map.put(getKey(amount,idx),case1+case2);
                return case1+case2;

            }

        }
    }
}