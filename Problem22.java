//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
//Did it run on leetcode: Yes
//Problems faced any?: No

public class Problem22 {
    public int change(int amount, int[] coins) {


        int[][] numWays = new int[coins.length+1][amount+1];

        for(int i=0; i<=coins.length; i++){
            for(int j=0; j<=amount; j++){
                if(j==0)
                    numWays[i][0] = 1;
                if(j>0 && i==0)
                    numWays[0][j] = 0;
            }
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){

                if(j<coins[i-1])
                    numWays[i][j] = numWays[i-1][j];
                else
                    numWays[i][j] = numWays[i-1][j]+numWays[i][j-coins[i-1]];
            }
        }



        return numWays[coins.length][amount];
    }
}
