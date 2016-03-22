package sg.code;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sg.code.converter.KataConverter;
import sg.code.kata.Kata;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by Nassim MOUALEK on 18/03/2016.
 */
public class TestKata {
    private static String kata;
    private static List<String> kataValues;

    @BeforeClass
    public static void test() throws Exception {
        kata = Kata.printIntegerAsKata(1, 100);
        kataValues = Arrays.asList(kata.split(" "));
    }


    /** Check that the number is divisible by N or contains N, replace N by Kata_value; */
    @Test
    public void test1_divisible_by_N_or_contains_N(){
        AtomicInteger i = new AtomicInteger(1);
        kataValues.forEach((a)->{
                KataConverter.intToStrMap.forEach((k, v)->{
                    if (i.get()%k==0)
                        Assert.assertTrue( i+" is divisible by "+k+" but it dosnt contains "+v, a.contains(v.toString()));
                });
                i.incrementAndGet();
        });
    }

    /** Check that the divisors have high precedence; */
    @Test
    public void test2_divisors_have_high_precedence(){
        AtomicInteger i = new AtomicInteger(1);
        kataValues.forEach((a)->{
            AtomicInteger number_of_divisors_in_a = new AtomicInteger(0);
            KataConverter.intToStrMap.forEach((k, v)->{
                if (i.get()%k==0)
                    number_of_divisors_in_a.incrementAndGet();
            });
            KataConverter.intToStrMap.forEach((k, v)->{
                if (i.get()%k==0){
                    KataConverter.charToStrMap.forEach((h, j)->{
                        if (i.toString().contains(h.toString()))
                            Assert.assertTrue(a.indexOf(v.toString())<a.indexOf(j.toString(), number_of_divisors_in_a.get()*3));
                    });
                }
            });
            i.incrementAndGet();
        });
    }
    /** Check that the content is analysed in the order they appear */
    @Test
    public void test3_order_of_appearance(){
        AtomicInteger i = new AtomicInteger(1);
        kataValues.forEach((a)->{
                    AtomicInteger number_of_divisors_in_a = new AtomicInteger(0);
                    KataConverter.intToStrMap.forEach((k, v)->{
                        if (i.get()%k==0)
                            number_of_divisors_in_a.incrementAndGet();
                    });
                    AtomicInteger lastIndex_in_i = new AtomicInteger(-1);
                    List<String> keys =  Arrays.asList(a.split("(?<=\\G.{3})"));
                    keys.forEach((k)->{
                        int newIndex = a.indexOf(k, number_of_divisors_in_a.get()*3);
                        StringBuilder key = new StringBuilder();
                        KataConverter.charToStrMap. forEach((ke, v)->{if (v.toString().equals(k)) key.append(ke);});
                        if (key.length()!=0){
                            int newIndex_in_i = i.toString().indexOf( key.toString() );
                            if (lastIndex_in_i.get()!=-1 && newIndex>-1)
                                Assert.assertTrue( "Order of appearance is not respected in i="+i.get(), newIndex > lastIndex_in_i.get() );
                            lastIndex_in_i.set( newIndex_in_i );
                        }
                    });
            i.incrementAndGet();
        });
    }
}
