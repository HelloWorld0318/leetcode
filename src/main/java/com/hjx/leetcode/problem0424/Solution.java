package com.hjx.leetcode.problem0424;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houjinxiang
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int res = 0;
        //统计窗口中每个字符的出现次数
        Map<Character, Integer> windows = new HashMap<>();
        //最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符，
        //记录窗口中出现做多的字符的个数
        int maxCount = 0;

        String windowsStr = "";

        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            windowsStr = s.substring(left,right);
            windows.put(ch, windows.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, windows.get(ch));


            while (right - left - maxCount > k) {
                //杂牌字符数量 right - left - windowMaxCount 多于 k
                //此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                //必须缩小窗口
                char deleteChar = s.charAt(left);
                left++;
                windowsStr = s.substring(left,right);
                windows.put(deleteChar, windows.get(deleteChar) - 1);
            }
            /*
            while循环也可以修改成if语句
            if (right - left - maxCount > k) {
                //杂牌字符数量 right - left - windowMaxCount 多于 k
                //此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                //必须缩小窗口
                char deleteChar = s.charAt(left);
                left++;
                windows.put(deleteChar, windows.get(deleteChar) - 1);
            }
             */
            res = Math.max(res, right - left);
        }
        return res;
    }
}
