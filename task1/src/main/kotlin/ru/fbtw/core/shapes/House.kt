package ru.fbtw.core.shapes

import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Point2D
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Color
import java.awt.Graphics2D

class House(
    roofFactor: Double,
    topFactor: Double,
    offset: Double,
    basementColor: Color = Color.RED,
    roofColor: Color = Color.gray,
    override val boundingRectangle: Rectangle2D,
    override val strokeConfig: StrokeConfig = StrokeConfig()
) : Shape {
    private val roofY = (boundingRectangle.y + boundingRectangle.height * roofFactor).toInt()
    private val topX = (boundingRectangle.x + boundingRectangle.width * topFactor).toInt()

    private val roof = Triangle(
        point1 = Point2D(boundingRectangle.x, roofY),
        point2 = Point2D(boundingRectangle.x + boundingRectangle.width, roofY),
        point3 = Point2D(topX, boundingRectangle.y),
        fillConfig = FillConfig(
            useFill = true,
            fill = roofColor
        ),
        strokeConfig = strokeConfig
    )
    private val basement = Rectangle(
        x = (boundingRectangle.x + boundingRectangle.width * offset).toInt(),
        y = roofY,
        width = (boundingRectangle.width * (1 - 2 * offset)).toInt(),
        height = boundingRectangle.height - (roofY - boundingRectangle.y),
        fillConfig = FillConfig(
            useFill = true,
            fill = basementColor
        ),
        strokeConfig = strokeConfig
    )

    override fun render(g: Graphics2D) {
        roof.render(g)
        basement.render(g)
    }
}