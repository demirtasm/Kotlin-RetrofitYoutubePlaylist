package com.example.muko.kotlinrefrofityoutubeapi.Singleton

import com.example.muko.kotlinrefrofityoutubeapi.Pojo.PlayListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCVHFbqXqoYvEWM1Ddxl0QDg&maxResults=50&key=[YOUR_API_KEY]
    @GET("playlists?part=snippet")
    fun allList(@Query("channelId") channelID : String, @Query("maxResults")maxResult : Int, @Query("key") apikey:String):Call<PlayListData>
}