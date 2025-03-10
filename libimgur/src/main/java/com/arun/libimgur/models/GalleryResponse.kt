package com.arun.libimgur.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data") val `data`: List<Data>,
    @Json(name = "status") val status: Int,
    @Json(name = "success") val success: Boolean
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "account_id") val accountId: Int,
        @Json(name = "account_url") val accountUrl: String,
        @Json(name = "ad_config") val adConfig: AdConfig,
        @Json(name = "ad_type") val adType: Int,
        @Json(name = "ad_url") val adUrl: String,
        @Json(name = "animated") val animated: Boolean?,
        @Json(name = "bandwidth") val bandwidth: Long?,
        @Json(name = "comment_count") val commentCount: Int,
        @Json(name = "cover") val cover: String?,
        @Json(name = "cover_height") val coverHeight: Int?,
        @Json(name = "cover_width") val coverWidth: Int?,
        @Json(name = "datetime") val datetime: Int,
        @Json(name = "description") val description: Any?,
        @Json(name = "downs") val downs: Int,
        @Json(name = "edited") val edited: Int?,
        @Json(name = "favorite") val favorite: Boolean,
        @Json(name = "favorite_count") val favoriteCount: Int,
        @Json(name = "has_sound") val hasSound: Boolean?,
        @Json(name = "height") val height: Int?,
        @Json(name = "id") val id: String,
        @Json(name = "images") val images: List<Image>?,
        @Json(name = "images_count") val imagesCount: Int?,
        @Json(name = "in_gallery") val inGallery: Boolean,
        @Json(name = "in_most_viral") val inMostViral: Boolean,
        @Json(name = "include_album_ads") val includeAlbumAds: Boolean?,
        @Json(name = "is_ad") val isAd: Boolean,
        @Json(name = "is_album") val isAlbum: Boolean,
        @Json(name = "layout") val layout: String?,
        @Json(name = "link") val link: String,
        @Json(name = "nsfw") val nsfw: Boolean,
        @Json(name = "points") val points: Int,
        @Json(name = "privacy") val privacy: String?,
        @Json(name = "score") val score: Int,
        @Json(name = "section") val section: String,
        @Json(name = "size") val size: Int?,
        @Json(name = "tags") val tags: List<Tag>,
        @Json(name = "title") val title: String,
        @Json(name = "topic") val topic: Any?,
        @Json(name = "topic_id") val topicId: Int?,
        @Json(name = "type") val type: String?,
        @Json(name = "ups") val ups: Int,
        @Json(name = "views") val views: Int,
        @Json(name = "vote") val vote: Any?,
        @Json(name = "width") val width: Int?
    ) {
        @JsonClass(generateAdapter = true)
        data class AdConfig(
            @Json(name = "high_risk_flags") val highRiskFlags: List<Any?>,
            @Json(name = "nsfw_score") val nsfwScore: Double,
            @Json(name = "safe_flags") val safeFlags: List<String>,
            @Json(name = "show_ad_level") val showAdLevel: Int,
            @Json(name = "show_ads") val showAds: Boolean,
            @Json(name = "unsafe_flags") val unsafeFlags: List<String>,
            @Json(name = "wall_unsafe_flags") val wallUnsafeFlags: List<String>
        )
    }
}