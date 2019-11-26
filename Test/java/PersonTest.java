import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class PersonTest {
    Person tp;

    @Before
    public void setUp() throws Exception {
         tp = new Person ("John Doe", LocalDate.of(1976, Month.JANUARY, 10), Person.Sex.MALE, "johnDoe@hotmail.com");
    }

    @Test
    void setName() {
        String expectedName = "Pete Smith";
        tp.setName("Pete Smith");
        String actual = tp.getName();
        Assert.assertEquals(expectedName, actual);
    }

    @Test
    void setBirthday() {
    }

    @Test
    void setGender() {
    }

    @Test
    void setEmailAddress() {
    }
}
