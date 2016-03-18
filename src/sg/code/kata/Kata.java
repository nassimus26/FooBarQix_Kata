package sg.code.kata;

import sg.code.converter.IntConverter;
import sg.code.converter.KataConverter;


import java.util.stream.IntStream;

/**
 * Created by Nassim MOUALEK on 18/03/2016.
 * Main Class
 */
public class Kata {
    private static IntConverter converter; //TODO init with the right implementation
    public static void printIntegerAsKata(int from, int to) throws Exception {
        if ( from >  to )
            throw new Exception("The second number must be greater than the first one");
        StringBuilder sb = new StringBuilder();
        IntStream.range( from, to+1 ).forEach( (i)-> sb.append( converter.convert(i) ).append(" ") );
        System.out.println( sb.toString().trim() );
    }
    public static void main(String[] args){
        try {
            printIntegerAsKata(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
