public class main {

    public static void main(String args[]){

        //Source Link: https://leetcode.com/problems/coin-change-2/
        CoinChange2 coinChange = new CoinChange2();
        System.out.println(coinChange.changeUsingDp(500, new int[]{3,5,7,8,9,10,11}));
        System.out.println(coinChange.changeUsingRecursion(10, new int[]{2,5,3,6}));

    }
}
