package pl.kkbo.matrices.matrix

import pl.kkbo.matrices.matrix.exceptions.MatrixOperationException

/**
  * Created by kkarolcz on 28.01.2017.
  */
object MatrixUtils {

  @throws(classOf[MatrixOperationException])
  def add(matrix: Matrix, otherMatrix: Matrix): Matrix = {
    if (matrix.height != otherMatrix.height || matrix.width != otherMatrix.width)
      throw new MatrixOperationException("Adding matrices of different sizes is not possible")

    val result = new Matrix(matrix)
    for (i <- 0 until matrix.width)
      for (j <- 0 until matrix.width)
        result.setValue(i, j, matrix.getValue(i, j) + otherMatrix.getValue(i, j))

    result
  }

  @throws(classOf[MatrixOperationException])
  def subtract(matrix: Matrix, otherMatrix: Matrix): Matrix = {
    if (matrix.height != otherMatrix.height || matrix.width != otherMatrix.width)
      throw new MatrixOperationException("Subtracting matrices of different sizes is not possible")

    val result = new Matrix(matrix)
    for (i <- 0 until matrix.width)
      for (j <- 0 until matrix.width)
        result.setValue(i, j, matrix.getValue(i, j) - otherMatrix.getValue(i, j))

    result
  }
}
