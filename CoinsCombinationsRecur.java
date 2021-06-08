/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp2;

/**
 *
 * @author shilpa
 */
public class CoinsCombinationsRecur {
     public int change(int amount, int[] coins) {
        //check length
        if (coins.length == 0 || coins == null) {
            return 0;
        }
        //recursive approach solution
        return recursiveApproach(coins, amount, 0);

    }

    public int recursiveApproach(int[] coins, int amount, int index) {
        //if amount becomes zero, valid case 
        if (amount == 0) {
            return 1;
        }

        //if we have reached the end but haven't found the answer
        if (index == coins.length || amount < 0) {
            return 0;
        }
        //when we opt for choosing coin, i.e. 1 case 
        int case1 = recursiveApproach(coins, amount - coins[index], index);
        //when we don't choose coin, i.e. 0 case
        int case2 = recursiveApproach(coins, amount, index + 1);
        return (case1 + case2);
    } 
}
