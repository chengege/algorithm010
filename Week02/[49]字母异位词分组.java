//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

/**
 * 1、排序+map
 *
 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1、排序 + map
     * 时间复杂度O(N KlogK)
     * 时间复杂度O(N K)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashMap = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!hashMap.containsKey(key))
                hashMap.put(key,new ArrayList<String>()); // 创建
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    /**
     * 2、按计数分类
     * 时间复杂度O(N K)
     * 时间复杂度O(N K)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> hashMap = new HashMap<>();
        int[] counts = new int[26];
        for(String str:strs){
            Arrays.fill(counts,0);
            for(char c:str.toCharArray())
                counts[c - 'a']++;

            int key = Arrays.hashCode(counts);
            if(!hashMap.containsKey(key))
                hashMap.put(key,new ArrayList<String>());
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
