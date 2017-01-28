import org.junit.Before;
import org.junit.Test;
import pl.kkbo.matrices.matrix.Matrix;

import static org.junit.Assert.assertEquals;

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

        Matrix result = matrix.add(otherMatrix);
        assertEquals(expectedResult, result);
    }
}
