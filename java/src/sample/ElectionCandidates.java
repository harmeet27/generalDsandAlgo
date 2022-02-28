package sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * [[A,B,C],
 * [B,D,A]]  --> 1,2,3
 * <p>
 * No defined candidates:
 * <p>
 * Map<String,Integer> voterMap --> candidate, score
 * o(N*3)  --> M represtnt canduidate
 * <p>
 * maxHeap --> poll --> NlogM
 * <p>
 * A : 4
 * B : 5
 * C : 1
 * D : 2
 * <p>
 * (B,A,D,C)
 */

public class ElectionCandidates {

    static class Medals {
        int first;
        int second;
        int third;
    }

    public static List<String> getCandidatesOrder(List<List<String>> votes) {

        //Base case
        Map<String, Medals> voterMap = new HashMap<>();

        for (List<String> vote : votes) {
            //3 values
            int score = 3;
            for (int i = 0; i < vote.size(); i++) {
                String person = vote.get(i);
                if (voterMap.containsKey(person)) {
                    Medals exisitngMedal = voterMap.get(person);

                    voterMap.put(person, getMedal(exisitngMedal, score));
                } else {
                    Medals medals = new Medals();
                    voterMap.put(person, getMedal(medals, score));
                }
                score--;
            }
        }

        List<Map.Entry<String, Medals>> orderedList = new LinkedList<>();
        for (Map.Entry<String, Medals> voter : voterMap.entrySet()) {
            orderedList.add(voter);
        }

        Collections.sort(orderedList, (first, second) -> {
            Medals firstMedal = first.getValue();
            Medals secondMedal = second.getValue();

            int fTotal = (3*firstMedal.first)+(2*firstMedal.second)+firstMedal.third;
            int sTotal= (3*secondMedal.first)+(2*secondMedal.second)+secondMedal.third;
            if(fTotal<sTotal){
                return 1;
            }else if(fTotal>sTotal){
                return -1;
            }

            if(firstMedal.first>secondMedal.first){
                return -1;
            }else if(firstMedal.second>secondMedal.second){
                return -1;
            }
            return 0;
        });

        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Medals> orderCandidate : orderedList) {
            result.add(orderCandidate.getKey());
        }

        return result;
    }


    private static Medals getMedal(Medals exisitngMedal, int score) {
        if (score == 3) {
            exisitngMedal.first = exisitngMedal.first + 1;
        } else if (score == 2) {
            exisitngMedal.second = exisitngMedal.second + 1;
        } else {
            exisitngMedal.third = exisitngMedal.third + 1;
        }
        return exisitngMedal;

    }

    public static void main(String... s) {
        List<List<String>> input = new LinkedList<>();
        List<String> fPerson = new LinkedList<>();
        fPerson.add("A");
        fPerson.add("B");
        fPerson.add("C");
        List<String> sPerson = new LinkedList<>();
        sPerson.add("B");
        sPerson.add("D");
        sPerson.add("C");
        input.add(fPerson);
        input.add(sPerson);

        List<String> result = getCandidatesOrder(input);
        for (String res : result) {
            System.out.println(res);
        }
    }

}
