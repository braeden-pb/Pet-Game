package petgame;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConfigFileTest {

	private static ConfigFile test = new ConfigFile();
	private static String password = test.getPassword();
	
	@BeforeAll
    public static void setUpBeforeClass() throws Exception {
        test = new ConfigFile();
        password = test.getPassword();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        test.setPassword(password);
    }

	@Test
	public void testGetPassword() throws IOException {
		test.setPassword("1234");
		String result = test.getPassword();
		String expectedResult = "1234";
		assertEquals(result, expectedResult);
	}

	@Test
	public void testTimeWindowEnabled() {
		Boolean result = test.timeWindowEnabled();
		Boolean expectedResult = false;
		assertEquals(result, expectedResult);
	}

	@Test
	public void testSetPassword() throws IOException {
		String expectedResult = "0000";
		test.setPassword("0000");
		ConfigFile testPassword = new ConfigFile();
		assertEquals(testPassword.getPassword(), expectedResult);
	}

}
