package junit.samples;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Some simple tests.
 */
public class SimpleTest extends TestCase {
    protected int fValue1;
    protected int fValue2;

    @Override
    protected void setUp() {
        fValue1 = 2;
        fValue2 = 3;
    }

    public static Test suite() {

        /*
           * the type safe way
           *
          TestSuite suite= new TestSuite();
          suite.addTest(
              new SimpleTest("add") {
                   protected void runTest() { testAdd(); }
              }
          );

          suite.addTest(
              new SimpleTest("testDivideByZero") {
                   protected void runTest() { testDivideByZero(); }
              }
          );
          return suite;
          */

        /*
           * the dynamic way
           */
        return new TestSuite(SimpleTest.class);
    }

    public void testAdd() {
        double result = fValue1 + fValue2;
        // forced failure result == 5
        assertTrue(result == 6);
    }

    public int unused;

    public void testDivideByZero()
    {
        try {
            int zero = 0;
            int result = 8 / zero;
            unused = result; // avoid warning for not using result
            fail("Must throw Arithmetic Exception");
        }
        catch (ArithmeticException ex) {
            assertTrue(true == true);
            assertEquals(ex.getMessage(), "/ by zero");
            // anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }
    public void testDivideBy1() {
        try {
            int a = Integer.getInteger("");
            unused = a;// avpid warning for not using result
            fail("Must throw NullPointerException");
        } catch (NullPointerException ex) {
            assertTrue(true == true);
            assertEquals(ex.getMessage(),null);
        }
    }

    public void testEquals() {
        assertEquals(12, 1/2);
        assertEquals(12L, 12L);
        assertEquals(new Long(12), new Long(12));

        assertEquals("Size", 12, 13);
        assertEquals("Capacity", 12.0, 11.99, 0.0);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}