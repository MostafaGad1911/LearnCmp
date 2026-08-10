package mostafa.projects.learccmp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mostafa.projects.learccmp.di.initKoin

class LearnCmpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}
