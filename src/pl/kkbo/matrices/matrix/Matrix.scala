package pl.kkbo.matrices.matrix

/**
  * Class representing matrix. Based on a two dimensional array.
  * Created by kkarolcz on 28.01.2017.
  */
class Matrix private(private var matrixArray: Array[Array[Double]], val columns: Int, val rows: Int) {

  /**
    * Creates empty matrix of width x height size
    *
    * @param width  width of the matrix
    * @param height height of the matrix
    */
  def this(width: Int, height: Int) {
    this(Array.fill(width, height)(.0), width, height)
  }

  /**
    * Copy constructor
    *
    * @param matrix matrix to be copied to the new matrix
    */
  def this(matrix: Matrix) {
    this(matrix.matrixArray.map(_.clone), matrix.columns, matrix.rows)
  }

  /**
    * gets one cell of the matrix
    *
    * @param x column
    * @param y row
    * @return value of the matrix cell
    */
  def getValue(x: Int, y: Int) = matrixArray(x)(y)

  /**
    * set value of one cell of the matrix
    *
    * @param x column
    * @param y row
    */
  def setValue(x: Int, y: Int, value: Double) {
    matrixArray(x)(y) = value
  }

  /**
    * Matrices are equal if they contain exactly the same values and they are of the same size
    *
    * @param other matrix to compare
    * @return true if matrices are equal
    */
  override def equals(other: Any): Boolean = other match {
    case that: Matrix =>
      if ((that canEqual this) && columns == that.columns && rows == that.rows) {
        for (i <- 0 until columns)
          for (j <- 0 until rows)
            if (matrixArray(i)(j) != that.matrixArray(i)(j)) return false
        return true
      }
      false
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Matrix]

  /**
    * @return Hash code based on every value of the matrix
    */
  override def hashCode(): Int = {
    val state = Seq(matrixArray)
    state.flatten.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = {
    val builder = new StringBuilder
    matrixArray.foreach(row => builder.append(row.mkString(", ")).append("\n"))
    builder.toString
  }
}