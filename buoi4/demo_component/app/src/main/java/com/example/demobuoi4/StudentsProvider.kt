package com.example.demobuoi4

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.database.ContentObserver
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.Log

class DatabaseHelper(context: Context) :
  SQLiteOpenHelper(/* context = */ context, /* name = */ "students.db", /* factory = */ null, /* version = */ 1) {
  override fun onCreate(db: SQLiteDatabase?) {
    db?.execSQL(
      """CREATE TABLE $TABLE_NAME (
      |$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
      |$COLUMN_NAME TEXT,
      |$COLUMN_AGE INTEGER)""".trimMargin()
    )
  }

  override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    onCreate(db)
  }

  companion object {
    const val TABLE_NAME = "students"
    const val COLUMN_ID = "_id"
    const val COLUMN_NAME = "name"
    const val COLUMN_AGE = "age"
  }
}

class MyContentObserver(private val onChange: () -> Unit) : ContentObserver(Handler(Looper.getMainLooper())) {
  override fun deliverSelfNotifications(): Boolean {
    return true
  }

  override fun onChange(selfChange: Boolean) {
    super.onChange(selfChange)
    Log.d("MyContentObserver", "Change...")
    onChange()
  }
}

class StudentsProvider : ContentProvider() {
  private lateinit var dbHelper: DatabaseHelper

  override fun onCreate(): Boolean {
    dbHelper = DatabaseHelper(context!!)
    return true
  }

  override fun query(
    uri: Uri,
    projection: Array<out String>?,
    selection: String?,
    selectionArgs: Array<out String>?,
    sortOrder: String?
  ): Cursor? {
    val db = dbHelper.readableDatabase
    val cursor = db.query(
      /* table = */ TABLE_NAME,
      /* columns = */ projection,
      /* selection = */ selection,
      /* selectionArgs = */ selectionArgs,
      /* groupBy = */ null,
      /* having = */ null,
      /* orderBy = */ sortOrder
    )
    cursor.setNotificationUri(context?.contentResolver, uri)
    return cursor
  }

  override fun getType(uri: Uri): String? {
    return "vnd.android.cursor.dir/$AUTHORITY.$TABLE_NAME"
  }

  override fun insert(uri: Uri, values: ContentValues?): Uri? {
    val db = dbHelper.writableDatabase
    val rowId = db.insert(
      TABLE_NAME,
      null,
      values,
    )
    context?.contentResolver?.notifyChange(uri, null)
    return ContentUris.withAppendedId(CONTENT_URI, rowId)
  }

  override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
    TODO("Not yet implemented")
  }

  override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
    TODO("Not yet implemented")
  }

  companion object {
    const val AUTHORITY = "com.example.demobuoi4.provider"
    const val TABLE_NAME = DatabaseHelper.TABLE_NAME
    val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$TABLE_NAME")
  }
}