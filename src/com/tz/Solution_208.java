package com.tz;

// todo 前缀树（字典树）的实现原理
public class Solution_208 {

    class Trie {
        /**
         * Trie() 初始化前缀树对象。
         * void insert(String word) 向前缀树中插入字符串 word 。
         * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
         * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
         */
        // 可以知道是一个多叉树，而树是26个字母

        private Trie[] children;
        private boolean isEnd;

        // 初始化当前结点
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {

        }

        public boolean search(String word) {
            return true;
        }

        public boolean startsWith(String prefix) {
            return true;

        }
    }

}
