package ru.fbtw.core.shapes

import ru.fbtw.core.util.ColorConfig
import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D

class Oval(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int,
    override val colorConfig: ColorConfig = ColorConfig()
) : Shape {
    override val boundingRectangle: Rectangle2D = Rectangle2D(x, y, width, height)

    constructor(rect: Rectangle2D) : this(rect.x, rect.y, rect.width, rect.height)

    override fun render(g: Graphics2D) {
        g.color = colorConfig.fill
        if (colorConfig.useFill) {
            g.fillOval(x, y, width, height)
        }

        g.color = colorConfig.stroke
        if (colorConfig.useStroke) {
            g.drawOval(x, y, width, height)
        }
    }
}