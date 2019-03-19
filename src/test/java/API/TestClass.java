package API;

import org.junit.jupiter.api.Test;

public class TestClass {

    public TestClass(){};

    @Test
    public void simpleTest(){

        Time time = new Time(Long.MAX_VALUE);
        System.out.println("Time mit Long.MAX_VALUE: " + time.getTime());
    }
}
