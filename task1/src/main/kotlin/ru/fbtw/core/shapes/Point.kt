package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D

class Point constructor(
    private val x: Int,
    private val y: Int
) : Shape {
    override val boundingRectangle: Rectangle2D = Rectangle2D(x, y, 0, 0)

    override fun render(g: Graphics2D) {
        g.drawLine(x, y, x, y)
    }
}