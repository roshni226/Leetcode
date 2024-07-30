class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder();
        int openCount=0;
        
        for(char c: s.toCharArray())
        {
            if(c=='(')
            {
                if(openCount!=0)
                    sb.append(c);
                openCount++;
            }
            else if(c==')')
            {
                openCount--;
                if(openCount!=0)
                    sb.append(c);
            }    
        }
        
        return sb.toString();
    }
}