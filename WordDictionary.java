package Leetcode;

public class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
        };
    }

    TrieNode root;


    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i< word.length();i++){
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos]==null){
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root,word);
    }

    private boolean helper(TrieNode cur,String word){
        if(word.length() == 0){
            if(cur.isWord){
                return true;
            }
            return false;
        }
        char c = word.charAt(0);
        if(c == '.'){
            for(int j = 0; j<cur.children.length;j++){
                if(cur.children[j]!=null){
                    if (helper(cur.children[j],word.substring(1))){
                        return true;
                    }
                }
            }
        }
        else{
            int pos = c - 'a';
            if(cur.children[pos]!=null){
                if(helper(cur.children[pos],word.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }
}
