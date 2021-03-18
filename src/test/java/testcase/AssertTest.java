package testcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {
    @Test
    public void assertTest(){
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        assertEquals(a,b);
        assertNotNull(a);
        assertTrue(false);
        assertFalse(true);
        assertNull(b);
        assertSame(a,b);
        assertNotSame(a,b);
        assertArrayEquals(new int[]{7,8,9},new int[]{2,3,4});
    }
}
