package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.taskviewpager_tablayout.TaskViewpagerTabLayout
import com.example.taskandroid.dimenResponse.dimen_responsive
import com.example.taskandroid.drawable.DrawableMain
import com.example.taskandroid.task_notification_fcm.TaskNotificationFCMMain
import com.example.taskandroid.task_appbar_toolbar.TaskAppbarToolbarMain
import com.example.taskandroid.task_di.TaskDIMain
import com.example.taskandroid.task_runtime_permissions.TaskRuntimePermissionMain
import com.example.taskandroid.tasklayout.TaskLayoutMain
import com.example.taskandroid.taskactivity.TaskActivityMain
import com.example.taskandroid.taskdialogs.TaskDialogMain
import com.example.taskandroid.tasksnackbarfab.TaskSnackBarFabMain
import com.example.taskandroid.taskfonts.TaskFontsMain
import com.example.taskandroid.taskintentfilter.TaskIntentFilterMain
import com.example.taskandroid.taskmap.TaskMapMain
import com.example.taskandroid.taskrecycleview.TaskRecycleViewMain
import com.example.taskandroid.taskretrofit.TaskRetrofitMain
import com.example.taskandroid.taskroomdatabase.TaskRoomDatabaseMain
import com.example.taskandroid.tasksharedpreferences.LoginPageSharedPreference
import com.example.taskandroid.taskthread.TaskThreadMain
import com.example.taskandroid.taskwebview.TaskWebViewMain
import com.example.taskandroid.taskworkmanager.TaskWorkManagerMain
import com.example.taskandroid.tc.TaskFragmentsMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button for the clicking 1. Activity
        val actLogBtn: Button = findViewById(R.id.btn1)
        actLogBtn.setOnClickListener {
            val intent = Intent(this, TaskActivityMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 2. layout
        val layoutBtn: Button = findViewById(R.id.btn2)
        layoutBtn.setOnClickListener {
            val intent = Intent(this, TaskLayoutMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 3. Drawable
        val drawableCustomBtn: Button = findViewById(R.id.btn3)
        drawableCustomBtn.setOnClickListener {
            val intent = Intent(this, DrawableMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 4. Dimens for responsive design
        val demanResponseBtn: Button = findViewById(R.id.btn4)
        demanResponseBtn.setOnClickListener {
            val intent = Intent(this, dimen_responsive::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 5. ViewPager and TabLayout
        val viewPageTAbLayoutBtn: Button =findViewById(R.id.btn5)
        viewPageTAbLayoutBtn.setOnClickListener {
            val intent = Intent(this, TaskViewpagerTabLayout::class.java)
            startActivity(intent)
        }

        //Button for the clicking 6. AppBar and ToolBar
        val appBarToolBarBtn: Button = findViewById(R.id.btn6)
        appBarToolBarBtn.setOnClickListener {
            val intent = Intent(this, TaskAppbarToolbarMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 7. Task SnackBar Fab
        val snackbarFabbtn: Button = findViewById(R.id.btn7)
        snackbarFabbtn.setOnClickListener {
            val intent = Intent(this, TaskSnackBarFabMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 8. Fonts
        val FontBtn: Button = findViewById(R.id.btn8)
        FontBtn.setOnClickListener {
            val intent = Intent(this, TaskFontsMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 9.Task Dialog
        val dialogBoxBtn: Button = findViewById(R.id.btn9)
        dialogBoxBtn.setOnClickListener {
            val intent = Intent(this, TaskDialogMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 10.Fragments
        val fragBtn: Button = findViewById(R.id.btn10)
        fragBtn.setOnClickListener {
            val intent = Intent(this, TaskFragmentsMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 11. RecycleView
        val recycleViewBtn: Button = findViewById(R.id.btn11)
        recycleViewBtn.setOnClickListener {
            val intent = Intent(this, TaskRecycleViewMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 12. intent Filter
        val intentFilterBtn: Button = findViewById(R.id.btn12)
        intentFilterBtn.setOnClickListener {
            val intent = Intent(this, TaskIntentFilterMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 13. Runtime Permission
        val runtimePermissionBtn: Button = findViewById(R.id.btn13)
        runtimePermissionBtn.setOnClickListener {
            val intent = Intent(this, TaskRuntimePermissionMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 14. Shared Preference
        val sharedPreferenceBtn: Button = findViewById(R.id.btn14)
        sharedPreferenceBtn.setOnClickListener {
            val intent = Intent(this, LoginPageSharedPreference::class.java)
            startActivity(intent)
        }

        //Button for the clicking 15. Web View
        val webViewBtn: Button = findViewById(R.id.btn15)
        webViewBtn.setOnClickListener {
            val intent = Intent(this, TaskWebViewMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 16. RetroFit
        val retrofitBtn: Button = findViewById(R.id.btn16)
        retrofitBtn.setOnClickListener {
            val intent = Intent(this, TaskRetrofitMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 17. Room Database
        val roomDatabaseBtn: Button = findViewById(R.id.btn17)
        roomDatabaseBtn.setOnClickListener {
            val intent = Intent(this, TaskRoomDatabaseMain::class.java)
            startActivity(intent)
        }
            
        //Button for the clicking 18. Notification/FCM
        val notificationFCMBtn: Button = findViewById(R.id.btn18)
        notificationFCMBtn.setOnClickListener {
            val intent = Intent(this, TaskNotificationFCMMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 19. Map
        val mapBtn: Button = findViewById(R.id.btn19)
        mapBtn.setOnClickListener {
            val intent = Intent(this, TaskMapMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 20. Multithreading
        val threadBtn: Button = findViewById(R.id.btn20)
        threadBtn.setOnClickListener {
            val intent = Intent(this, TaskThreadMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 21. Work Manager
        val workBtn: Button = findViewById(R.id.btn21)
        workBtn.setOnClickListener {
            val intent = Intent(this, TaskWorkManagerMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 22. Dependency Injection
        val diBtn: Button = findViewById(R.id.btn22)
        diBtn.setOnClickListener {
            val intent = Intent(this, TaskDIMain::class.java)
            startActivity(intent)
        }
    }
}
