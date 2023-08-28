
import java.util.Scanner;

public class CoinChange {
    public static void change(int amount, int[] coins) {
        
       
        System.out.println("Result Using exhaustion recursion: ");
        System.out.println(changeExhuastive(coins, amount,0)); //exhaustion recursion
        System.out.println("Result Using DP 2D Array: ");
        System.out.println(changeDP(amount,coins)); // Using DP: 2D array

    }



    private static int changeExhuastive( int[] coins, int amount, int i){
        //null
        if(coins == null) return 0;

        //base case
        if(amount ==0) return 1;
        if(amount<=0 || i==coins.length) return 0;

        //case 0: not choose
        int case0 = changeExhuastive(coins, amount, i+1);
    
        //case 1: choose
        int case1 = changeExhuastive(coins, amount - coins[i], i);

        return case0+case1;
    }


    public static int changeDP (int amount, int[] coins) {

        
        //null
        if(coins == null) return 0;

        int m = amount; // rows
        int n = coins.length; //colums

        int[] dp = new int[m+1];
        // fisrt row all columns to make [0] amount=0,1,2,3,4,5,6.. we have one way to take it is []
        dp[0]=1;

        for (int i=1; i<=n; i++){
            for (int j=0; j<=m; j++){
                //for all the columns gearter then row/amount remaining be the same as casse0: not choosing.
                if(j>=coins[i-1]){      
                    dp[j]= dp[j]+ dp[j- coins[i-1]];

                }

            }
        }
        return dp[m];
    }



    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coins array: ");

        String inputString = sc.nextLine();
        String[] inputArray = inputString.split(" ");
        
        int[] coins = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            coins[i] = Integer.parseInt(inputArray[i]);
        }

        System.out.print("Enter an integer: ");

        int amount = sc.nextInt();
      
        change(amount, coins);
        
    }
    
}
