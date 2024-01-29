package com.example.calculator.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R

@Composable
fun CalculatorButton(
    @StringRes symbol: Int,
    modifier: Modifier = Modifier,
    textColor: Color,
    backgroundColor: Color,
    onClick: ()->Unit){

        Box(

            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(100.dp))
                .background(color = backgroundColor)
                .clickable {
                    onClick()
                }
                .then(modifier)
        ){
            Text(
                text = stringResource(id = symbol),
                style= Typography.bodyMedium,
                fontSize= 36.sp,
                color = textColor
            )
        }
}