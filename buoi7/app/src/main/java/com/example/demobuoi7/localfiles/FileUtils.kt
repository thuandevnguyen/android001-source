package com.example.demobuoi7.localfiles

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import com.example.demobuoi7.BuildConfig
import com.example.demobuoi7.Lec7Application
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception

object FileUtils {
    val internalPath = Lec7Application.getContext().getExternalFilesDir(null as String?)

    val tempImageFolder = "$internalPath/Android/data/${BuildConfig.APPLICATION_ID}/tempImage"

    const val LEC7_DIRECTORY = "Lec7Demo"

    val LEC7_RELATIVE_PATH = "${Environment.DIRECTORY_PICTURES}${File.separator}$LEC7_DIRECTORY"

    val LEGACY_PATH =
        "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)}${File.separator}$LEC7_DIRECTORY"


    fun saveBitmapExternal(context: Context, bitmap: Bitmap?) {
        val fileName = "${System.currentTimeMillis()}"
        var fos: OutputStream? = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.applicationContext.contentResolver?.also { resolver ->
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, LEC7_RELATIVE_PATH)
                }
                val imageUri: Uri? =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                fos = imageUri?.let { resolver.openOutputStream(it) }
            }
        } else {
            val directory = File(LEGACY_PATH)
            if (!directory.exists()) {
                directory.mkdirs()
            }
            val image = File(LEGACY_PATH, fileName)
            MediaScannerConnection.scanFile(
                context.applicationContext, arrayOf(image.absolutePath),
                arrayOf("image/jpeg"), null
            )
            fos = FileOutputStream(image)
        }
        fos?.use {
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, it)
        }
    }

    fun saveBitmapInternal(bitmap: Bitmap?) {
        val tempDataFolder = tempImageFolder
        val tempDataFolderImage = File(tempDataFolder)
        if (!tempDataFolderImage.exists()) {
            tempDataFolderImage.mkdirs()
        }
        val outputFile =
            File("$tempDataFolderImage/${System.currentTimeMillis()}${View.generateViewId()}")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(outputFile)
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
    }
}