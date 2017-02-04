import org.junit.Before;
import org.junit.Test;
import pl.kkbo.matrices.matrix.Matrix;
import pl.kkbo.matrices.matrix.MatrixUtils;
import pl.kkbo.matrices.matrix.exceptions.MatrixOperationException;

import static org.junit.Assert.*;

/**
 * Created by kkarolcz on 28.01.2017.
 */
public class MatrixTest {

    private Matrix matrix;

    private Matrix otherMatrix;

    @Before
    public void initMatrices() {
        matrix = new Matrix(3, 3);
        matrix.setValue(0, 0, 3);
        matrix.setValue(0, 1, 2);

        otherMatrix = new Matrix(matrix);
    }

    @Test
    public void matrixInitTest() {
        assertEquals(matrix, otherMatrix);
    }

    @Test
    public void matricesAddTest() {
        Matrix expectedResult = new Matrix(3, 3);
        expectedResult.setValue(0, 0, 6);
        expectedResult.setValue(0, 1, 4);

        Matrix result = MatrixUtils.add(matrix, otherMatrix);
        assertEquals(expectedResult, result);
    }

    @Test
    public void matricesSubtractTest() {
        Matrix expectedResult = new Matrix(3, 3);
        expectedResult.setValue(0, 0, 0);
        expectedResult.setValue(0, 1, 0);

        Matrix result = MatrixUtils.subtract(matrix, otherMatrix);
        assertEquals(expectedResult, result);
}

    @Test(expected=MatrixOperationException.class)
    public void matricesAddExceptionTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, 1);
        a.setValue(1, 0, 2);
        a.setValue(2, 0, 3);
        a.setValue(0, 1, 1);
        a.setValue(1, 1, 2);
        a.setValue(2, 1, 3);

        Matrix b = new Matrix(2, 3);
        b.setValue(0, 0, 1);
        b.setValue(1, 0, 2);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(0, 2, 1);
        b.setValue(1, 2, 2);

        Matrix result = MatrixUtils.add(a, b);
    }

    public void matricesAddDoubleTest() {
        Matrix a = new Matrix(2, 2);
        a.setValue(0, 0, 1.3);
        a.setValue(1, 0, 2.2);
        a.setValue(0, 1, 1.1);
        a.setValue(1, 1, 2.0);

        Matrix b = new Matrix(2, 2);
        b.setValue(0, 0, 1.0);
        b.setValue(1, 0, 2.1);
        b.setValue(0, 1, 1.2);
        b.setValue(1, 1, 2.1);

        Matrix expectedResult = new Matrix(2, 2);
        expectedResult.setValue(0, 0, 2.3);
        expectedResult.setValue(1, 0, 4.3);
        expectedResult.setValue(0, 1, 2.3);
        expectedResult.setValue(1, 1, 2.1);

        boolean sameResult = expectedResult.equals(MatrixUtils.add(a, b));
        assertTrue(sameResult);
    }

    public void matricesSubtractDoubleTest() {
        Matrix a = new Matrix(2, 2);
        a.setValue(0, 0, 1.3);
        a.setValue(1, 0, 2.2);
        a.setValue(0, 1, 1.1);
        a.setValue(1, 1, 2.0);

        Matrix b = new Matrix(2, 2);
        b.setValue(0, 0, 1.0);
        b.setValue(1, 0, 2.1);
        b.setValue(0, 1, 1.2);
        b.setValue(1, 1, 2.1);

        Matrix expectedResult = new Matrix(2, 2);
        expectedResult.setValue(0, 0, 0.3);
        expectedResult.setValue(1, 0, 0.1);
        expectedResult.setValue(0, 1, -0.1);
        expectedResult.setValue(1, 1, -0.1);

        boolean sameResult = expectedResult.equals(MatrixUtils.subtract(a, b));
        assertTrue(sameResult);
    }

    @Test
    public void matricesAddNegativeNumbersTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, -1);
        a.setValue(1, 0, -2);
        a.setValue(2, 0, -3);
        a.setValue(0, 1, -1);
        a.setValue(1, 1, -2);
        a.setValue(2, 1, -3);

        Matrix b = new Matrix(3, 2);
        b.setValue(0, 0, -1);
        b.setValue(1, 0, -2);
        b.setValue(2, 0, -3);
        b.setValue(0, 1, -1);
        b.setValue(1, 1, -2);
        b.setValue(2, 1, -3);


        Matrix expectedResult = new Matrix(3, 2);
        expectedResult.setValue(0, 0, -2);
        expectedResult.setValue(1, 0, -4);
        expectedResult.setValue(2, 0, -6);
        expectedResult.setValue(0, 1, -2);
        expectedResult.setValue(1, 1, -4);
        expectedResult.setValue(2, 1, -6);

        Matrix result = MatrixUtils.add(a, b);
        assertEquals(expectedResult, result);
    }
    @Test
    public void matricesSubtractNegativeNumbersTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, -1);
        a.setValue(1, 0, -2);
        a.setValue(2, 0, -3);
        a.setValue(0, 1, -1);
        a.setValue(1, 1, -2);
        a.setValue(2, 1, -3);

        Matrix b = new Matrix(3, 2);
        b.setValue(0, 0, -1);
        b.setValue(1, 0, -2);
        b.setValue(2, 0, -3);
        b.setValue(0, 1, -1);
        b.setValue(1, 1, -2);
        b.setValue(2, 1, -3);


        Matrix expectedResult = new Matrix(3, 2);
        expectedResult.setValue(0, 0, 0);
        expectedResult.setValue(1, 0, 0);
        expectedResult.setValue(2, 0, 0);
        expectedResult.setValue(0, 1, 0);
        expectedResult.setValue(1, 1, 0);
        expectedResult.setValue(2, 1, 0);

        Matrix result = MatrixUtils.subtract(a, b);
        assertEquals(expectedResult, result);
    }

    @Test(expected=MatrixOperationException.class)
    public void matricesSubtractExceptionTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, 1);
        a.setValue(1, 0, 2);
        a.setValue(2, 0, 3);
        a.setValue(0, 1, 1);
        a.setValue(1, 1, 2);
        a.setValue(2, 1, 3);

        Matrix b = new Matrix(2, 3);
        b.setValue(0, 0, 1);
        b.setValue(1, 0, 2);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(0, 2, 1);
        b.setValue(1, 2, 2);

        Matrix result = MatrixUtils.subtract(a, b);
    }

    @Test
    public void matricesMultiplyTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, 1);
        a.setValue(1, 0, 2);
        a.setValue(2, 0, 3);
        a.setValue(0, 1, 1);
        a.setValue(1, 1, 2);
        a.setValue(2, 1, 3);

        Matrix b = new Matrix(2, 3);
        b.setValue(0, 0, 1);
        b.setValue(1, 0, 2);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(0, 2, 1);
        b.setValue(1, 2, 2);

        Matrix expectedResult = new Matrix(2, 2);
        expectedResult.setValue(0, 0, 6);
        expectedResult.setValue(1, 0, 12);
        expectedResult.setValue(0, 1, 6);
        expectedResult.setValue(1, 1, 12);

        assertEquals(expectedResult, MatrixUtils.multiply(a, b));
    }

    @Test
    public void matricesTestMultiplyNotNull() {
        Matrix a = new Matrix(4, 4);
        a.setValue(0, 0, 2);
        a.setValue(1, 0, 0);
        a.setValue(2, 0, 0);
        a.setValue(3, 0, 0);
        a.setValue(0, 1, 0);
        a.setValue(1, 1, 3);
        a.setValue(2, 1, 0);
        a.setValue(3, 1, 0);
        a.setValue(0, 2, 0);
        a.setValue(1, 2, 0);
        a.setValue(2, 2, -1);
        a.setValue(3, 2, 0);
        a.setValue(0, 3, 0);
        a.setValue(1, 3, 0);
        a.setValue(2, 3, 0);
        a.setValue(3, 3, 5);

        Matrix b = new Matrix(4, 4);
        b.setValue(0, 0, -5);
        b.setValue(1, 0, 0);
        b.setValue(2, 0, 0);
        b.setValue(3, 0, 0);
        b.setValue(0, 1, 0);
        b.setValue(1, 1, 1);
        b.setValue(2, 1, 0);
        b.setValue(3, 1, 0);
        b.setValue(0, 2, 0);
        b.setValue(1, 2, 0);
        b.setValue(2, 2, 7);
        b.setValue(3, 2, 0);
        b.setValue(0, 3, 0);
        b.setValue(1, 3, 0);
        b.setValue(2, 3, 0);
        b.setValue(3, 3, -4);

        assertNotNull(MatrixUtils.multiply(a, b));
    }

    @Test
    public void matricesTestAddNotNull() {
        Matrix a = new Matrix(4, 4);
        a.setValue(0, 0, 2);
        a.setValue(1, 0, 0);
        a.setValue(2, 0, 0);
        a.setValue(3, 0, 0);
        a.setValue(0, 1, 0);
        a.setValue(1, 1, 3);
        a.setValue(2, 1, 0);
        a.setValue(3, 1, 0);
        a.setValue(0, 2, 0);
        a.setValue(1, 2, 0);
        a.setValue(2, 2, -1);
        a.setValue(3, 2, 0);
        a.setValue(0, 3, 0);
        a.setValue(1, 3, 0);
        a.setValue(2, 3, 0);
        a.setValue(3, 3, 5);

        Matrix b = new Matrix(4, 4);
        b.setValue(0, 0, -5);
        b.setValue(1, 0, 0);
        b.setValue(2, 0, 0);
        b.setValue(3, 0, 0);
        b.setValue(0, 1, 0);
        b.setValue(1, 1, 1);
        b.setValue(2, 1, 0);
        b.setValue(3, 1, 0);
        b.setValue(0, 2, 0);
        b.setValue(1, 2, 0);
        b.setValue(2, 2, 7);
        b.setValue(3, 2, 0);
        b.setValue(0, 3, 0);
        b.setValue(1, 3, 0);
        b.setValue(2, 3, 0);
        b.setValue(3, 3, -4);

        assertNotNull(MatrixUtils.add(a, b));
    }

    @Test
    public void matricesTestSubtractNotNull() {
        Matrix a = new Matrix(4, 4);
        a.setValue(0, 0, 2);
        a.setValue(1, 0, 0);
        a.setValue(2, 0, 0);
        a.setValue(3, 0, 0);
        a.setValue(0, 1, 0);
        a.setValue(1, 1, 3);
        a.setValue(2, 1, 0);
        a.setValue(3, 1, 0);
        a.setValue(0, 2, 0);
        a.setValue(1, 2, 0);
        a.setValue(2, 2, -1);
        a.setValue(3, 2, 0);
        a.setValue(0, 3, 0);
        a.setValue(1, 3, 0);
        a.setValue(2, 3, 0);
        a.setValue(3, 3, 5);

        Matrix b = new Matrix(4, 4);
        b.setValue(0, 0, -5);
        b.setValue(1, 0, 0);
        b.setValue(2, 0, 0);
        b.setValue(3, 0, 0);
        b.setValue(0, 1, 0);
        b.setValue(1, 1, 1);
        b.setValue(2, 1, 0);
        b.setValue(3, 1, 0);
        b.setValue(0, 2, 0);
        b.setValue(1, 2, 0);
        b.setValue(2, 2, 7);
        b.setValue(3, 2, 0);
        b.setValue(0, 3, 0);
        b.setValue(1, 3, 0);
        b.setValue(2, 3, 0);
        b.setValue(3, 3, -4);

        assertNotNull(MatrixUtils.subtract(a, b));
    }

    @Test
    public void matricesMultiplyNegativeNumbersTest() {
        Matrix a = new Matrix(3, 2);
        a.setValue(0, 0, -1);
        a.setValue(1, 0, -2);
        a.setValue(2, 0, -3);
        a.setValue(0, 1, -1);
        a.setValue(1, 1, -2);
        a.setValue(2, 1, -3);

        Matrix b = new Matrix(2, 3);
        b.setValue(0, 0, 1);
        b.setValue(1, 0, 2);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(0, 2, 1);
        b.setValue(1, 2, 2);

        Matrix expectedResult = new Matrix(2, 2);
        expectedResult.setValue(0, 0, -6);
        expectedResult.setValue(1, 0, -12);
        expectedResult.setValue(0, 1, -6);
        expectedResult.setValue(1, 1, -12);

        Matrix result = MatrixUtils.multiply(a, b);

        assertEquals(expectedResult, result);
    }

    @Test(expected=MatrixOperationException.class)
    public void matricesMultiplyExceptionTest() {
        Matrix a = new Matrix(1, 2);
        a.setValue(0, 0, 1);
        a.setValue(0, 1, 1);

        Matrix b = new Matrix(2, 3);
        b.setValue(0, 0, 1);
        b.setValue(1, 0, 2);
        b.setValue(0, 1, 1);
        b.setValue(1, 1, 2);
        b.setValue(0, 2, 1);
        b.setValue(1, 2, 2);

        MatrixUtils.multiply(a, b);
    }

    public void matricesMultiplyDiagonalTest() {
        Matrix a = new Matrix(4, 4);
        a.setValue(0, 0, 2);
        a.setValue(1, 0, 0);
        a.setValue(2, 0, 0);
        a.setValue(3, 0, 0);
        a.setValue(0, 1, 0);
        a.setValue(1, 1, 3);
        a.setValue(2, 1, 0);
        a.setValue(3, 1, 0);
        a.setValue(0, 2, 0);
        a.setValue(1, 2, 0);
        a.setValue(2, 2, -1);
        a.setValue(3, 2, 0);
        a.setValue(0, 3, 0);
        a.setValue(1, 3, 0);
        a.setValue(2, 3, 0);
        a.setValue(3, 3, 5);

        Matrix b = new Matrix(4, 4);
        b.setValue(0, 0, -5);
        b.setValue(1, 0, 0);
        b.setValue(2, 0, 0);
        b.setValue(3, 0, 0);
        b.setValue(0, 1, 0);
        b.setValue(1, 1, 1);
        b.setValue(2, 1, 0);
        b.setValue(3, 1, 0);
        b.setValue(0, 2, 0);
        b.setValue(1, 2, 0);
        b.setValue(2, 2, 7);
        b.setValue(3, 2, 0);
        b.setValue(0, 3, 0);
        b.setValue(1, 3, 0);
        b.setValue(2, 3, 0);
        b.setValue(3, 3, -4);

        Matrix result = MatrixUtils.multiply(a, b);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                boolean isZero = result.getValue(x,y) == 0;
                if (x == y) {
                    assertFalse(isZero);
                } else {
                    assertTrue(isZero);
                }
            }
        }
    }
}
