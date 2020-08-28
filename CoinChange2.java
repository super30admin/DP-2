//Time complexity: O(n2) n: coins length m: amount
//Space complexity: O(n)
public class CoinChange2 {
    public static int coinChange(int amount, int[] coins) {
        
        int[] arr = new int[amount+1];
        arr[0] = 1;
        for (int coin : coins){
            for(int j=1; j<=amount; j++){
                if(j >= coin)
                    arr[j] += arr[j-coin];
            }
        }
        return arr[amount];   
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(amount,coins));
    }
}