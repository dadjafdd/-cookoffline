package com.example.cookoffline
import android.os.Bundle; import androidx.activity.ComponentActivity; import androidx.activity.compose.setContent; import androidx.activity.viewModels; import com.example.cookoffline.ui.*; import com.example.cookoffline.ui.theme.CookOfflineTheme
class MainActivity : ComponentActivity() { private val vm: MainViewModel by viewModels(); override fun onCreate(b: Bundle?) { super.onCreate(b); setContent { CookOfflineTheme { MainScreen(vm) } } } }
