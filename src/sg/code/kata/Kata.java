package sg.code.kata;

import sg.code.converter.IntConverter;
import sg.code.converter.KataConverter;


import java.util.stream.IntStream;

/**
 * Created by Nassim MOUALEK on 18/03/2016.
 * Main Class
 */
public class Kata {
    private static IntConverter converter = new KataConverter();
    public static String printIntegerAsKata(int from, int to) throws Exception {
        if ( from >  to )
            throw new Exception("The second number must be greater than the first one");
        StringBuilder sb = new StringBuilder();
        IntStream.range( from, to+1 ).forEach( (i)-> sb.append( converter.convert(i) ).append(" ") );
        String result = sb.toString().trim();
        System.out.println( result );
        return result;
    }
    public static void main(String[] args){
        try {
            printIntegerAsKata(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
