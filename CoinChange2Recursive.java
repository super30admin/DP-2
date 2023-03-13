public class CoinChange2Recursive {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount);
    }
    private int helper(int[] coins,int idx, int amount){
        //base
        if(amount == 0) return 1;
        if(amount<0 || idx == coins.length) return 0;

        //logic
        int case0 = helper(coins, idx+1, amount);
        int case1 = helper(coins, idx, amount-coins[idx]);
        return (case0 + case1);
    }

    public static void main(String[] args) {
        CoinChange2Recursive obj = new CoinChange2Recursive();
        int[] coins = new int[]{1,2,5};
        int res = obj.change(11, coins);
        System.out.println("res--- "+ res);
    }
}
