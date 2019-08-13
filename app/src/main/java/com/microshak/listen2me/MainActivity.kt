package com.microshak.listen2me

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import android.util.Log.d

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.media.MediaRecorder
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.widget.Toast
import android.R.attr.start
import android.R.attr.start
import android.media.MediaPlayer












class MainActivity : AppCompatActivity() {

    private val myAudioRecorder: MediaRecorder? = null
    private val outputFile: String? = null
    private val upAudioRecorder: MediaRecorder? = null
    private val upputFile: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp"
        val upputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/uprecording.3gp"

        /*var upAudioRecorder = MediaRecorder()
        upAudioRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
        upAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        upAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
        upAudioRecorder.setOutputFile(outputFile)
*/
        var myAudioRecorder = MediaRecorder()
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
        myAudioRecorder.setOutputFile(outputFile)


        record.setOnClickListener()
        {

                myAudioRecorder.prepare()
                myAudioRecorder.start()
  //          upAudioRecorder.prepare()
   //         upAudioRecorder.start()


            record.setEnabled(false)
            stop.setEnabled(true)
            Toast.makeText(applicationContext, "Recording started", Toast.LENGTH_LONG).show()

        }

        stop.setOnClickListener(){
                myAudioRecorder.stop()
                myAudioRecorder.release()
     //       upAudioRecorder.stop()
      //      upAudioRecorder.release()

            record.setEnabled(true)
                stop.setEnabled(false)
                play.setEnabled(true)
                Toast.makeText(applicationContext, "Audio Recorder stopped", Toast.LENGTH_LONG).show()
            }



        play.setOnClickListener(){
                val mediaPlayer = MediaPlayer()
                try {
                    mediaPlayer.setDataSource(outputFile)
                    mediaPlayer.prepare()
                    mediaPlayer.start()
                    Toast.makeText(applicationContext, "Playing Audio", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    // make something
                }

            }

        upPlay.setOnClickListener(){
            val mediaPlayer = MediaPlayer()
            try {
                mediaPlayer.setDataSource(upputFile)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Toast.makeText(applicationContext, "Playing Audio", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                // make something
            }

        }



    }
    }

