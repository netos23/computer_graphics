package ru.fbtw.core

import ru.fbtw.core.shapes.Rectangle
import ru.fbtw.core.shapes.Shape
import ru.fbtw.core.shapes.Triangle
import ru.fbtw.core.util.ColorConfig
import java.awt.*
import javax.swing.JPanel
import javax.swing.JFrame


internal class DrawPanel : JPanel() {
    private val shapes = listOf<Shape>(
        Rectangle(
            0, 0, 1000, 1000,
            ColorConfig(useStroke = false, useFill = true, fill = Color.PINK)
        ),
    )

    private fun render(g: Graphics) {
        shapes.forEach{it.render(g as Graphics2D)}
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