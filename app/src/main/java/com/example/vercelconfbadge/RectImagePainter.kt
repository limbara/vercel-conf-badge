package com.example.vercelconfbadge

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter

class RectImagePainter(
    private val brush: Brush,
    private val sized: Size = Size.Unspecified,
    private val topLeft: Offset = Offset.Zero,
) : Painter() {
    override val intrinsicSize: Size
        get() = sized

    override fun DrawScope.onDraw() {
        drawRect(
            brush,
            topLeft,
            if (sized == Size.Unspecified ) size else sized,
        )
    }
}