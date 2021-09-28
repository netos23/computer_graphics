package ru.fbtw.core.shapes

import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Graphics2D

class Rectangle(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int,
    override val strokeConfig: StrokeConfig = StrokeConfig(),
    private val fillConfig: FillConfig = FillConfig()
) : Shape {
    override val boundingRectangle: Rectangle2D = Rectangle2D(x, y, width, height)

    constructor(rect: Rectangle2D) : this(rect.x, rect.y, rect.width, rect.height)


    override fun render(g: Graphics2D) {
        g.color = fillConfig.fill
        if (fillConfig.useFill) {
            g.fillRect(x, y, width, height)
        }

        g.color = strokeConfig.stroke
        if (strokeConfig.useStroke) {
            g.drawRect(x, y, width, height)
        }
    }
}