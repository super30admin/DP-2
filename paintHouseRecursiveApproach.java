public class paintHouseRecursiveApproach {
    //Recursive approach and will not work when costs array become large
    //TC is exponential, as checking exhaustively for each colour and house.
    public int minCost(int [][] costs){
        if(costs==null || costs.length==0){     //Base condn to check empty array
            return 0;                           //Cannot have min cost return 0.
        }

        int costRed= recurse(costs,0,0,0);      //variable to store cost of red house by calling recurse func recursively
        int costBlue = recurse(costs,1,0,0);    //variable to store cost of blue house by calling recurse func recursively
        int costGreen = recurse(costs,2,0,0);   //variable to store cost of green house by calling recurse func recursively
        return Math.min(costRed,Math.min(costBlue, costGreen));     //Returning the minimum cost, Math.min takes only 2 parameters.
    }

    private int recurse(int[][] costs, int color, int row, int totalCost){
        if(row == costs.length){        //base condn when reached the last house.
            return totalCost;
        }
        if(color==0){                   //when colour is Red
            return Math.min(recurse(costs,1,row+1,totalCost+costs[row][color]),
                                recurse(costs,2,row+1,totalCost+costs[row][color]));
        }
        if(color==1){                   //when color is Blue
            return Math.min(recurse(costs,0,row+1,totalCost+costs[row][color]),
                    recurse(costs,2,row+1,totalCost+costs[row][color]));
        }
        if(color==2){           //when colour is Green
            return Math.min(recurse(costs,0,row+1,totalCost+costs[row][color]),
                    recurse(costs,1,row+1,totalCost+costs[row][color]));
        }
            return 4567;            //won't reach here if array is empty then it will return 0 else there will some min cost
    }

    public static void main(String[] args){
        int[][] costs= {{17,2,17},{16,16,5},{14,3,19}};
        paintHouseRecursiveApproach obj= new paintHouseRecursiveApproach();
        System.out.println(obj.minCost(costs));
    }
}
