package com.example.cryptox

data class Coin(
    val priceString: String,
    val fullName: String,
    val shortNameUSDName: String,
    val coinImageID: Int,
    var isLiked: Boolean,
) {
    val likedImageID: Int
        get() = if(isLiked) R.drawable.heart_liked else R.drawable.heart_no_liked
}