package pl.kkbo.matrices.matrix

import pl.kkbo.matrices.matrix.exceptions.MatrixOperationException

/**
  * Created by kkarolcz on 28.01.2017.
  */
class Matrix private(private var matrixArray: Array[Array[Double]], val width: Int, val height: Int) {

  def this(width: Int, height: Int) {
    this(Array.fill(width, height)(.0), width, height)
  }

  def getValue(x: Int, y: Int) = matrixArray(x)(y)

  def setValue(x: Int, y: Int, value: Double) {
    matrixArray(x)(y) = value
  }

  @throws(classOf[MatrixOperationException])
  def add(matrix: Matrix): Matrix = {
    if (height != matrix.height || width != matrix.width)
      throw new MatrixOperationException("Adding matrices of different sizes is not possible")

    val result = new Matrix(this)
    for (i <- 0 until width)
      for (j <- 0 until width)
        result.matrixArray(i)(j) += matrix.matrixArray(i)(j)

    result
  }

  def this(matrix: Matrix) {
    this(matrix.matrixArray.map(_.clone), matrix.width, matrix.height)
  }

  override def equals(other: Any): Boolean = other match {
    case that: Matrix => {
      if ((that canEqual this) && width == that.width && height == that.height) {
        for (i <- 0 until width)
          for (j <- 0 until height)
            if (matrixArray(i)(j) != that.matrixArray(i)(j)) return false
        return true
      }
      false
    }
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Matrix]

  override def hashCode(): Int = {
    val state = Seq(matrixArray)
    state.flatten.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

}