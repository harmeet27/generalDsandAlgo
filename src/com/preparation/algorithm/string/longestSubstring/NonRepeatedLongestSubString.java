package com.preparation.algorithm.string.longestSubstring;

import java.util.HashMap;

public class NonRepeatedLongestSubString {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> record=new HashMap();
        if(s==null || s.length()==0){
            return 0;
        }

        int count[]=new int[s.length()];
        int max=1;
        count[0]=1;
        int lastRemovedIndex=-1;

        record.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++){
            Character current = s.charAt(i);
            if(record.containsKey(current)) {
                int lastFetchedIndex=record.get(current);
                if(lastFetchedIndex>lastRemovedIndex){
                    count[i]=i-lastFetchedIndex;
                    lastRemovedIndex=lastFetchedIndex;
                }else{
                    count[i]=count[i-1]+1;
                }
            }
            else{
                count[i]=count[i-1]+1;
            }

            if(count[i]>max){
                max=count[i];
            }
            record.put(current,i);

        }
        return max;
    }
}
