package ru.fbtw.core.shapes

import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Point2D
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Graphics2D
import kotlin.math.abs

class Triangle(
    point1: Point2D,
    point2: Point2D,
    point3: Point2D,
    private val strokeConfig: StrokeConfig = StrokeConfig(),
    private val fillConfig: FillConfig = FillConfig()
) : Shape {
    private val xPoints = intArrayOf(point1.x, point2.x, point3.x)
    private val yPoints = intArrayOf(point1.y, point2.y, point3.y)

    override val boundingRectangle: Rectangle2D = Rectangle2D(
        x = xPoints.min()!!,
        y = yPoints.max()!!,
        width = maxOf(abs(point1.x - point2.x), abs(point2.x - point3.x), abs(point1.x - point3.x)),
        height = maxOf(abs(point1.y - point2.y), abs(point2.y - point3.y), abs(point1.y - point3.y)),
    )


    override fun render(g: Graphics2D) {

        g.color = fillConfig.fill
        if (fillConfig.useFill) {
            g.fillPolygon(xPoints, yPoints, xPoints.size)
        }

        g.color = strokeConfig.stroke
        if (strokeConfig.useStroke) {
            g.drawPolygon(xPoints, yPoints, xPoints.size)
        }
    }
}