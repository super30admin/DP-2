//Time Complexity: O(n) 
//Space complexity: O(m) M: number of paints

public class PaintHouse {
    public static int paint(int[][] house) {
        int[] temp = house[0];
        //Taking mins and summing it up and then considering min from those
        for(int i=1; i<house.length; i++){
            temp[0] += Math.min(house[i][1],house[i][2]);
            temp[1] += Math.min(house[i][2],house[i][0]);
            temp[2] += Math.min(house[i][0],house[i][1]);
        }
        return Math.min(temp[0], Math.min(temp[1], temp[2]));
    }

    public static void main(String[] args) {
        int[][] paint = {{1,2,5},{1,2,5},{1,0,5}};
        System.out.println(paint(paint));
    }
}