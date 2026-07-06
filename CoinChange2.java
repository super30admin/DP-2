//Time Complexity: O(n * amount) where n is the number of coins
//Space Complexity: O(n * amount) where n is the number of coins
public class CoinChange2 {
    int[][] comb;
    public int change(int amount, int[] coins) {
        comb = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) comb[i][amount] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int amt = amount; amt >= 0; amt--) {
                comb[i][amt] = comb[i + 1][amt];
                if (coins[i] + amt <= amount) {
                    comb[i][amt] += comb[i][amt + coins[i]];


                }

            }
        }
        return comb[0][0];
    }
}
