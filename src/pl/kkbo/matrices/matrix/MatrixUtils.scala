package pl.kkbo.matrices.matrix

import pl.kkbo.matrices.matrix.exceptions.MatrixOperationException

/**
  * Created by kkarolcz on 28.01.2017.
  */
object MatrixUtils {

  /**
    * Allows to add two matrices of the same size
    *
    * @param matrix      matrix to which other matrix will be added
    * @param otherMatrix matrix to add
    * @throws pl.kkbo.matrices.matrix.exceptions.MatrixOperationException if size of matrices is different
    * @return result matrix
    */
  @throws(classOf[MatrixOperationException])
  def add(matrix: Matrix, otherMatrix: Matrix): Matrix = {
    if (matrix.rows != otherMatrix.rows || matrix.columns != otherMatrix.columns)
      throw new MatrixOperationException("Adding matrices of different sizes is not possible")

    val result = new Matrix(matrix)
    for (i <- 0 until matrix.columns)
      for (j <- 0 until matrix.columns)
        result.setValue(i, j, matrix.getValue(i, j) + otherMatrix.getValue(i, j))

    result
  }

  /**
    * Allows to subtract two matrices of the same size
    *
    * @param matrix      matrix from which other matrix will be subtracted
    * @param otherMatrix matrix to subtract
    * @throws pl.kkbo.matrices.matrix.exceptions.MatrixOperationException if size of matrices is different
    * @return result matrix
    */
  @throws(classOf[MatrixOperationException])
  def subtract(matrix: Matrix, otherMatrix: Matrix): Matrix = {
    if (matrix.rows != otherMatrix.rows || matrix.columns != otherMatrix.columns)
      throw new MatrixOperationException("Subtracting matrices of different sizes is not possible")

    val result = new Matrix(matrix)
    for (i <- 0 until matrix.columns)
      for (j <- 0 until matrix.columns)
        result.setValue(i, j, matrix.getValue(i, j) - otherMatrix.getValue(i, j))

    result
  }

  /**
    * Allows to multiply N x M <code>matrix</code> and M x P <code>otherMatrix</code>
    *
    * @param matrix      N x M matrix
    * @param otherMatrix M x P matrix
    * @throws pl.kkbo.matrices.matrix.exceptions.MatrixOperationException if sizes are wrong
    * @return result N x P matrix
    */
  def multiply(matrix: Matrix, otherMatrix: Matrix): Matrix = {
    if (matrix.columns != otherMatrix.rows)
      throw new MatrixOperationException("Multiplying matrix B which has different number of rows " +
        "than matrix A has columns is not possible")

    val result = new Matrix(matrix.rows, otherMatrix.columns)
    for (i <- 0 until matrix.rows) {
      for (j <- 0 until otherMatrix.columns) {
        var sum = 0d
        for (k <- 0 until otherMatrix.rows) {
          sum += matrix.getValue(k, i) * otherMatrix.getValue(j, k)
        }
        result.setValue(j, i, sum)
      }
    }

    result
  }
}
