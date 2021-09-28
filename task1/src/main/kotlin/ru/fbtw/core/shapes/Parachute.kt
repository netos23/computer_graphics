package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Graphics2D

class Parachute(
    val archCount: Int = 3,
    override val boundingRectangle: Rectangle2D,
    override val strokeConfig: StrokeConfig
) : Shape {


    override fun render(g: Graphics2D) {

    }
}