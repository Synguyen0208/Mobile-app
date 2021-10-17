package com.example.jetnote.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.domain.model.ColorModel
import com.example.jetnote.util.fromHex
import ui.components.NoteColor


@Composable
fun ColorItem(color: ColorModel, onColorSelect: (ColorModel) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onColorSelect(color) })
    ) {
        NoteColor(
            modifier = Modifier.padding(40.dp),
            color = Color.fromHex(color.hex),
            size = 80.dp,
            border = 2.dp
        )
    }

}
@Composable

private fun ColorPicker(colors:List<ColorModel>,onColorSelect: (ColorModel) -> Unit){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Color picker",fontSize = 18.sp,fontWeight = FontWeight.Bold,modifier = Modifier.padding(8.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(colors.size){itemIndex->
                val color = colors[itemIndex]
                ColorItem(color = color, onColorSelect =onColorSelect )

            }
        }
    }
}