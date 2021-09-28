package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Color
import java.awt.Graphics2D

class Parachute(
    val archCount: Int = 3,
    archHeightCof: Double = 0.5,
    private val mainColor: Color = Color.GREEN,
    val bgColor: Color = Color.GREEN,
    override val boundingRectangle: Rectangle2D,
    override val strokeConfig: StrokeConfig = StrokeConfig()
) : Shape {

    private val subArchWidth = boundingRectangle.width / archCount;

    override fun render(g: Graphics2D) {
        g.color = mainColor
        g.fillArc(
            boundingRectangle.x,
            boundingRectangle.y,
            boundingRectangle.width,
            boundingRectangle.width,
            0, 180
        )

        g.color = bgColor
        for (i in 0 until archCount) {
            g.fillArc(
                boundingRectangle.x + subArchWidth * i,
                boundingRectangle.y + boundingRectangle.width / 2 - subArchWidth / 2,
                subArchWidth, subArchWidth,
                0, 180
            )
        }

        for(i in 0..archCount){
            Line(
                x1 = boundingRectangle.x + subArchWidth * i,
                y1 = boundingRectangle.y + boundingRectangle.width / 2,
                x2 = boundingRectangle.x + boundingRectangle.width / 2,
                y2 = boundingRectangle.y + boundingRectangle.height,
                strokeConfig = strokeConfig
            ).render(g);
        }
    }
}