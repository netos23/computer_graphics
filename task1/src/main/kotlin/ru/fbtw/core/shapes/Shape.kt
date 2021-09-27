package ru.fbtw.core.shapes

import ru.fbtw.core.util.Rectangle2D
import java.awt.Graphics2D

interface Shape {
    val boundingRectangle: Rectangle2D
    fun render(g: Graphics2D)
}