package ua.lvivl.iot.TextEditor;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    private StringProcessor sp = new StringProcessor();

    private String testString;

    private List<String> expected;

    private List<String> actual;

    @Before
    public void setUp() throws Exception {

        expected = new LinkedList<String>();

        actual = new LinkedList<String>();

        testString = "He-llo my fri-end!"
                + " I st-udy Java in Lviv Pol-itechnic Univer-sity."
                + " Ja-va is the best program-ing lan-guage!"
                + " I am stu-dent of IoT!"
                + " Lon-don is the capi-tal of Great Bri-tain!"
                + " Tesla is the best electrocar."
                + " The bo-ok is o-n the ta-ble!";

        expected.add("Ja-va is the best program-ing lan-guage!");
        expected.add("Lon-don is the capi-tal of Great Bri-tain!");
        expected.add("The bo-ok is o-n the ta-ble!");


        sp.setUserInput(testString);

    }

    @Test
    public void testProcessText() {

        actual = sp.processText();

        Assertions.assertEquals(expected, actual);

        sp.showResults();
    }

    @Test
    public void noMatch() {

        sp.setUserInput("");

        actual = sp.processText();

        Assertions.assertNotEquals(expected, actual);

        sp.showResults();


    }
}
/*testText = "He-llo my fri-end!"
        + " I st-udy Java in Lviv Pol-itechnic Univer-sity."
        + " Ja-va is the best program-ing lan-guage!"
        + " I am stu-dent of IoT!"
        + " Lon-don is the capi-tal of Great Bri-tain!"
        + " Tesla is the best electrocar."
        + " The bo-ok is o-n the ta-ble!";

        expectedList.add("Ja-va is the best program-ing lan-guage!");
        expectedList.add("Lon-don is the capi-tal of Great Bri-tain!");
        expectedList.add("The bo-ok is o-n the ta-ble!");*/