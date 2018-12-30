package whu.iss.sric.android;

import android.os.Bundle;

import java.util.List;

import whu.iss.sric.base.BaseActivity;
import whu.iss.sric.bean.DBScoreBean;
import whu.iss.sric.utils.DBScoreBeanDaoUtils;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        doInUI(new Runnable() {
            @Override
            public void run() {
                //创建用户 放到本地数据库
                List<DBScoreBean> dbScoreBeanList = DBScoreBeanDaoUtils.getInstance().queryAllData();
                if (dbScoreBeanList == null || dbScoreBeanList.isEmpty()) {
                    DBScoreBean dbScoreBean = new DBScoreBean();
                    dbScoreBean.setUserId(1);
                    dbScoreBean.setScore(0);
                    DBScoreBeanDaoUtils.getInstance().insertOneData(dbScoreBean);
                }
                // 允许用户使用应用
                toActivity(MainActivity.class);
                LaunchActivity.this.finish();
            }
        }, 1000);
    }
}
