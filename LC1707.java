package Leetcode;

public class LC1707 {
    class TrieNode{
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[2];
        }
    }
    TrieNode root;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        root = new TrieNode();
        int[] result = new int[queries.length];
        int[][] newq = new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            newq[i][0] = queries[i][0];
            newq[i][1] = queries[i][1];
            newq[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(newq,(q1,q2)->(q1[1]-q2[1]));
        int j = 0;
        for(int i = 0;i<newq.length;i++){
            while(j<nums.length && nums[j]<=newq[i][1]){
                insert(nums[j]);
                j++;
            }
            result[newq[i][2]] = findMax(newq[i][0]);
        }
        return result;
    }
    private int findMax(int num){
        int maxSoFar = 0;
        TrieNode cur = root;
        for(int i = 31;i>=0;i--){
            int bit = getBit(num,i);
            int toggleBit =bit ==0?1:0;
            if(cur.children[toggleBit]!=null){
                maxSoFar = (maxSoFar<<1)|1;
                cur = cur.children[toggleBit];
            }else if(cur.children[bit]!=null){
                maxSoFar = maxSoFar<<1;
                cur = cur.children[bit];
            }else{
                return -1;
            }

        }
        return maxSoFar;
    }
    private void insert(int num){
        TrieNode cur = root;
        for(int i = 31;i>=0;i--){
            int bit = getBit(num,i);
            if(bit == 0){
                if(cur.children[0]==null){
                    cur.children[0] = new TrieNode();
                }
                cur = cur.children[0];
            }else{
                if(cur.children[1]==null){
                    cur.children[1] = new TrieNode();
                }
                cur = cur.children[1];
            }
        }
    }
    private int getBit(int num,int i){
        return num>>i & 1;
    }
}
