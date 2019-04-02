import Search.BinarySearch;
import Search.LinearSearch;

import java.util.Scanner;

public class Main {
    public static void main(String... args){
        Scanner st = new Scanner(System.in);
        Integer length =  st.nextInt();
        Integer[] InputArray = new Integer[length];
        int i = 0;
        while (i < length){
            InputArray[i] = st.nextInt();
            i++;

        }
//        LinearSearch search = new LinearSearch();
        BinarySearch search1 = new BinarySearch();
        int Index = search1.searchElement(InputArray, st.nextInt());
        System.out.println(Index);
        st.close();
    }
}
