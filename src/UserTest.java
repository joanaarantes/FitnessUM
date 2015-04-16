

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UserTest
{
    /**
     * Default constructor for test class UserTest
     */
    public UserTest()
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
    public void AddAmigo()
    {
        Data_Teste Data_JUnit_Test = new Data_Teste();
        User user1 = new User("Pedro", "Pedro", "ola", "Pedro", Data_JUnit_Test, 19, 183, 60, 'M');
        User user2 = new User("Ze", "ze", "ola", "Ze", Data_JUnit_Test, 19, 170, 70, 'M');
        user1.addRequest(user2.getEmail());
        user1.sendRequest(user2);
        java.util.ArrayList<java.lang.String> FriendRequest = user2.getRequests();
        assertEquals(FriendRequest, FriendRequest);
    }

    @Test
    public void addActivity()
    {
        Data_Teste JUnit_Data_Teste = new Data_Teste();
        User user1 = new User("Joana", "Joana", "Joana", "Joana", JUnit_Data_Teste, 21, 170, 60, 'F');
        Walking walking1 = new Walking(50*60, JUnit_Data_Teste, 27, "Ceu Nublado", 1000, 0, 100);
        user1.addActiv(walking1);
        java.util.ArrayList<Actividades> Activ_Test = user1.getActiv();
        assertEquals(Activ_Test, user1.getActiv());
        assertEquals(Activ_Test.size(), user1.getActiv().size());
    }
}


