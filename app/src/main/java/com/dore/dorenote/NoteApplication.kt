package com.dore.dorenote

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}