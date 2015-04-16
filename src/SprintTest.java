

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SprintTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SprintTest
{
    /**
     * Default constructor for test class SprintTest
     */
    public SprintTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Calorias_Test()
    {
        Data_Teste data_Tes1 = new Data_Teste();
        Sprint sprint1 = new Sprint(100, data_Tes1, 30, "Sol", 30, 100);
        assertEquals(834.0000000000001, sprint1.calcBurnCals(), 0.1);
    }
}

