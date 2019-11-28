package com.example.muko.kotlinrefrofityoutubeapi.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.muko.kotlinrefrofityoutubeapi.*
import com.example.muko.kotlinrefrofityoutubeapi.Adapter.PlayListAdapter
import com.example.muko.kotlinrefrofityoutubeapi.Pojo.PlayListData
import com.example.muko.kotlinrefrofityoutubeapi.Singleton.ApiClient
import com.example.muko.kotlinrefrofityoutubeapi.Singleton.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCVHFbqXqoYvEWM1Ddxl0QDg&maxResults=50&key=[YOUR_API_KEY]

    val API_KEY = "AIzaSyBE4hQ2J1c5PQdFc7c4E10vDw0vPStseR4"
    val CHANNEL_ID = "UCVHFbqXqoYvEWM1Ddxl0QDg"
    val maxResult = 50
    var gelenveri : PlayListData? = null
    var oynatmalisteleri :List<PlayListData.Items>  ?= null //recylcervirew da göstermek istediğim listelerin adı vs
    var myAdapter: PlayListAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.allList(CHANNEL_ID,maxResult, API_KEY)
        
        apiCall?.enqueue(object : Callback<PlayListData>{
            override fun onFailure(call: Call<PlayListData>?, t: Throwable?) {
                Log.e("hata",""+t?.printStackTrace())
            }

            override fun onResponse(call: Call<PlayListData>?, response: Response<PlayListData>?) {
                Log.e("başarılı", ""+call?.request()?.url()?.toString())
                gelenveri = response?.body()
                oynatmalisteleri = gelenveri?.items!!
                myAdapter = PlayListAdapter(oynatmalisteleri)
                rvPlayList.adapter = myAdapter
                var mylayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                rvPlayList.layoutManager = mylayoutManager
               Log.e("başarılı", "Toplam liste sayısı"+oynatmalisteleri?.size)
            }

        })
    }
}
