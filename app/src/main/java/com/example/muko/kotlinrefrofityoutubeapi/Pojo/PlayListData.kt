package com.example.muko.kotlinrefrofityoutubeapi.Pojo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PlayListData {
    @SerializedName("kind")
    var kind: String? = null
    @SerializedName("etag")
    var etag: String? = null
    @SerializedName("nextPageToken")
    var nextPageToken: String? = null
    @SerializedName("items")
    var items: List<Items>? = null

    data class Items(
        @Expose
        @SerializedName("kind")
        val mKind: String,
        @Expose
        @SerializedName("etag")
        val mEtag: String,
        @Expose
        @SerializedName("id")
        val mİd: String,
        @Expose
        @SerializedName("snippet")
        var mSnippet: Snippet
    )

    data class Snippet(
        @Expose
        @SerializedName("publishedAt")
        val mPublishedAt: String,
        @Expose
        @SerializedName("channelId")
        val mChannelId: String,
        @Expose
        @SerializedName("title")
        val mTitle: String,
        @Expose
        @SerializedName("description")
        val mDescription: String,
        @Expose
        @SerializedName("thumbnails")
        var mThumbnails: Thumbnails,
        @Expose
        @SerializedName("channelTitle")
        val mChannelTitle: String,
        @Expose
        @SerializedName("localized")
        var mLocalized: Localized
    )

    data class Localized(
        @Expose
        @SerializedName("title")
        val mTitle: String,
        @Expose
        @SerializedName("description")
        val mDescription: String
    )

    data class Thumbnails(

        @Expose
        @SerializedName("medium")
        var mMedium: Medium,
        @Expose
        @SerializedName("high")
        var mHigh: High,
        @Expose
        @SerializedName("standard")
        var mStandard: Standard,
        @Expose
        @SerializedName("maxres")
        var mMaxres: Maxres
    )

    data class Maxres(
        @Expose
        @SerializedName("url")
        val mUrl: String,
        @Expose
        @SerializedName("width")
        var mWidth: Int,
        @Expose
        @SerializedName("height")
        var mHeight: Int
    )

    data class Standard(
        @Expose
        @SerializedName("url")
        val mUrl: String,
        @Expose
        @SerializedName("width")
        var mWidth: Int,
        @Expose
        @SerializedName("height")
        var mHeight: Int
    )

    data class High(
        @Expose
        @SerializedName("url")
        val mUrl: String,
        @Expose
        @SerializedName("width")
        var mWidth: Int,
        @Expose
        @SerializedName("height")
        var mHeight: Int
    )

    data class Medium(
        @Expose
        @SerializedName("url")
        val mUrl: String,
        @Expose
        @SerializedName("width")
        var mWidth: Int,
        @Expose
        @SerializedName("height")
        var mHeight: Int
    )

    data class Default(
        @Expose
        @SerializedName("url")
        val mUrl: String,
        @Expose
        @SerializedName("width")
        var mWidth: Int,
        @Expose
        @SerializedName("height")
        var mHeight: Int
    )

}

