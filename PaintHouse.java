// Time Complexity : O(m) where m is the number of houses (3*n)
// Space Complexity : O(m) where is the total number of houses (3*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
class PaintHouse {
    private int[] arr;
    private int MAX = 99999;
    private int numOfColumns = 3;
    private int numOfRows;

    public int minCost(int[][] costs)
    {
        if(costs == null || costs.length < 1)
        {
            return 0;
        }
        numOfRows = costs.length;
        arr = new int[ numOfRows * numOfColumns];
        for(int i = 0; i<arr.length; i++)
        {
            arr[i] = MAX;
        }
        return getPathSum(costs, arr.length -1);
    }

    private int getPathSum(int[][] nums, int currentIndex)
    {
        for(int i=0; i<arr.length; i++)
        {
            int currentRow = i/numOfColumns;
            int currentColumn = i%numOfColumns;
            //if first row

            if(currentRow == 0)
            {
                arr[i] = nums[0][i];
            }
            else
            {
                //first column
                if(currentColumn == 0)
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn+1)],
                                    arr[getArrIndexfrom2D(currentRow-1 , currentColumn +2)]);
                }
                //3rd column
                else if(currentColumn == numOfColumns -1)
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn-2)],
                                    arr[getArrIndexfrom2D(currentRow-1 ,currentColumn -1)]
                            );
                }
                //2nd column
                else
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn-1)],
                                    arr[getArrIndexfrom2D(currentRow-1, currentColumn+1)]
                            );
                }
            }
        }
        int minValue = MAX;
        for(int i = arr.length-1; i > arr.length-1 - numOfColumns;i--)
        {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }

    private int getArrIndexfrom2D(int rowNumber, int columnNuber)
    {
        return (rowNumber * numOfColumns) + columnNuber;
    }
}
