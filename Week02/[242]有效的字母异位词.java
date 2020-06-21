//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

/**
 * hash存储s每个字母出现次数，遍历t查找hash
 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1、hash存储s每个字母，遍历t查找hash
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> temp = new HashMap<>();
        for(char c:s.toCharArray()){
            Integer tiems = temp.get(c);
            temp.put(c,temp.containsKey(c)?++tiems:1);
        }

        for(char c:t.toCharArray()){
            Integer times = temp.get(c);
            if(!temp.containsKey(c) || --times < 0){
                return false;
            }
            temp.put(c,times);
        }
        return true;
    }

    /**
     * 2、排序,比较字符串是否相等
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     */
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(str1, str2);
    }

    /**
     * 2、hash表2
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 也可写成类似1中的判断
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] counts= new int[26];// 26个字母
        for(int i = 0;i < s.length();i++){
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count : counts){
            if(count > 0) return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
