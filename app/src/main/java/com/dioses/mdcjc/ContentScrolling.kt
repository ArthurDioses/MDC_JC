package com.dioses.mdcjc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dioses.mdcjc.ui.theme.MDCJCTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    MDCJCTheme {
        Content()
    }
}

@Composable
fun Content() {
    Text(
        text = "Hola !", modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    )
}