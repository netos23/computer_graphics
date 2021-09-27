package ru.fbtw.core.util

import java.awt.Color

data class ColorConfig(
    val stroke: Color = Color.BLACK,
    val useStroke: Boolean = true,
    val fill: Color = Color.WHITE,
    val useFill: Boolean = false
)
