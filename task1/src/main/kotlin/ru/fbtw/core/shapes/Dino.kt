package ru.fbtw.core.shapes

import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Point2D
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Color
import java.awt.Graphics2D

class Dino(
    val mainColor: Color = Color.green,
    val accentColor: Color = Color.gray,
    val secondColor: Color = Color.RED,
    override val boundingRectangle: Rectangle2D,
    override val strokeConfig: StrokeConfig = StrokeConfig()
) : Shape {
    val body = Triangle(
        point1 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.2).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.4).toInt(),
        ),
        point2 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.6).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.2).toInt(),
        ),
        point3 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.8).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.9).toInt(),
        ),
        fillConfig = FillConfig(
            useFill = true,
            fill = mainColor
        ),
        strokeConfig = strokeConfig
    )

    val head = Triangle(
        point1 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.65).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.1).toInt(),
        ),
        point2 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.3).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.21).toInt(),
        ),
        point3 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.6).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.2).toInt(),
        ),
        fillConfig = FillConfig(
            useFill = true,
            fill = mainColor
        ),
        strokeConfig = strokeConfig
    )

    val leftFoot = Triangle(
        point1 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.55).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.6).toInt(),
        ),
        point2 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.45).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height).toInt(),
        ),
        point3 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.7).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height).toInt(),
        ),
        fillConfig = FillConfig(
            useFill = true,
            fill = accentColor
        ),
        strokeConfig = strokeConfig
    )

    val rightFoot = Triangle(
        point1 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.5).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.5).toInt(),
        ),
        point2 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.4).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.9).toInt(),
        ),
        point3 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.6).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.9).toInt(),
        ),
        fillConfig = FillConfig(
            useFill = true,
            fill = accentColor
        ),
        strokeConfig = strokeConfig
    )

    val hand = Triangle(
        point1 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.55).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.5).toInt(),
        ),
        point2 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.3).toInt(),
        ),
        point3 = Point2D(
            x = (boundingRectangle.x + boundingRectangle.width * 0.1).toInt(),
            y = (boundingRectangle.y + boundingRectangle.height * 0.45).toInt(),
        ),
        fillConfig = FillConfig(
            useFill = true,
            fill = accentColor
        ),
        strokeConfig = strokeConfig
    )

    override fun render(g: Graphics2D) {
        rightFoot.render(g)
        body.render(g)
        head.render(g)
        leftFoot.render(g)
        hand.render(g)
    }
}