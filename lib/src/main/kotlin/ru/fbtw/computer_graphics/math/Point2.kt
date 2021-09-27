package ru.fbtw.computer_graphics.math

private const val X = 0
private const val Y = 1

class Point2(val matrix: Array<Float> = Array(2) { 0f }) {

    var x: Float
        get() = matrix[X]
        set(v) {
            matrix[X] = v
            extraMatrix[X] = v
        }
    var y: Float
        get() = matrix[Y]
        set(v) {
            matrix[Y] = v
            extraMatrix[Y] = v
        }
    val extraMatrix = arrayOf(x, y, 1f)

    constructor(x: Float, y: Float) : this(arrayOf(x, y))
    constructor(xy: Pair<Float, Float>) : this(xy.first, xy.second)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point2

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }
}
