

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RedeUserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RedeUserTest
{
    /**
     * Default constructor for test class RedeUserTest
     */
    public RedeUserTest()
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
    public void AddUsertoNet()
    {
        RedeUser Rede = new RedeUser();
        Data_Teste data_Tes1 = new Data_Teste();
        User user4=null;
        User user1 = new User("Joana", "Joana", "Joana", "Joana", data_Tes1, 21, 170, 60, 'F');
        User user2 = new User("Pedro", "Pedro", "Pedro", "Pedro", data_Tes1, 19, 183, 60, 'M');
        User user3 = new User("Ze", "Ze", "Ze", "Ze", data_Tes1, 19, 170, 70, 'M');
        try{
        Rede.addUser(user1);
        Rede.addUser(user2);
        Rede.addUser(user3);
        }
        catch(ExistingUserException e) {}
        Rede.updateUser("Pedro", "Pedro", "philipsgogear", "Danca de Salao", data_Tes1, 19, 183, 60, 'M');
        try{
            user4 = Rede.getUser("Pedro");}
        catch(UnexistingUserException e) {}
            
        assertEquals("Danca de Salao", user4.getFavSport());  
    }
}

