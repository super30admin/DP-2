time complexity: O(n)
space complexity: O(n)

class Solution { //dynamic programming
    public int minCost(int[][] costs) { 
        if(costs==null||costs.length==0){ //initial check
        return 0;
    }
 
    int[][] matrix = new int[3][costs.length]; //creating a matrix 
 
    for(int j=0; j<costs.length; j++){ //checking until costs.length
        if(j==0){ //if j is equal to 0, then putting all the elements directly into new matrix
            matrix[0][j]=costs[j][0];
            matrix[1][j]=costs[j][1];
            matrix[2][j]=costs[j][2];
        }else{ //else taking minimum and putting them
            matrix[0][j]=Math.min(matrix[1][j-1], matrix[2][j-1])+costs[j][0];
            matrix[1][j]=Math.min(matrix[0][j-1], matrix[2][j-1])+costs[j][1];
            matrix[2][j]=Math.min(matrix[0][j-1], matrix[1][j-1])+costs[j][2];
        }        
    }
 
    int result = Math.min(matrix[0][costs.length-1], matrix[1][costs.length-1]); //getting the minimum value
    result = Math.min(result, matrix[2][costs.length-1]); 
 
    return result; //returning result
    }
}