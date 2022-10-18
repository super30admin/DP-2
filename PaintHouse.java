// TC  O(n)
// SC   O(n)
// works in leetcode
class PaintHouse {

    static int minCost(int [][] costs){
        // instead of creating 2D array we can just use prev and curr array
        int [] prevMinCost = costs[0];

        for(int i=1; i< 3; i++){
            int [] currMinCost = new int [3];

            //first color - red
            currMinCost[0] = costs[i][0] + Math.min(
                    prevMinCost[1],  // second color green- for upto prev house
                    prevMinCost[2] // third color blue- for upto prev house
            );

            //second color - red
            currMinCost[1] = costs[i][1] + Math.min(
                    prevMinCost[0],  // first color - for upto prev house
                    prevMinCost[2] // third color - for upto prev house
            );

            //third color - red
            currMinCost[2] = costs[i][2] + Math.min(
                    prevMinCost[0],  // second color- for upto prev house
                    prevMinCost[1] // third color - for upto prev house
            );
            prevMinCost =  currMinCost;

        }


        return Math.min(prevMinCost[0], Math.min(prevMinCost[1], prevMinCost[2]));
    }


    public static void main(String [] args){
        int [][] costs = {{17,16,17},{16,1,15},{4,3,9}};

        System.out.println(minCost(costs));
        int [][] costs1 = {{17,2,17},{16,16,5},{14,3,19}};

        System.out.println(minCost(costs1));
    }
}