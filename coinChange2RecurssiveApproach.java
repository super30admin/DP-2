class coinChange2RecurssiveApproach {
    //recursive approach to solve but will not pass all the test cases as time limit will exceed.
    //TC will be exponential for this.
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0){       //Condn to check if array is empty
            return 0;                           //retrun 0 as there are no denominations.
        }

        return recurse(coins,amount,0);         //call func recursively
    }


    private int recurse(int[] coins, int amount, int index){        //Writing recursive fxn

        if(index>= coins.length || amount<0){      //Base condn to return zero when amount become zero or index is greater or equal to length of coins array.
            return 0;
        }
        if(amount==0){      //Condn to check if found the combination
            return 1;       //will return 1 as we want to keep the track of combinations
        }

        int case1= recurse(coins,amount,index+1);   //case 0, when do not choose, amount stays same and index increase
        int case2= recurse(coins,amount-coins[index],index);    //case 1 when choose, amount will reduce by coin at that index and index will remain the same.

        return case1+case2;     //to get the total number of ways.

    }

    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount =5;
        coinChange2RecurssiveApproach obj = new coinChange2RecurssiveApproach();
        System.out.println(obj.change(amount,coins));
    }
}