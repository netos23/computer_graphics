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
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JPanel


internal class DrawPanel : JPanel() {
    private var canvasWidth = 800
    private var canvasHeight = 800
    private var width: Double = 800.0
    private var height: Double = 800.0

    private fun toRelW(abs: Int): Int {
        return ((abs / width) * canvasWidth).toInt()
    }

    private fun toRelH(abs: Int): Int {
        return ((abs / height) * canvasHeight).toInt()
    }

    private fun render(g: Graphics) {
        val shapes = listOf<Shape>(
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
                    y = toRelH(500),
                ),
                point3 = Point2D(
                    x = toRelW(200),
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
                    y = toRelH(500),
                ),
                point3 = Point2D(
                    x = toRelW(400),
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
                boundingRectangle = Rectangle2D(toRelW(10), toRelH(10), toRelW(100), toRelH(100)),
                mainColor = Color(Integer.parseInt("912681", 16)),
                bgColor = Color.PINK
            ),
            Parachute(
                archCount = 10,
                boundingRectangle = Rectangle2D(toRelW(320), toRelH(60), toRelW(200), toRelH(200)),
                mainColor = Color(Integer.parseInt("DEC245", 16)),
                bgColor = Color.PINK
            ),
            Parachute(
                archCount = 7,
                boundingRectangle = Rectangle2D(toRelW(100), toRelH(100), toRelW(300), toRelH(300)),
                mainColor = Color(Integer.parseInt("BFDE5B", 16)),
                bgColor = Color.PINK
            ),
            House(
                roofFactor = 0.5,
                topFactor = 0.3,
                offset = 0.1,
                boundingRectangle = Rectangle2D(toRelW(20), toRelH(400), toRelW(100), toRelH(200)),
                strokeConfig = StrokeConfig(
                    useStroke = false,
                ),
            ),
            House(
                roofFactor = 0.5,
                topFactor = 0.8,
                offset = 0.1,
                boundingRectangle = Rectangle2D(toRelW(50), toRelH(500), toRelW(300), toRelH(300)),
                strokeConfig = StrokeConfig(
                    useStroke = false,
                ),
            ),
            House(
                roofFactor = 0.5,
                topFactor = 0.6,
                offset = 0.2,
                boundingRectangle = Rectangle2D(toRelW(-100), toRelH(600), toRelW(200), toRelH(200)),
                strokeConfig = StrokeConfig(
                    useStroke = false,
                ),
            ),
            Dino(
                boundingRectangle = Rectangle2D(toRelW(300), toRelH(250), toRelW(400), toRelH(500)),
                strokeConfig = StrokeConfig(useStroke = false),
                accentColor = Color(Integer.parseInt("49B35B", 16)),
                mainColor = Color(Integer.parseInt("82FF96", 16)),
            ),
            Dino(
                boundingRectangle = Rectangle2D(toRelW(620), toRelH(500), toRelW(200), toRelH(200)),
                strokeConfig = StrokeConfig(useStroke = false),
                accentColor = Color(Integer.parseInt("FFB769", 16)),
                mainColor = Color(Integer.parseInt("B38552", 16)),
            ),
            Oval(
                toRelW(600), toRelH(50), toRelW(300), toRelH(300),
                strokeConfig = StrokeConfig(useStroke = false),
                fillConfig = FillConfig(useFill = true, fill = Color(Integer.parseInt("FFFD70", 16)))
            ),
            Point(toRelW(700), toRelH(100)),
        )
        shapes.forEach { it.render(g as Graphics2D) }
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        render(g)
    }

    override fun setSize(width: Int, height: Int) {
        super.setSize(width, height)
        canvasHeight = height
        canvasWidth = width
        repaint()
    }
}

class Painter : JFrame() {
    private fun initUI() {
        val drawPanel = DrawPanel()
        drawPanel.addComponentListener(ResizeListener(drawPanel))
        add(drawPanel)
        setSize(800, 800)
        title = "Painter"
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                val painter = Painter()
                painter.isVisible = true
            }
        }
    }

    init {
        initUI()
    }
}

internal class ResizeListener(var drawPanel: DrawPanel) : ComponentAdapter() {
    override fun componentResized(e: ComponentEvent) {
        drawPanel.setSize(drawPanel.width, drawPanel.height)
    }
}