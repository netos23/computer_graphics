package ru.fbtw.computer_graphics.math

private const val X = 0
private const val Y = 1
private const val Z = 2

class Point3(val matrix: Array<Float> = Array(3) { 0f }) {
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
    var z: Float
        get() = matrix[Z]
        set(v) {
            matrix[Z] = v
            extraMatrix[Z] = v
        }

    val extraMatrix = arrayOf(x, y, z, 1f)

    constructor(x: Float, y: Float, z: Float) : this(arrayOf(x, y, z))
    constructor(xyz: Triple<Float, Float, Float>) : this(xyz.first, xyz.second, xyz.third)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point3

        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }
}
