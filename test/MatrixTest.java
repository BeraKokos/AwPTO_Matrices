import org.junit.Before;
import org.junit.Test;
import pl.kkbo.matrices.matrix.Matrix;
import pl.kkbo.matrices.matrix.MatrixUtils;

import static org.junit.Assert.assertEquals;

/**
 * dupa dupa
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
    public void matricesMultiplyTest() {
        //chuj
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
}
