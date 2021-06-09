class Solution {
    public int change(int amount, int[] coins) {

        if(coins.length == 0){
            return 0;
        }
        int[][] twoDmatrix = new int[coins.length+1][amount+1];


        //fill in first row for default case
        for(int i = 0; i < amount+1;i++){
            twoDmatrix[0][i] = 0;
        }
        //fill in first coulmn for default case
        for(int i = 0; i < coins.length+1;i++){
            twoDmatrix[i][0] = 1;
        }
        for(int i = 1; i < coins.length+1;i++){
            for(int j = 1; j < amount+1;j++){
                if(coins[i-1] > j){
                    twoDmatrix[i][j] = twoDmatrix[i-1][j];
                }
                else{
                    twoDmatrix[i][j] = twoDmatrix[i-1][j] + twoDmatrix[i][j - coins[i-1]] ;
                }

            }
        }

        return twoDmatrix[twoDmatrix.length-1][twoDmatrix[0].length-1];

    }
}