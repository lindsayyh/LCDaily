package Leetcode;

class AutocompleteSystem {
    class TrieNode{
        Map<Character,TrieNode> children;
        Map<String,Integer> counts;
        TrieNode(){
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }
    TrieNode root;
    TrieNode cur;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();
        for(int i = 0;i<sentences.length;i++){
            String s = sentences[i];
            int count = times[i];
            insert(root,s,count);
        }
    }
    private void insert(TrieNode cur,String s,int count){
        for(int j = 0;j<s.length();j++){
            char c = s.charAt(j);
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
            Map<String,Integer> cmap = cur.counts;
            cmap.put(s,cmap.getOrDefault(s,0)+count);
        }

    }
    public List<String> input(char c) {
        if(c == '#'){
            insert(root,sb.toString(),1);
            cur = root;
            sb.clear();
            return new ArrayList<>();
        }
        sb.append(c);
        if(cur==null || !cur.children.containsKey(c)){
            cur = null;
            return new ArrayList<>();
        }
        cur = cur.children.get(c);
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((e1,e2)->(e1.getValue()==e2.getValue() ?e1.getKey().compareTo(e2.getKey()):e2.getValue()-e1.getValue()));
        pq.addAll(cur.counts.entrySet());
        List<String> result = new ArrayList<>();
        while(result.size()<3 && !pq.isEmpty()){
            result.add(pq.poll().getKey());
        }

        return result;

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
