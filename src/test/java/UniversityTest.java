import org.junit.Test;
import static org.junit.Assert.*;

public class UniversityTest {
    @Test
    public void testUniversityCreation() {
        com.dmstplus.University university = new com.dmstplus.University(
            "Hasselt University", 
            "Belgium", 
            "Hasselt", 
            1000, 
            500.0, 
            "French", 
            "Spring"
        );

        assertEquals("Hasselt University", university.getUniName());
        assertEquals("Belgium", university.getCountry());
        assertEquals("Hasselt", university.getCity());
        assertEquals(500.0, university.getCostWithSh_Accomondation(), 0);
        assertEquals("French", university.getCountrysLang());
        assertEquals("Spring", university.getBestPeriodToVisit());
    }
}
