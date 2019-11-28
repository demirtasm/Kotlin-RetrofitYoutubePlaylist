package com.example.muko.kotlinrefrofityoutubeapi.Adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muko.kotlinrefrofityoutubeapi.Pojo.PlayListData
import com.example.muko.kotlinrefrofityoutubeapi.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.youtubelayoutview.view.*

class PlayListAdapter(tumOynatmaListeleri : List<PlayListData.Items>?): RecyclerView.Adapter<PlayListAdapter.PlayListViewHolder>() {
    var oynatmaListeleri = tumOynatmaListeleri
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        var inflater = LayoutInflater.from(parent?.context)
        var teksatirplaylist = inflater.inflate(R.layout.youtubelayoutview, parent, false)
        return PlayListViewHolder(teksatirplaylist)
    }

    override fun getItemCount(): Int {
        return oynatmaListeleri!!.size
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        var oanolusturulansatir = oynatmaListeleri?.get(position)
        holder.setData(oanolusturulansatir, position)
    }

    inner class PlayListViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        var tekSatirPlayList = itemView as CardView
        var playlistTitle = tekSatirPlayList.tvListe
        var playListImg:CircleImageView = tekSatirPlayList.imgListe

        fun setData(oanolusturulansatir : PlayListData.Items?,pos: Int){
            playlistTitle.text = oanolusturulansatir?.mSnippet?.mTitle
            Picasso.get().load(oanolusturulansatir?.mSnippet?.mThumbnails?.mHigh?.mUrl).into(playListImg)
        }
    }
}