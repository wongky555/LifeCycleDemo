package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycledemo.mymodels.DataViewModel

class MainActivity : AppCompatActivity() {

    //var value : Int = 0
    lateinit var viewModel : DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity","On create")
        val tvResult:TextView = findViewById(R.id.tvResult)
        val btnSet: Button = findViewById(R.id.btnSetData)
        val btnName:Button = findViewById(R.id.btnName)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        viewModel.myValue.observe(this, Observer {
            newValue -> tvResult.text = newValue.toString()
        })

        viewModel.myName.observe(this, Observer {
                newValue -> tvResult.text = newValue.toString()
        })

        if(viewModel.myValue.value != 0){
            tvResult.text = viewModel.myValue.value.toString()
        }
//        if(savedInstanceState !=null)
//        {
//            value = savedInstanceState.getInt("data")
//            tvResult.text = value.toString()
//        }

        btnSet.setOnClickListener(){
            viewModel.myValue.value = 123
            //tvResult.text =  viewModel.myValue.value.toString()
        }

        btnName.setOnClickListener(){
            viewModel.myName.value = "ABC"
            //tvResult.text =  viewModel.myValue.value.toString()
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("data", value)
//    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy")
    }
}