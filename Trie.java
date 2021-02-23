package Leetcode;

class Trie {
    TrieNode root;
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            int pos = c-'a';
            //System.out.println(pos);
            //System.out.println(Arrays.toString(cur.children));
            if(cur.children[pos]==null){
                cur.children[pos] = new TrieNode();
            }
            cur =  cur.children[pos];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            int pos = c-'a';
            if(cur.children[pos]==null){
                return false;
            }
            cur =  cur.children[pos];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            int pos = c-'a';
            if(cur.children[pos]==null){
                return false;
            }
            cur =  cur.children[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
