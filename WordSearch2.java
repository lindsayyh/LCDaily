package Leetcode;

public class WordSearch2 {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
        };
    }
    public void insert(String word) {
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

    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        root = new TrieNode();
        for(String word:words){
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                boolean[][] visited = new boolean[m][n];
                StringBuilder sb = new StringBuilder();
                search(board,i,j,m,n,sb,visited,set,root);

            }
        }
        return new ArrayList(set);
    }

    private void search(char[][] board, int i,int j, int m, int n,StringBuilder sb
            ,boolean[][] visited, Set<String> set,TrieNode root){
        if(root.isWord){
            set.add(sb.toString());
        }
        if(i<0||i>=m||j<0||j>=n||visited[i][j]){
            return;
        }
        char c = board[i][j];
        int pos = c-'a';
        if(root.children[pos]==null){
            return;
        }

        visited[i][j] = true;
        sb.append(c);
        for(int[] dir:dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            search(board,ni,nj,m,n,sb,visited,set,root.children[pos]);
        }
        sb.deleteCharAt(sb.length()-1);
        visited[i][j] = false;
    }
}
