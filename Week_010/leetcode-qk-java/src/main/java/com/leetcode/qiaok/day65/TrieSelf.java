package com.leetcode.qiaok.day65;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 *  示例:
 *
 *  Trie trie = new Trie();
 *
 *  trie.insert("apple");
 *  trie.search("apple");   // 返回 true
 *  trie.search("app");     // 返回 false
 *  trie.startsWith("app"); // 返回 true
 *  trie.insert("app");
 *  trie.search("app");     // 返回 true
 *  说明:
 *
 *  你可以假设所有的输入都是由小写字母 a-z 构成的。
 *  保证所有输入均为非空字符串。
 *
 *  https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 *
 *  @since 2020-06-30
 *  @author qiaok
 */
public class TrieSelf {

    private TrieNodeSelf root;

    /** Initialize your data structure here.**/
    public TrieSelf() {
        root = new TrieNodeSelf();
    }

    /** Inserts a word into the trie.**/
    public void insert(String word) {
        TrieNodeSelf node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNodeSelf());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie.**/
    public boolean search(String word) {
        TrieNodeSelf node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix.**/
    public boolean startsWith(String prefix) {
        TrieNodeSelf node = searchPrefix(prefix);
        return node != null;
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNodeSelf searchPrefix(String word) {
        TrieNodeSelf node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }


}
