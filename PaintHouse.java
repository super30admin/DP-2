class PaintHouse {

    public int minCost(int[][] costs) {

        int numOfHouse = costs.length;
        int[] array = new int[numOfHouse];

        int min = Integer.MAX_VALUE;
        for (int i=0; i<numOfHouse; i++) {
            for (int i=0; i<3; i++) {
                min = Math.min(numOfHouse[i], min);
            }
        }

        return min;
        
    }

}