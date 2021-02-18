package Leetcode;
import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0,0,n,new StringBuilder(),result);
        return result;
    }
    public void helper(int left, int right, int n, StringBuilder sb, List<String> result){
        if(left==n && right == n){
            result.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append("(");
            helper(left+1,right,n,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(")");
            helper(left,right+1,n,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
