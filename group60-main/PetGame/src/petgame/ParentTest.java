package petgame;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParentTest {
	Parent test;

    @BeforeEach
    void setUp() {
        test = new Parent("pass");
    }

    @Test
    void getPassTest() {
        String result = "pass";
        String expected = test.getPassword();
        assertEquals(result, expected);
    }

    @Test
    void setPassTest() {
        try {
			test.setPassword("pass");
		} catch (IOException e) {
			e.printStackTrace();
		}
        String result = test.getPassword();
        String expected = "pass";
        assertEquals(result, expected);
    }

    @Test
    void testSetWindowAndGetTimes() {
        test.setWindow(5, 15);
        assertEquals(5, test.getStartTime());
        assertEquals(15, test.getEndTime());
    }

    @Test
    void testInWindowTrue() {
        test.setWindow(5, 15);
        test.setClock(10);
        assertTrue(test.inWindow());
    }

    @Test
    void testInWindowFalse_BeforeStart() {
        test.setWindow(5, 15);
        test.setClock(3);
        assertFalse(test.inWindow());
    }

    @Test
    void testInWindowFalse_AfterEnd() {
        test.setWindow(5, 15);
        test.setClock(16);
        assertFalse(test.inWindow());
    }

    @Test
    void testAddTime() {
        test.addTime(10);
        test.addTime(5);
        assertEquals(15, test.getTotalTime());
    }
}
