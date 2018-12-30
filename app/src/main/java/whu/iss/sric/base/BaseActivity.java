package whu.iss.sric.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    public final String TAG = getClassName();
    public Context mContext = this;
    private View loadingView;
    protected Handler mHandler;

    // 当前activity是否是前台运行状态
    public boolean isForegroundRunning = false;

    // 当前app是否是前台状态
    private static boolean isActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isForegroundRunning = false;

    }

    public Handler getHandler() {
        if (mHandler == null) {
            synchronized (this) {
                if (mHandler == null) {
                    mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }


    public void showMessage(int text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    public void doInUI(Runnable runnable) {
        doInUI(runnable, 0);
    }

    public void doInUI(Runnable runnable, long delayMillis) {
        getHandler().postDelayed(runnable, delayMillis);
    }

    public void toActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isForegroundRunning = true;
        if (!isActive) {
            //app 从后台唤醒，进入前台
            isActive = true;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isForegroundRunning = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isForegroundRunning = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        isForegroundRunning = false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (loadingView == null || loadingView.getParent() == null) {
            super.onBackPressed();
            return;
        }
        ArrayList<Integer> list = (ArrayList<Integer>) loadingView.getTag();
        list.clear();
        ((ViewGroup) loadingView.getParent()).removeView(loadingView);
    }

    public <V extends View> V findView(int id) {
        return (V) findViewById(id);
    }

    public String getClassName() {
        return getClass().getSimpleName();
    }
}
