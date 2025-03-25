

import com.jc.CashDispenser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CashDispenserTest {

    @Test
    void testNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashDispenser.giveChange(-5);
        }, "Amount must be a positive number");
    }

    @Test
    void testZeroAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashDispenser.giveChange(0);
        }, "Amount must be a positive number");
    }

    @Test
    void testImpossibleAmounts() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(1);
        assertTrue(outContent.toString().contains("1Impossible to return with 10, 5 tickets and 2 coins"));

        outContent.reset();

        CashDispenser.giveChange(3);
        assertTrue(outContent.toString().contains("3Impossible to return with 10, 5 tickets and 2 coins"));

        // Restore original output stream
        System.setOut(originalOut);
    }

    @Test
    void testAmountTen() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(10);
        assertTrue(outContent.toString().contains("1 billets (s) de 10 €"));

        // Restore original output stream
        System.setOut(originalOut);
    }

    @Test
    void testAmountFifteen() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(50);
        String output = outContent.toString();
        assertTrue(output.contains("5 billets (s) de 10 €")
                );

        // Restore original output stream
        System.setOut(originalOut);
    }

    @Test
    void testAmountWithTwoCoinCases() {
        // Test various cases with 2€ coins
        int[] testAmounts = {2, 4, 6, 8};

        for (int amount : testAmounts) {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            CashDispenser.giveChange(amount);
            String output = outContent.toString();
            assertTrue(output.contains(amount / 2 + " piéces(s) 2€"),
                    "Failed for amount: " + amount);

            // Restore original output stream
            System.setOut(originalOut);
        }
    }

    @Test
    void testComplexAmountDistribution() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(21);
        String output = outContent.toString();
        assertTrue(output.contains("1 billets (s) de 10 €") &&
                output.contains("1 billets(s) de 5€") &&
                output.contains("3 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionTwentyTree() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(23);
        String output = outContent.toString();
        assertTrue(output.contains("1 billets (s) de 10 €") &&
                output.contains("1 billets(s) de 5€") &&
                output.contains("4 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionTwentyFive() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(25);
        String output = outContent.toString();
        assertTrue(output.contains("2 billets (s) de 10 €") &&
                output.contains("1 billets(s) de 5€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionTwentyEight() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(28);
        String output = outContent.toString();
        assertTrue(output.contains("2 billets (s) de 10 €") &&

                output.contains("4 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionThirtyOne() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(31);
        String output = outContent.toString();
        assertTrue(output.contains("2 billets (s) de 10 €") &&
                output.contains("1 billets(s) de 5€") &&
                output.contains("3 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionThirtyTree() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(33);
        String output = outContent.toString();
        assertTrue(output.contains("2 billets (s) de 10 €") &&
                output.contains("1 billets(s) de 5€") &&
                output.contains("4 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
    @Test
    void testComplexAmountDistributionThirtyEight() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(38);
        String output = outContent.toString();
        assertTrue(output.contains("3 billets (s) de 10 €") &&
                output.contains("4 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }


    @Test
    void testLargeAmount() {
        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CashDispenser.giveChange(42);
        String output = outContent.toString();
        assertTrue(output.contains("4 billets (s) de 10 €") &&
                output.contains("1 piéces(s) 2€"));

        // Restore original output stream
        System.setOut(originalOut);
    }
}