
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class Sample{

    public int change(int amount, int [] coins){
        int [] prev = new int[amount + 1];
        prev[0] = 1;

        for (int coin : coins){

            int [] current = new int[amount + 1];

            current[0] = 1;

            for (int a = 1; a <= amount ; ++a) {

                int select = (a - coin) < 0 ? 0 : current[a - coin];

                int notSelect = prev[a];

                current[a] = select + notSelect;
            }
            prev = current;

            }
        return prev[amount];
        }

    public static void main(String[] args){
        int [] coins = {1,2,5};
        Sample obj = new Sample();
        System.out.println(obj.change(5,coins));
    }

}