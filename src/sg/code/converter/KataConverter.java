package sg.code.converter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Nassim MOUALEK on 18/03/2016.
 * Default implementation for IntConverter (Kata)
 */
public class KataConverter implements IntConverter{
    public enum KataValues {Foo, Bar, Qix}
    public static Map<Integer, KataValues> intToStrMap = new LinkedHashMap<Integer, KataValues>();
    public static Map<Character, KataValues> charToStrMap = new LinkedHashMap<Character, KataValues>();
    static{
        intToStrMap.put( 3, KataValues.Foo );
        intToStrMap.put( 5, KataValues.Bar );
        intToStrMap.put( 7, KataValues.Qix );
        charToStrMap.put( '3', KataValues.Foo );
        charToStrMap.put( '5', KataValues.Bar );
        charToStrMap.put( '7', KataValues.Qix );
    }

    @Override
    public String convert(Integer i) {
        StringBuilder sb = new StringBuilder();
        String i_asString = i.toString();
        List<Character> i_asListOfChars = i_asString.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        intToStrMap.forEach( (k, v)-> {
            if (i%k==0)
                sb.append(v);} );
        i_asListOfChars.stream().forEach( (c)-> {
            KataValues kv = charToStrMap.get(c);
            if (kv!=null)
                sb.append(kv);
        });
        if (sb.length()==0)
            return i_asString;
        return sb.toString();
    }
}
