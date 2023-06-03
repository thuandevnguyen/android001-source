package com.example.demobuoi7.localfiles

import android.Manifest
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.demobuoi7.R
import com.example.demobuoi7.databinding.ActivityLocalFileBinding
import com.example.demobuoi7.databinding.ActivityPrefsBinding

class LocalFileActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityLocalFileBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonPermission.setOnClickListener {
            requestPermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        binding.button.setOnClickListener {
            saveImage()
        }
    }

    private var requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                Toast.makeText(this, "Co quyen", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Khong quyen", Toast.LENGTH_LONG).show()
            }
        }

    private fun saveImage() {
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.demo)
            .into(object : CustomTarget<Bitmap?>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
                    FileUtils.saveBitmapExternal(this@LocalFileActivity, resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {

                }

            })
    }
}