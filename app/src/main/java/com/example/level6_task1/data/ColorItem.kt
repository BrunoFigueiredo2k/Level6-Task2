package com.example.level6_task1.ui.data

data class ColorItem(
    var hex: String,
    var name: String
) {
    fun getImageUrl() = "http://singlecolorimage.com/get/$hex/1080x1080"
}

