package com.app.akademikapp.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.akademikapp.data.model.Mahasiswa

class MahasiswaDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "akademik.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_MAHASISWA = "mahasiswa"

        private const val COLUMN_ID = "id"
        private const val COLUMN_NIM = "nim"
        private const val COLUMN_NAMA = "nama"
        private const val COLUMN_PRODI = "prodi"
        private const val COLUMN_SEMESTER = "semester"
        private const val COLUMN_EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_MAHASISWA (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NIM TEXT,
                $COLUMN_NAMA TEXT,
                $COLUMN_PRODI TEXT,
                $COLUMN_SEMESTER INTEGER,
                $COLUMN_EMAIL TEXT
            )
        """.trimIndent()

        db.execSQL(createTable)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MAHASISWA")
        onCreate(db)
    }

    fun insertMahasiswa(mahasiswa: Mahasiswa): Boolean {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_NIM, mahasiswa.nim)
            put(COLUMN_NAMA, mahasiswa.nama)
            put(COLUMN_PRODI, mahasiswa.prodi)
            put(COLUMN_SEMESTER, mahasiswa.semester)
            put(COLUMN_EMAIL, mahasiswa.email)
        }

        val result = db.insert(TABLE_MAHASISWA, null, values)

        db.close()

        return result != -1L
    }

    fun getAllMahasiswa(): MutableList<Mahasiswa> {
        val list = mutableListOf<Mahasiswa>()

        val db = readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_MAHASISWA ORDER BY id DESC",
            null
        )

        if (cursor.moveToFirst()) {
            do {
                list.add(
                    Mahasiswa(
                        id = cursor.getInt(0),
                        nim = cursor.getString(1),
                        nama = cursor.getString(2),
                        prodi = cursor.getString(3),
                        semester = cursor.getInt(4),
                        email = cursor.getString(5)
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return list
    }

    fun deleteMahasiswa(id: Int): Boolean {
        val db = writableDatabase

        val result = db.delete(
            TABLE_MAHASISWA,
            "$COLUMN_ID=?",
            arrayOf(id.toString())
        )

        db.close()

        return result > 0
    }
}