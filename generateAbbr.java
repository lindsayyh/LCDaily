package Leetcode;
import java.util.*;

public class generateAbbr {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(0,word,new StringBuilder(),1,result);
        return result;
    }

    private void helper(int index, String word, StringBuilder sb, int count,List<String> result){
        if(index == word.length()){
            result.add(sb.toString());
            return;
        }
        sb.append((word.charAt(index)));
        helper(index+1,word,sb,1,result);
        sb.deleteCharAt(sb.length()-1);

        removeLastDigits(sb);
        sb.append(count);
        helper(index+1,word,sb,count+1,result);
        removeLastDigits(sb);
        if(count!=1){
            sb.append(count-1);
        }

    }

    private void removeLastDigits(StringBuilder sb){
        while(sb.length()>0 && sb.charAt(sb.length()-1)>='0' &&sb.charAt(sb.length()-1)<='9'){
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
