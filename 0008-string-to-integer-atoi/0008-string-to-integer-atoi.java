// class Solution {
//     public int myAtoi(String s) {
//         String s1= s.trim();
//         int n= s1.length();
//         int i=0;
//         if(n==0) return 0;
//         long ans=0;
//         StringBuilder sb= new StringBuilder();
//         int sign=1;
//         if(s1.charAt(i)=='-')
//         {
//             sign=-1;
//             i++;
//         }
//         else if(s1.charAt(i)=='+')
//         {
//             i++;
//         }
//         else if(!(s1.charAt(i)>=48 && s1.charAt(i)<=57))
//            return 0;
        
        
//         while(i<n && s.charAt(i)=='0')
//             i++;
        
//         for(;i<n;i++)
//         {
//             if(!(s1.charAt(i)>=48 && s1.charAt(i)<=57))
//                break;
//             sb.append(s1.charAt(i));
//         }
        
//         String s2=sb.toString();
//         if(s2.equals("")) return 0;
//         ans=Long.parseLong(s2);
//         if(sign==-1) ans= ans-2*ans;
//         if(ans<Integer.MIN_VALUE)
//                ans=Integer.MIN_VALUE;
//         else if(ans>Integer.MAX_VALUE)
//                ans=Integer.MAX_VALUE;
//         int a=(int)ans;
//         return a;
//     }
// }

class Solution {
    public int myAtoi(String s) {
        // Trim leading and trailing whitespaces
        String s1 = s.trim();
        int n = s1.length();
        if (n == 0) return 0;

        long ans = 0;
        StringBuilder sb = new StringBuilder();
        int sign = 1;  // +1 for positive, -1 for negative
        int i = 0;

        // Check for sign
        if (s1.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s1.charAt(0) == '+') {
            i++;
        }

        // Skip leading zeros
        while (i < n && s1.charAt(i) == '0') {
            i++;
        }

        // Build the number
        while (i < n && s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
            sb.append(s1.charAt(i));
            i++;
        }

        // Handle empty case after removing zeros
        if (sb.length() == 0) return 0;

        // Convert to number
        try {
            ans = Long.parseLong(sb.toString()) * sign;
        } catch (NumberFormatException e) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Clamp the result within the integer bounds
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) ans;
    }
}
