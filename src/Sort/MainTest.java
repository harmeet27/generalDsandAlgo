package Sort;

public class MainTest {

    public static int test=0;

    static boolean f1(){
        test++;
        return true;
    }

    public static void main(String[] s){
        if((f1() | f1()) ||(f1()) ){
            System.out.println(test);
        }


    }

}
