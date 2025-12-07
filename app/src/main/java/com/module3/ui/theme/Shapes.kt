package com.module3.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(

    small =
        RoundedCornerShape(50.dp),
    medium =
        RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 50.dp,
            bottomStart = 50.dp,
            bottomEnd = 20.dp
        ),
    large =
        RoundedCornerShape(20.dp)

)
