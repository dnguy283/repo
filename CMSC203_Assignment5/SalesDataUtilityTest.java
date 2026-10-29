/*
 * Class: CMSC-203-23011
 * Instructor: Huseyin Aygun
 * Description: (The SalesAppDriver helps ask the user for input and output file names and use SalesFileIO + SalesDataUtility to display the results. SalesAppFX helps serve to display the information in GUIs. SalesDataUtility helps perform ragged array operations. SalesDataUtilityTest helps perform JUnit tests on the program to ensure that the methods work as intended. SalesFileIO helps read and write file information) 
 * Due: 11/16/2026 
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Nguyen
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class SalesDataUtilityTest {

    private double[][] sample = {
        {100.0, 200.0, 300.0},
        {50.0, 75.0},
        {400.0}
    };

    @Test
    public void testGetTotal() {
        double total = SalesDataUtility.getTotal(sample);
        assertEquals(1125.0, total, 0.001);
    }

    @Test
    public void testGetAverage() {
        double avg = SalesDataUtility.getAverage(sample);
        // 6 values total: (100+200+300+50+75+400)/6 = 187.5
        assertEquals(187.5, avg, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(600.0, SalesDataUtility.getRowTotal(sample, 0), 0.001);
        assertEquals(125.0, SalesDataUtility.getRowTotal(sample, 1), 0.001);
        assertEquals(400.0, SalesDataUtility.getRowTotal(sample, 2), 0.001);
    }

    @Test
    public void testGetColumnTotalRagged() {
        assertEquals(550.0, SalesDataUtility.getColumnTotal(sample, 0), 0.001); // 100 + 50 + 400
        assertEquals(275.0, SalesDataUtility.getColumnTotal(sample, 1), 0.001); // 200 + 75
        assertEquals(300.0, SalesDataUtility.getColumnTotal(sample, 2), 0.001); // 300 only
    }

    @Test
    public void testHighestLowestArray() {
        assertEquals(400.0, SalesDataUtility.getHighestInArray(sample), 0.001);
        assertEquals(50.0, SalesDataUtility.getLowestInArray(sample), 0.001);
    }
    
    //implement the last two JUnit test cases for getHighestInRow and getLowestInRow
    @Test
    public void testHighestInRow() {
        assertEquals(300.0, SalesDataUtility.getHighestInRow(sample, 0), 0.001);
        assertEquals(400.0, SalesDataUtility.getHighestInRow(sample, 2), 0.001);
    }
    
    @Test
    public void testLowestInRow() {
        assertEquals(100.0, SalesDataUtility.getLowestInRow(sample, 0), 0.001);
        assertEquals(400.0, SalesDataUtility.getLowestInRow(sample, 2), 0.001);
    }
}
