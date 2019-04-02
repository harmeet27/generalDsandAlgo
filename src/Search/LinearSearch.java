package Search;


public class LinearSearch {

    public Integer searchElement(String a, String b[]){
        int i = 0;
        while(i < b.length){
            if(a.equals(b[i])){
                return i;
            }
            i++;
        };
        return -1;
    }

}
