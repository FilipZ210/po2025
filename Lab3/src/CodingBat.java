public class CodingBat {
    public int countEvens(int[] nums) {
        int ints = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ints += 1;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        CodingBat cd =  new CodingBat();
        cd.countEvens(new int[]{1,2,3,4,5});
    }
}
