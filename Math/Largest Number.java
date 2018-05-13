//Largest Number

class Solution {
    class myComparator implements Comparator<String> {
        public int compare(String left, String right) {
            String num1 = left + right;
            String num2 = right + left;
            return num2.compareTo(num1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] s_nums = new String[nums.length];
        for (int i = 0;i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, new myComparator());
        StringBuffer res = new StringBuffer();
        if (s_nums[0].equals("0")) {
            return "0";
        }
        for (String num : s_nums) {
            res.append(String.valueOf(num));
        }
        return res.toString();
    }
}