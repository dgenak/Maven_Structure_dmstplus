import org.junit.Test;
import static org.junit.Assert.*; 

import java.util.Arrays;
import java.util.List;

public class UserTest { 
    @Test 
    public void testUserCreation() { 
        List<String> languages = Arrays.asList("French", "German"); 
        com.dmstplus.User user = new com.dmstplus.User(languages, "Spring", "Belgium", 1200, true); 

        assertEquals(languages, user.getUserslanguages()); 
        assertEquals("Spring", user.getPreferredPeriod()); 
        assertEquals("Belgium", user.getPreferredCountry()); 
        assertEquals(1200, user.getMaxMonthlyCost(), 0); 
        assertTrue(user.getSharedAccomondation()); 
    } 
}
