package com.samar.instaflick.domain.model

data class PostModel(
    val userId: String? = null,
    var isLiked: Boolean = false,
    var numOfLikes: Int = 785,
    var postedOn: String = "3 hours ago",
    var description: String = "Something in description with some large text written here",
    val profileImage: Int,
    val userName: String,
    val postData: List<Int>
)
