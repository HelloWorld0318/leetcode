package com.hjx.leetcode.problem0071;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String res = "";
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < pathArray.length; i++) {
            String str = pathArray[i];
            if (str.length() == 0 || str.equals(".")) {
                continue;
            }
            if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(str);
        }
        while (!stack.isEmpty()) {
            if (res.length() == 0) {
                res = "/" + stack.pop();
            } else {
                res = "/" + stack.pop() + "/" + res;
            }
        }
        return res;
    }
}
