// TC : O(n)
// SC : O(n)
// works in leetcode
class coinChangeMaxWays {

    static  public int change(int amount, int[] coins) {
        int [] prevMaxWays =   new int[amount+1];
        prevMaxWays[0] = 1;

        for(int coin : coins){
            int[] curr = new int[amount+1];
            curr[0]=1;  // getting sum to 0 in 1 way irrespective of any coin. we dont select any coin to get amount 0
            for(int amt=1;amt<=amount;amt++){

                int select = amt-coin<0? 0: curr[amt-coin];
                int notSelect = prevMaxWays[amt];
                curr[amt] = select + notSelect;

            }
            prevMaxWays = curr;

        }
        return prevMaxWays[amount];

    }


    public static void main(String [] args){
        int [] coins = {1,2,5};


        System.out.println(change(5,coins));
    }
}