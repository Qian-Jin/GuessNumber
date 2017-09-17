package com.example.zhukov.guessnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.Configuration


class MainActivity : AppCompatActivity() {

    var randomNum : Int = ((Math.random()*100).toInt())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mCurrentOrintation : Int = resources.configuration.orientation
        if (mCurrentOrintation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main)
        }
        else if (mCurrentOrintation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main)
        }
        alarmText.text = this.getString(R.string.baseAlarm)
    }

    public fun guessNumberTextOnClick(v: View?)
    {
        guessNumberText.setText(null)
    }


    public fun letsguess(v: View?)
    {
        var guessNum : Int = 0
        try
        {
            guessNum = guessNumberText.text.toString().toInt();
        }
        catch(e : NumberFormatException)
        {
            return
        }

        if (guessNum > randomNum)
        {
            alarmText.text = this.getString(R.string.tooBig)
            guessNumberText.setText(null)
        }
        else
        {
            if (guessNum < randomNum)
            {
                alarmText.text = this.getString(R.string.tooLittle)
                guessNumberText.setText(null)
            }
            else
            {
                alarmText.text = this.getString(R.string.guessRight)
                randomNum = ((Math.random()*100).toInt())
                guessNumberText.setText(null)
            }
        }

    }


}
