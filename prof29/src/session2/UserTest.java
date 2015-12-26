package session2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User module1;
    private User module2;
    private User module3;

    @Before
    public void setUp() {
        module1 = new User("1", "one", 1, true);
        module2 = new User("2", "two", 2, true);
        module3 = new User("1", "one", 1, true);


    }

    @Test
    public void testHashCode() {
        boolean isEqualsFuncTrue = module1.equals(module3);
        boolean isHashCodeEqual = (module1.hashCode() == module3.hashCode());
        Assert.assertEquals(isEqualsFuncTrue, isHashCodeEqual);

        int hash1 = module1.hashCode();
        int hash2 = module1.hashCode();
        Assert.assertEquals(hash1, hash2);

        int hash3 = module1.hashCode();
        int hash4 = module2.hashCode();
        Assert.assertNotSame(hash1, hash2);
    }

    @Test
    public void testEquals() {
        Assert.assertFalse(module1.equals(module2));
    }

    @Test
    public void test2Equals() {
        boolean expectedResult = false;
        boolean actualResult = module1.equals(null);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test3Equals() {
        boolean actualResult = true;
        boolean expectedResult = module1.equals(module1);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test4Equals() {
        Assert.assertTrue(module1.equals(module3));
    }
}
