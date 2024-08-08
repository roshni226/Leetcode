class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        Map<Character,Integer> mp= new HashMap<>();
        for(char c: s.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap= new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        StringBuilder result= new StringBuilder();
        maxHeap.addAll(mp.entrySet());
        while(!maxHeap.isEmpty())
        {
            Map.Entry<Character,Integer> entry= maxHeap.remove();
            char c= entry.getKey();
            int freq=entry.getValue();
            
            result.append(String.valueOf(c).repeat(freq));
        }
        return result.toString();
        
    }
}