package session2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AuthentificationTest {
    private Authentification module;

    @Before
    public void setUp() {
        module = new Authentification();
    }

    @Test
    public void testIsAuthentification2() {
        Map<String, String> users = new HashMap<>();

        users.put("1", "1");
        module.setUsers(users);

        boolean actualResult = module.isAuthentification2("1", "1");
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }


}
