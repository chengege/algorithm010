//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 296 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * BFS
     * O(M*N)
     * O(M*N)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> wordMap = new HashMap<>();

        // 替换单词每个字母为 * 作索引
        wordList.forEach(word->{
            for(int i = 0;i < word.length();i++){
                String key = word.substring(0,i) + "*" + word.substring(i + 1);
                List<String> words = wordMap.getOrDefault(key,new ArrayList<>());
                words.add(word);
                wordMap.put(key,words);
            }
        });

        //BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0;

        //记录单词是否使用
        Set<String> visted = new HashSet<>();
        visted.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0;i < size;i++){
                String word = queue.remove();
                for(int j = 0;j < word.length();j++){
                    String key = word.substring(0,j) + "*" + word.substring(j + 1);
                    if(!wordMap.containsKey(key)) continue;
                    for(String adjacentWord : wordMap.get(key)){
                        if(adjacentWord.equals(endWord)) return count + 1;

                        if(!visted.contains(adjacentWord)){
                            visted.add(adjacentWord);
                            queue.add(adjacentWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 双向BFS
     * O(n)
     * O(n)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordMap = new HashMap<>();

        // 替换单词每个字母为 * 作索引
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> words = wordMap.getOrDefault(key, new ArrayList<>());
                words.add(word);
                wordMap.put(key, words);
            }
        });

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int count = 0;
        Set<String> visted = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visted.add(beginWord);
        visted.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            count++;
            Set<String> temp = new HashSet<>();
            for(String bWord : beginSet){
                for(int i = 0;i < bWord.length();i++){
                    String key = bWord.substring(0,i) + "*" + bWord.substring(i + 1);
                    if(!wordMap.containsKey(key)) continue;
                    for(String word : wordMap.get(key)){
                        if(endSet.contains(word)) return count + 1;

                        if(!visted.contains(word)){
                            temp.add(word);
                            visted.add(word);
                        }
                    }
                }
            }
            beginSet = temp;
        }
        return 0;
    }

    /**
     * 2 （快）
     * O(n)
     * O(n)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visted = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int count = 0;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> temp = new HashSet<>();
            count++;
            for(String word : beginSet){
                char[] chs = word.toCharArray();
                for(int i = 0;i < chs.length;i++){
                    char old = chs[i];
                    for(char c = 'a';c <= 'z';c++){
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if(endSet.contains(target)) return count + 1;

                        if(!visted.contains(target) && wordSet.contains(target)){
                            visted.add(target);
                            temp.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
        }
        return 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
