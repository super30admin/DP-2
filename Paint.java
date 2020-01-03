// Time Complexity : O(n^2)
// Space Complexity : O(NxM) N & M are rows and columns of the matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

public class Main {

    public static void main(String[] args) {
	    int n = 3;  // houses
        int m = 3;  // number of paints Red, Green & Blue in this order
        int[][] mat = new int[][] {new int[] { 13,17,2 },new int[] { 16,10,5}, new int[]{14,3,19}, new int[] {7, 1, 8}, new int[] {2,6,7}};

        System.out.println(paint(mat));
    }

    public static int paint(int[][] color){
        int i = 0, j = 0,temp = 0;

        if(color[i][j] < color[i][j+1] && color[i][j] < color[i][j+2]){     // since we know there are only 3 colors, find the minimum for the first house.
            temp = 0;
        }else if(color[i][j+1] < color[i][j] && color[i][j+1] < color[i][j+2]){
            temp = 1;
        }else{
            temp = 2;
        }

        int index1 = -1;        // index are used to neglect the column we have selected and find the other 2 columns
        int index2 = -1;
        int mincost = color[i][temp];

        for(int m = 1; m<color.length; m++){        // traverse through the rows of the matrix
            for(int n = 0; n<color[0].length;n++){  // traverse through the column of the matrix
                if(temp != n){                      // we know the column we should neglect, apart from that, find the remaining out column index
                    if(index1 == -1){
                        index1 = n;
                    }else{
                        index2 = n;
                    }
                }
            }

            if(color[m][index1] < color[m][index2]){        // update the temp by the index which we selected in the current row
                temp = index1;
            }else{
                temp = index2;
            }

            mincost += Math.min(color[m][index1], color[m][index2]);        // find the minimum among the indexes we found and add to the index
            index1 = -1;
            index2 = -1;

        }

        return mincost;
    }
}
