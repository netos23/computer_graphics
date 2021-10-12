package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Graphics2D

interface Shape {
    val boundingRectangle: Rectangle2D
    val strokeConfig: StrokeConfig
    fun render(g: Graphics2D)
}