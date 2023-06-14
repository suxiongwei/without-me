import com.sxw.learn.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            int num1 = nums[first];
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            for (int second = first + 1; second < nums.length; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                int sum = 0 - num1;
                int third = nums.length - 1;
                while (second < third && nums[second] + nums[third] > sum){
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[third] + nums[second] == sum){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);

                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
