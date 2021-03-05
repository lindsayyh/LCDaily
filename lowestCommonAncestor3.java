package Leetcode;

public class lowestCommonAncestor3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        traverse(p,list1);
        traverse(q,list2);
        int i = list1.size()-1;
        int j = list2.size()-1;
        while(i>=0 && j>=0){
            if(list1.get(i)!=list2.get(j)){
                break;
            }
            i--;
            j--;
        }
        return list1.get(i+1);
    }
    private void traverse(Node node, List<Node> list){
        while(node!=null){
            list.add(node);
            node = node.parent;
        }
    }
}
