package com.preparation.ds.tries;

public class WordChecker {

    public static void main(String... s) {
        Tries tries = new Tries();

        tries.add("ABCD");
        tries.add("PRAT");
        tries.add("KITA");
        tries.add("ANDY");

        System.out.println(tries.search("KIT"));
    }
}
