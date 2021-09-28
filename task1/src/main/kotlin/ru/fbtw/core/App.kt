package ru.fbtw.core

import ru.fbtw.core.shapes.*
import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Point2D
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Color
import java.awt.EventQueue
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel


private val canvasWidth = 800
private val canvasHeight = 800

internal class DrawPanel : JPanel() {
    private val shapes = listOf<Shape>(
        Rectangle(
            0, 0, canvasWidth, canvasHeight,
            StrokeConfig(useStroke = false),
            FillConfig(useFill = true, fill = Color.PINK)
        ),
        Triangle(
            point1 = Point2D(
                x = canvasWidth,
                y = canvasHeight,
            ),
            point2 = Point2D(
                x = canvasWidth,
                y = 500,
            ),
            point3 = Point2D(
                x = 200,
                y = canvasHeight,
            ),
            fillConfig = FillConfig(
                useFill = true,
                fill = Color(Integer.parseInt("835ED6", 16))
            ),
            strokeConfig = StrokeConfig(
                useStroke = false
            )
        ),
        Triangle(
            point1 = Point2D(
                x = 0,
                y = canvasHeight,
            ),
            point2 = Point2D(
                x = 0,
                y = 500,
            ),
            point3 = Point2D(
                x = 400,
                y = canvasHeight,
            ),
            fillConfig = FillConfig(
                useFill = true,
                fill = Color(Integer.parseInt("5E7AD6", 16))
            ),
            strokeConfig = StrokeConfig(
                useStroke = false
            )
        ),
        Parachute(
            boundingRectangle = Rectangle2D(10, 10, 100, 100),
            mainColor = Color(Integer.parseInt("912681", 16)),
            bgColor = Color.PINK
        ),
        Parachute(
            archCount = 10,
            boundingRectangle = Rectangle2D(320, 60, 200, 200),
            mainColor = Color(Integer.parseInt("DEC245", 16)),
            bgColor = Color.PINK
        ),
        Parachute(
            archCount = 7,
            boundingRectangle = Rectangle2D(100, 100, 300, 300),
            mainColor = Color(Integer.parseInt("BFDE5B", 16)),
            bgColor = Color.PINK
        ),
        House(
            roofFactor = 0.5,
            topFactor = 0.3,
            offset = 0.1,
            boundingRectangle = Rectangle2D(20, 400, 100, 200),
            strokeConfig = StrokeConfig(
                useStroke = false,
            ),

            ),
        House(
            roofFactor = 0.5,
            topFactor = 0.8,
            offset = 0.1,
            boundingRectangle = Rectangle2D(50, 500, 300, 300),
            strokeConfig = StrokeConfig(
                useStroke = false,
            ),
        ),
        House(
            roofFactor = 0.5,
            topFactor = 0.6,
            offset = 0.2,
            boundingRectangle = Rectangle2D(-100, 600, 200, 200),
            strokeConfig = StrokeConfig(
                useStroke = false,
            ),
        ),
        Dino(
            boundingRectangle = Rectangle2D(300, 250, 400, 500),
            strokeConfig = StrokeConfig(useStroke = false),
            accentColor = Color(Integer.parseInt("49B35B", 16)),
            mainColor = Color(Integer.parseInt("82FF96", 16)),
        ),
        Dino(
            boundingRectangle = Rectangle2D(620, 500, 200, 200),
            strokeConfig = StrokeConfig(useStroke = false),
            accentColor = Color(Integer.parseInt("FFB769", 16)),
            mainColor = Color(Integer.parseInt("B38552", 16)),
        ),
        Oval(
            600, 50, 300, 300,
            strokeConfig = StrokeConfig(useStroke = false),
            fillConfig = FillConfig(useFill = true, fill = Color(Integer.parseInt("FFFD70", 16)))
        ),
        Point(700,100,),
    )

    private fun render(g: Graphics) {
        shapes.forEach { it.render(g as Graphics2D) }
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        render(g)
    }
}

class Painter : JFrame() {
    private fun initUI() {
        val drawPanel = DrawPanel()
        add(drawPanel)
        setSize(canvasWidth, canvasHeight)
        title = "Painter"
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                val ex = Painter()
                ex.isVisible = true
            }
        }
    }

    init {
        initUI()
    }
}