package Leetcode;
import java.util.*;

public class LC336 {
    class TrieNode{
        TrieNode[] children;
        List<Integer> list;
        int index;
        public TrieNode(){
            children = new TrieNode[26];
            list = new ArrayList<>();
            index = -1;
        }

    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(int i = 0;i<words.length;i++){
            insert(new StringBuilder(words[i]).reverse().toString(),i,root);
        }
        for(int i = 0;i<words.length;i++){
            find(words[i],root,result,i);
        }
        return result;
    }

    private void insert(String s, int index,TrieNode root){
        for(int i = 0;i<s.length();i++){
            int pos = s.charAt(i)-'a';
            if(root.children[pos] == null){
                root.children[pos] = new TrieNode();
            }
            if(isPalindrome(s,i)){
                root.list.add(index);
            }
            root = root.children[pos];
        }
        root.index = index;
        root.list.add(index);
    }

    private void find(String s, TrieNode root, List<List<Integer>> result,int index){
        for(int i = 0;i<s.length();i++){
            if(root.index!=-1 && root.index!=index && isPalindrome(s,i)){
                result.add(new ArrayList<>(Arrays.asList(index,root.index)));
            }
            int pos = s.charAt(i)-'a';
            if(root.children[pos] == null){
                return;
            }
            root = root.children[pos];
        }
        for(int num:root.list){
            if(num!=index){
                result.add(new ArrayList<>(Arrays.asList(index,num)));
            }
        }
    }
    private boolean isPalindrome(String s, int i){
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }


}

