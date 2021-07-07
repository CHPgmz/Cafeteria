package com.gmz.practica_02_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity2 : AppCompatActivity() {

    val tvDetail:TextView by lazy {
        findViewById(R.id.tvDetail)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        val extras = intent.extras?: return
        tvDetail.setText(extras.getString("detalle"))
    }
}