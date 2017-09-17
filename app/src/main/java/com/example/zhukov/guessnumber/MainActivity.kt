package com.example.zhukov.guessnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View //很重要，添加当前View
import kotlinx.android.synthetic.main.activity_main.* //很重要，这样才能读到控件名称
import android.content.pm.ApplicationInfo





class MainActivity : AppCompatActivity() {

    var randomNum : Int = ((Math.random()*100).toInt())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
