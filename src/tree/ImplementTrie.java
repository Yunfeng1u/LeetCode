package tree;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {

    class TrieNode // 字典树节点
    {
        private TrieNode[] son;// 所有的儿子节点
        private boolean isEnd;// 是不是最后一个节点
        private char val;// 节点的值

        TrieNode() {
            son = new TrieNode[26];
            isEnd = false;
        }
    }

    class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            TrieNode node = root;
            char[] letters = word.toCharArray();//将目标单词转换为字符数组
            for (int i = 0, len = word.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] == null)  //如果当前节点的儿子节点中没有该字符，则构建一个TrieNode并复值该字符
                {
                    node.son[pos] = new TrieNode();
                    node.son[pos].val = letters[i];
                }
                node = node.son[pos];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            TrieNode node = root;
            char[] letters = word.toCharArray();
            for (int i = 0, len = word.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] != null) {
                    node = node.son[pos];
                } else {
                    return false;
                }
            }
            //走到这一步，表明可能完全匹配，也可能部分匹配，如果最后一个字符节点为末端节点，则是完全匹配，否则是部分匹配
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            TrieNode node = root;
            char[] letters = prefix.toCharArray();
            for (int i = 0, len = prefix.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] != null) {
                    node = node.son[pos];
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
