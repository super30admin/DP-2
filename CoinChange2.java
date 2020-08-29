class CoinChange2{
    public static void main(String[] args){
        CoinChange2 ph = new CoinChange2();
        int[] coinsArray = {1,2,5};
        int result=ph.change(5,coinsArray);
        System.out.print("Result: " +result);
    }
    public int change(int amount, int[] coins) {

        int[][] matrix=new int[coins.length+1][amount+1];

        for(int i=1;i<=amount;i++){
            matrix[0][i] = 0;
        }
        for(int i=0;i<=coins.length;i++){
            matrix[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    matrix[i][j]=matrix[i-1][j];
                }else{
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-coins[i-1]];
                }
            }
        }
        return matrix[coins.length][amount];
    }


}