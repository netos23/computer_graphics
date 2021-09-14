package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Line(
    private val x1: Int,
    private val y1: Int,
    private val x2: Int,
    private val y2: Int
) : Shape {

    override val boundingRectangle: Rectangle2D = Rectangle2D(
        x = max(x1, x2),
        y = max(y1, y2),
        width = abs(x1 - x2),
        height = abs(y1 - y2)
    )

    override fun render(g: Graphics2D) {
        g.drawLine(x1, y1, x2, y2)
    }
}