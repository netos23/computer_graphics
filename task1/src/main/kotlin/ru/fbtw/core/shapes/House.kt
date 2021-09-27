package ru.fbtw.core.shapes

import ru.fbtw.core.util.ColorConfig
import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D

class House(
    roofFactor: Double,
    topFactor: Double,
    override val colorConfig: ColorConfig = ColorConfig(),
    override val boundingRectangle: Rectangle2D
) : Shape {
    val roofY = boundingRectangle.y + boundingRectangle.height * roofFactor
    val topX = boundingRectangle.x + boundingRectangle.width * topFactor

    override fun render(g: Graphics2D) {
        
    }
}