package fundamental_date;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CirclesOfFifthsTest {
    private CirclesOfFifths circlesOfFifths;
    private CirclesOfFifths expectedCirclesOfFifth;

    @Before
    public void createCirclesOfFifts(){
        circlesOfFifths = new CirclesOfFifths();
    }

    @Test
    public void choseModeOfCircle_majorExist(){
        expectedCirclesOfFifth = new CirclesOfFifths(Arrays.asList(CirclesOfFifths.majorKeys));
        circlesOfFifths.setModeOfCircle(circlesOfFifths.choseModeOfCircle("C"));
        assertEquals(expectedCirclesOfFifth.getModeOfCircle(), circlesOfFifths.getModeOfCircle());
    }
    @Test
    public void choseModeOfCircle_minorExist(){
        expectedCirclesOfFifth = new CirclesOfFifths(Arrays.asList(CirclesOfFifths.minorKeys));
        circlesOfFifths.setModeOfCircle(circlesOfFifths.choseModeOfCircle("a"));
        assertEquals(expectedCirclesOfFifth.getModeOfCircle(), circlesOfFifths.getModeOfCircle());
    }

    @Test(expected = NullPointerException.class)
    public void choseModeOfCircle_unexistKey(){
        circlesOfFifths.choseModeOfCircle("Cisis");
    }

    @Test
    public void findTonic_existIndex() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("As", circlesOfFifths.findTonic(4));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void findTonic_unexistIndex() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        circlesOfFifths.findTonic(17);
    }

    @Test
    public void findIndexOfKey_existMajorKey(){
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals(8, circlesOfFifths.findIndexOfKey("C"));
    }
    @Test
    public void findIndexOfKey_unexistKey(){
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals(-1, circlesOfFifths.findIndexOfKey("Fisis"));
    }
    @Test
    public void findSubdominant_inMajorKey() {
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("F", circlesOfFifths.findSubdominant("C"));
    }
    @Test
    public void findDominant_inMajorKey(){
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMajor());
        assertEquals("G", circlesOfFifths.findDominant("C"));
    }
    @Test
    public void findDominant_inMinorKey(){
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMinor());
        assertEquals("G", circlesOfFifths.findDominant("c"));
    }
    @Test
    public void changeModeOfKey(){
        circlesOfFifths.setModeOfCircle(circlesOfFifths.getMinor());
        assertEquals("C", circlesOfFifths.changeModeOfKey("c"));
    }
}