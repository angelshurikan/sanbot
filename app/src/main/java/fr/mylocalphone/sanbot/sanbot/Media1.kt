package fr.mylocalphone.sanbot.sanbot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.MediaController
import kotlinx.android.synthetic.main.media1.*


/**
 * Created by angelshurikan on 09/11/2017.
 */

class Media1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.media1)
        Log.d("MLP", "Media1")
        videoPlay()
    }

    fun videoPlay() {
        val mediaC = MediaController(this)
        val videopath = "android.resource://" + this.packageName + "/" + R.raw.media1
        val uri = Uri.parse(videopath)
        video1.setVideoURI(uri)
        video1.setMediaController(mediaC)
        mediaC.setAnchorView(video1)
        video1.start()
        nextEtape()
    }

    fun nextEtape() {
        val intent = Intent(this, Dance1::class.java)
        object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(51000)
                } catch (e: Exception) {
                }
                startActivity(intent)
                finish()
            }
        }.start()
    }
}