package uz.revolution.a4kfullwallpapers.ui.app

import android.app.Application
import io.alterac.blurkit.BlurKit

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        BlurKit.init(this)
    }
}