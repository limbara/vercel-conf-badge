package com.example.vercelconfbadge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.vecelconfbadge.extentions.nonSp
import com.example.vecelconfbadge.extentions.shimmerBrush
import com.example.vercelconfbadge.ui.theme.VercelConfBadgeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VercelConfBadgeTheme {
                Badge()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    VercelConfBadgeTheme {
        Badge()
    }
}

@Composable
fun Badge(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.aspectRatio(16f / 9f)) {
        Surface(
            modifier = modifier
                .fillMaxWidth(0.95f)
                .border(
                    width = 3.dp,
                    brush = Brush.horizontalGradient(
                        .0f to Color(0xFFD25778),
                        .3f to Color(0xFFec585c),
                        .7f to Color(0xFFe7d155),
                        .8f to Color(0xff56a8c6),
                    ),
                    shape = RoundedCornerShape(8.dp)
                ),
            shape = RoundedCornerShape(8.dp),
            color = Color.Black
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(.5f)
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        AsyncImage(
                            model = "https://avatars2.githubusercontent.com/u/12592611?s=460u=8cb6928c013a67d2e9d9f8009fdef18668286c9d&v=4",
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .clip(CircleShape),
                            placeholder = RectImagePainter(
                                brush = Brush.shimmerBrush(
                                    listOf(
                                        Color.White.copy(alpha = 1f),
                                        Color.White.copy(alpha = 0.7f),
                                        Color.White.copy(alpha = 1f),
                                    )
                                ), sized = Size(200.dp.value, 200.dp.value)
                            ),
                            error = RectImagePainter(
                                brush = SolidColor(Color.White),
                                sized = Size(200.dp.value, 200.dp.value)
                            )
                        )
                        Column(
                            modifier = Modifier
                                .weight(3f)
                                .padding(8.dp)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "Nico Limbara",
                                color = Color.White,
                                fontSize = 24.nonSp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.fa_brands_github),
                                    contentDescription = "Github",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "limbara",
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    fontSize = 12.nonSp
                                )
                            }
                        }
                    }
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://github.com/semicolon-academy/ui-challenges/raw/master/005-nextjs-ticket/event-logos.png")
                            .crossfade(true).build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp),
                        placeholder = RectImagePainter(
                            brush = Brush.shimmerBrush(
                                listOf(
                                    Color.White.copy(alpha = 1f),
                                    Color.White.copy(alpha = 0.7f),
                                    Color.White.copy(alpha = 1f),
                                )
                            )
                        ),
                        error = RectImagePainter(
                            brush = SolidColor(Color.White)
                        )
                    )
                }
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                    .fillMaxHeight()
                    .drawBehind {
                        val pad = 16.dp.toPx()
                        drawLine(
                            color = Color(0xFF999999),
                            start = Offset(-pad, -pad),
                            end = Offset(-pad, size.height + pad),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        )
                    }) {
                    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                        Text(text = "№ 014747",
                            color = Color.White,
                            fontSize = 24.nonSp,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .requiredWidth(maxHeight)
                                .rotate(90f)
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)

                                    layout(constraints.maxWidth, constraints.maxHeight) {
                                        val y = (constraints.maxHeight - placeable.height) / 2
                                        placeable.place(0, y)
                                    }
                                })
                    }
                }
            }
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val radius = size.height / 10
            val offset = Offset(-10.dp.value, size.height / 2)
            drawCircle(
                color = Color(0xff56a8c6),
                radius = radius,
                center = offset,
            )
        }
    }
}