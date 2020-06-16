package fr.mylocalphone.sanbot.sanbot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.MediaController
import kotlinx.android.synthetic.main.media3.*

/**
 * Created by angelshurikan on 09/11/2017.
 */

class Media3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.media3)
        Log.d("MLP", "Media3")
        videoPlay()
    }

    fun videoPlay() {
        val mediaC = MediaController(this)
        val videopath = "android.resource://" + this.packageName + "/" + R.raw.media2
        val uri = Uri.parse(videopath)
        video3.setVideoURI(uri)
        video3.setMediaController(mediaC)
        mediaC.setAnchorView(video3)
        video3.start()
        nextEtape()
    }

    fun nextEtape() {
        val intent = Intent(this, Dance3::class.java)
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