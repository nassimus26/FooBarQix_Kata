package sg.code;

import org.junit.Test;
import sg.code.kata.Kata;

/**
 * Created by Nassim MOUALEK on 18/03/2016.
 */
public class TestKata {
    @Test
    public void test(){
        try {
            Kata.printIntegerAsKata(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
