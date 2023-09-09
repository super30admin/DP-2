public class paintHouseDPApproach {
    //Mutating the costs array with bottom to top approach to get the minimum cost
    //TC will be O(N), as traversing over the array of Size n*3 and 3 is constant
    //SC will be O(1), as mutating the existing array.
    public int minCost(int [][] costs){
        if(costs==null || costs.length==0){     //Base condn to check empty array
            return 0;                           //Cannot have min cost return 0.
        }

        int n= costs.length;  //size of the rows or number of houses.
        for(int i=n-2;i>=0;i--){
        costs[i][0]= costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);  //updating the row with min cost
        costs[i][1] = costs[i][1] + Math.min(costs[i+1][2], costs[i+1][1]);
        costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
    }
    return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));     //returning the minimum value
    }

        public static void main(String[] args){
            int[][] costs= {{17,2,17},{16,16,5},{14,3,19}};
            paintHouseDPApproach obj= new paintHouseDPApproach();
            System.out.println(obj.minCost(costs));
        }
    }
