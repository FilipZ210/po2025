import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void countEvens() {
        assertEquals(3, new CodingBat().countEvens(new int[] {2, 1, 2, 3, 4}));
        assertEquals(3, new CodingBat().countEvens(new int[] {2, 2, 0}));
        assertEquals(0, new CodingBat().countEvens(new int[] {1, 3, 5}));
        assertEquals(0, new CodingBat().countEvens(new int[] {}));

    }

}