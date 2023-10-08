import javax.lang.model.util.ElementScanner14;
import javax.swing.InputMap;

/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
             Minimum cost: 2 + 5 + 3 = 10.

*/

/*

i build the matrix backwards calculating the code of painting the house, and update as i move above

*/

public class HousePaint {

    public static void main(String args[])
    {
        int[][] input =  {{17,2,27},{26,5,16},{14,3,19},{1,7,2}};
        System.out.println("Min cost to paint houses is : " + paintHouses(input));
    }

    public static int paintHouses(int[][] arr)
    {
        int m = arr[0].length;

        for(int i=arr.length-2 ; i >= 0; i--)
        {   
            for(int j = 0; j!= m; j++)
            {
                if(j==0)
                {
                    arr[i][j] = arr[i][j] + Math.min(arr[i+1][j+1], arr[i+1][j+2]);
                }
                else if(j==1)
                {
                    arr[i][j] = arr[i][j] +  Math.min(arr[i+1][j-1], arr[i+1][j+1]);
                }
                else
                {
                    arr[i][j] = arr[i][j] +  Math.min(arr[i+1][j-1], arr[i+1][j-2]);
                }

            }

        }



        return Math.min(arr[0][0], Math.min(arr[0][1], arr[0][2]));
    }

}
