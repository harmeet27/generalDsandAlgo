package com.preparation.companywise.amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class A2zAmcart2Questions {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        // WRITE YOUR CODE HERE
        ArrayList<String> answers = new ArrayList<>();
        TreeMap<String, Integer> records = new TreeMap<>();
        for (String feature : possibleFeatures) {
            records.put(feature.toLowerCase(), 0);
        }


        List<Map.Entry<String, Integer>> topAnswers = analyzeData(records, featureRequests);

        for (int i = 0; i < topFeatures; i++) {
            if (i < topAnswers.size() && topAnswers.get(i).getValue() != 0) {
                answers.add(topAnswers.get(i).getKey());

            }
        }

        return answers;
    }
    // METHOD SIGNATURE ENDS


    List<Map.Entry<String, Integer>> analyzeData(TreeMap<String, Integer> records, List<String> featureRequests) {

        for (String sentence : featureRequests) {
            HashSet<String> set = new HashSet<>();
            set.addAll(Arrays.asList(sentence.split(" ")).stream().filter(x -> records.containsKey(x.toLowerCase())).collect(Collectors.toList()));
            set.stream().forEach(x -> records.put(x.toLowerCase(), records.get(x.toLowerCase()) + 1));

//            for (String setWord : set) {
//                records.put(setWord.toLowerCase(), records.get(setWord.toLowerCase()) + 1);
//            }
        }

        //sort hashmap by values
        List<Map.Entry<String, Integer>> topValues = new LinkedList<Map.Entry<String, Integer>>(records.entrySet());
        Collections.sort(topValues, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        return topValues;

    }

    public static void main(String[] args) throws IOException {
        A2zAmcart2Questions sol = new A2zAmcart2Questions();
        List<String> l = new LinkedList<>();
        l.add("storage");
        l.add("battery");
        l.add("hover");
        l.add("alexa");
        l.add("waterproof");
        l.add("solar");

        List<String> fe = new LinkedList<>();
        fe.add("I love Kindle and storage");
        fe.add("battery has great Kindle");
        fe.add("waterproof kindle much better services than bentacullar");
        fe.add("kindle is shower waterproof WAterproof");
        fe.add("Waterproof is kindle waterproof WAterproof");
        fe.add("kindle hover desk better services than");
        fe.add("kindle charged solar sun services than deltacellular");

//        List<String> ans = sol.popularNFeatures(6, 2, l, 7, fe);

//        for (String s : ans) {
//            System.out.println(s);
//        }
        sol.reorderLogFiles();
    }


    public void reorderLogFiles() {
        /**
         * https://massivealgorithms.blogspot.com/2018/11/leetcode-937-reorder-log-files.html
         * You have an array of logs.  Each log is a space delimited string of words.
         * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
         * Each word after the identifier will consist only of lowercase letters, or;
         * Each word after the identifier will consist only of digits.
         * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
         * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
         * Return the final order of the logs.
         *
         * Example 1:
         * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
         * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
         *
         * Approach 1: Custom Sort
         * Instead of sorting in the default order, we'll sort in a custom order we specify.
         * The rules are:
         * Letter-logs come before digit-logs;
         * Letter-logs are sorted alphanumerically, by content then identifier;
         * Digit-logs remain in the same order.
         * It is straightforward to translate these ideas into code.
         */
        List<String> list = new LinkedList<>();
        list.add("a1 9 2 3 1");
        list.add("g1 act car");
        list.add("zo4 4 7");
        list.add("ab1 off key dog");
        list.add("a8 act zoo");
        for (String s : reorderLogFiles(list)) {
            System.out.println(s);
        }
    }

    public List<String> reorderLogFiles(List<String> logs) {
        Collections.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

}
