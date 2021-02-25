package Leetcode;
import java.util.*;

class WordFilter {
    TrieNode root1;
    TrieNode root2;
    public WordFilter(String[] words) {
        root1 = new TrieNode();
        root2 = new TrieNode();
        for(int i = 0;i<words.length;i++){
            insert(root1,words[i],i);
            insert(root2,new StringBuilder(words[i]).reverse().toString(),i);
        }
    }

    public int f(String prefix, String suffix) {
        List<Integer> list1 = find(root1,prefix).list;
        List<Integer> list2 = find(root2,new StringBuilder(suffix).reverse().toString()).list;
        int i = list1.size()-1;
        int j = list2.size()-1;
        while(i>=0 && j>=0){
            if(list1.get(i)>list2.get(j)){
                i--;
            }else if(list1.get(i)<list2.get(j)){
                j--;
            }else{
                return list1.get(i);
            }
        }
        return -1;
    }

    private void insert(TrieNode root, String word,int index){
        TrieNode cur = root;
        char[] array = word.toCharArray();
        for(int i = 0;i<array.length;i++){
            int pos = array[i]-'a';
            if(cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            cur.children[pos].list.add(index);
            cur = cur.children[pos];
        }
    }
    private TrieNode find(TrieNode root, String prefix){
        TrieNode cur = root;
        char[] array = prefix.toCharArray();
        for(int i = 0;i<array.length;i++){
            int pos = array[i]-'a';
            if(cur.children[pos] == null){
                return new TrieNode();
            }
            cur = cur.children[pos];
        }
        return cur;
    }

    class TrieNode{
        List<Integer> list;
        TrieNode[] children;
        TrieNode(){
            list = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
