package homework.hw0224;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;


@RunWith(JUnit4.class)
public class SlicesTest {

    private String basePackage = "src/test/testdata/";

    public SlicesTest() {
    }

    /**
     * запускать отдельно
     */
    @Test
    public void initTest() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"test1"));
        System.setIn(in);
        Assert.assertEquals("8 8 8 4",Slices.maxListSlices());
    }

    @Test
    public void initTest2() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"test2"));
        System.setIn(in);
        Assert.assertEquals("1 1 3 4 8 8 3 2",Slices.maxListSlices());
    }

    @Test
    public void initTest3() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"test3"));
        System.setIn(in);
        Assert.assertEquals("8 8 5 5 5",Slices.maxListSlices());
    }

    /**
     * Speed tests
     */

    @Test
    public void speedTest1() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"num1000x100"));
        System.setIn(in);
        long t1 = System.currentTimeMillis();
        Slices.maxListSlices();
        long t2 = System.currentTimeMillis();
        System.out.println("result for 1000x100 "+(t2-t1)); // 130ms
    }

    @Test
    public void speedTest2() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"num100000x100"));
        System.setIn(in);
        long t1 = System.currentTimeMillis();
        Slices.maxListSlices();
        long t2 = System.currentTimeMillis();
        System.out.println("result for 100000x100 "+(t2-t1)); // 371ms
    }
    @Test
    public void speedTest3() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(basePackage+"num1000000x100"));
        System.setIn(in);
        long t1 = System.currentTimeMillis();
        Slices.maxListSlices();
        long t2 = System.currentTimeMillis();
        System.out.println("result for 1000000x100 "+(t2-t1)); // 3576ms
    }




}