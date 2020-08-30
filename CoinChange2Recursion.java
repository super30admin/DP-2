public class CoinChange2Recursion {
    public int change(int amount, int[] coins) {
        return changeRec(amount, coins, 0);
    }

    public int changeRec(int amount, int[] coins, int idx) {
        if (amount == 0)
            return 1;

        if (amount < 0)
            return 1;
        

            if (idx == coins.length && amount > 0)
             return 0; // means coins over and n>0 so no solution

      return changeRec(amount - coins[idx], coins, idx) + changeRec(amount, coins, idx + 1); // include + exclude
    }

    public static void main(String args[]) {
        CoinChange2 obj = new CoinChange2();
        int amount = 7;
        int[] coins = { 1, 2, 5 };
        System.out.println(obj.change(amount, coins));
    }
}