package com.hjx.leetcode.problem0134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         *解题报告:diff[i] = gas[i] - cost[i]
         *假设汽车从站点i出发,在到达站点k之前油箱没有见底,即:diff[i] + diff[i+1] + ... + diff[k-1] >= 0
         *但是到达站点k的时候,油箱见底了,即:diff[i] + diff[i+1] + ... + diff[k-1] + diff[k] < 0
         *这个时候还有必要再从站点i+1尝试吗?车要是从i+1出发,达到站点k后,甚至还没有达到站点k之前,油箱肯定已经见底了,因为少加了站点i的油,所以直接从k的下一个站点考虑,i到k之间的站点不用考虑
         *
         *因此解法时间复杂度从O(n^2)降到了 O(2n)。之所以是O(2n)，是因为将k+1站作为始发站，车得绕圈开回k，来验证k+1是否满足。但是仔细想想,真有必要让车在绕回来吗?
         *
         *我们可以模拟一下这个过程:
         *a.最开始，站点0是始发站，假设车开出站点p后，油箱空了，假设sum1 = diff[0] +diff[1] + ... + diff[p]，可知sum1 < 0；
         *b.根据上面的论述，我们将p+1作为始发站，开出q站后，油箱又空了，设sum2 = diff[p+1] +diff[p+2] + ... + diff[q]，可知sum2 < 0
         *c.将q+1作为始发站，假设一直开到了未循环的最末站，油箱没见底儿，设sum3 = diff[q+1] +diff[q+2] + ... + diff[size-1]，可知sum3 >= 0
         *
         *要想知道车能否开回 q站，其实就是在sum3 的基础上，依次加上 diff[0] 到 diff[q]，看看sum3在这个过程中是否会小于0。
         *但是我们之前已经知道 diff[0] 到 diff[p-1] 这段路，油箱能一直保持非负，因此我们只要算算sum3 + sum1是否 <0，
         *就知道能不能开到 p+1站了。如果能从p+1站开出，只要算算sum3 + sum1 + sum2 是否 < 0，就知都能不能开回q站了。
         *因为 sum1, sum2 都 < 0，因此如果 sum3 + sum1 + sum2 >=0 那么 sum3 + sum1 必然 >= 0，也就是说，
         *只要sum3 + sum1 + sum2 >=0，车必然能开回q站。而sum3 + sum1 + sum2 其实就是 diff数组的总和 Total，
         *遍历完所有元素已经算出来了。因此 Total 能否 >= 0，就是是否存在这样的站点的 充分必要条件。
         *
         *这样时间复杂度进一步从O(2n)降到了 O(n)。
         */
        int result = -1, total = 0, sum = 0, diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff = gas[i] - cost[i];
            total += diff;
            sum += diff;
            if (sum < 0) {
                sum = 0;
                result = i;
            }
        }
        return total < 0 ? -1 : result + 1;
    }
}
