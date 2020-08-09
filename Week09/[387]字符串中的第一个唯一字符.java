//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * O(n)
     * O(n)
     */
    public int firstUniqChar(String s) {
        int[] temp = new int[26];
        for(char c:s.toCharArray())
            temp[c - 'a']++;
        for(char i = 0;i < s.length();i++){
            if(temp[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
    /**
     * O(n)
     * O(n)
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c,map.getOrDefault(c,0) + 1);
        for(char i = 0;i < s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
