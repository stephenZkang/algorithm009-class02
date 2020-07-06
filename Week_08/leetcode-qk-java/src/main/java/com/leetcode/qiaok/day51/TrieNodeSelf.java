package com.leetcode.qiaok.day51;

class TrieNodeSelf {

    // R links to node children
    private TrieNodeSelf[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNodeSelf() {
        links = new TrieNodeSelf[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNodeSelf get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNodeSelf node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
