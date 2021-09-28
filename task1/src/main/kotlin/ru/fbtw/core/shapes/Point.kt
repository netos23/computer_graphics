package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Graphics2D

class Point constructor(
    private val x: Int,
    private val y: Int,
    override val strokeConfig: StrokeConfig = StrokeConfig()
) : Shape {
    override val boundingRectangle: Rectangle2D = Rectangle2D(x, y, 0, 0)

    override fun render(g: Graphics2D) {
        if (strokeConfig.useStroke) {
            g.color = strokeConfig.stroke
            g.drawLine(x, y, x + 1, y)
        }
    }
}