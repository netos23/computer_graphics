package ru.fbtw.core

import ru.fbtw.core.shapes.*
import ru.fbtw.core.util.FillConfig
import ru.fbtw.core.util.Rectangle2D
import ru.fbtw.core.util.StrokeConfig
import java.awt.Color
import java.awt.EventQueue
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel


internal class DrawPanel : JPanel() {
    private val shapes = listOf<Shape>(
        Rectangle(
            0, 0, 1000, 1000,
            StrokeConfig(useStroke = false),
            FillConfig(useFill = true, fill = Color.PINK)
        ),
        House(
            0.3,0.5,0.1,
            boundingRectangle = Rectangle2D(100,0,200,500)
        ),
        Dino(
            boundingRectangle = Rectangle2D(400,0,300, 500)
        ),
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
        setSize(1000, 1000)
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