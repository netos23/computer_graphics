package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D

class Oval(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) : Shape {
    override val boundingRectangle: Rectangle2D = Rectangle2D(x, y, width, height)

    constructor(rect: Rectangle2D) : this(rect.x, rect.y, rect.width, rect.height)

    override fun render(g: Graphics2D) {
        g.drawRect(x, y, width, height)
    }
}