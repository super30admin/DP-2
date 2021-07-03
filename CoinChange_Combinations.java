package CoinChange_Combination;

public class CoinChange_Combinations {
	public int change(int amount, int[] coins) {
    int m = coins.length+1;
    int n = amount+1;
    int [][] coin_matrix = new int[m][n];
    
    for(int i=0;i<m;i++)
    {
        coin_matrix[i][0] = 1;
    }
    
    for(int i=1; i<m; i++)
    {
        for(int j=1;j<n;j++)
        {
            if (j<coins[i-1])
            {
                coin_matrix[i][j] = coin_matrix[i-1][j];
            }
            
            else
            {
                coin_matrix[i][j] = coin_matrix[i-1][j]+coin_matrix[i][j-coins[i-1]];
            }
        }
    }
   return coin_matrix[m-1][n-1];
}

	public static void main(String[] args) {
		int[] coins = {1,2,5,10};
		CoinChange_Combinations obj = new CoinChange_Combinations();
		int number_of_combinations = obj.change(50, coins);
		System.out.println("The number of combinations possible is : "+number_of_combinations);
		}

	}


