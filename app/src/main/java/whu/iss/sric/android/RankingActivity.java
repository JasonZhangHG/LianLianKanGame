package whu.iss.sric.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import whu.iss.sric.base.BaseActivity;
import whu.iss.sric.bean.DBRankingBean;
import whu.iss.sric.utils.DBRankingBeanDaoUtils;

public class RankingActivity extends BaseActivity {

    private ListView lvResultActivity;
    private List<DBRankingBean> resultDaoList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        lvResultActivity = (ListView) findViewById(R.id.lvResultActivity);
        resultDaoList = DBRankingBeanDaoUtils.getInstance().queryAllData();
        Collections.sort(resultDaoList, new Comparator<DBRankingBean>() {
            @Override
            public int compare(DBRankingBean relationUser1, DBRankingBean relationUser2) {
                long ret = relationUser2.getScore() - relationUser1.getScore();
                if (ret > 0) {
                    return 1;
                } else if (ret < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        myAdapter = new MyAdapter(resultDaoList);
        lvResultActivity.setAdapter(myAdapter);
    }

    public class MyAdapter extends BaseAdapter {
        private List<DBRankingBean> resultDaoList;
        private LayoutInflater inflater;
        private MyVidewHolder myViewHolder;

        public MyAdapter(List<DBRankingBean> resultDaoList) {
            this.resultDaoList = resultDaoList;
            inflater = LayoutInflater.from(RankingActivity.this);
        }

        @Override
        public int getCount() {
            return resultDaoList.size();
        }

        @Override
        public Object getItem(int position) {
            return resultDaoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_result, null);
                myViewHolder = new MyVidewHolder();
                myViewHolder.mScore = (TextView) convertView.findViewById(R.id.tv_score_item_ranking);
                myViewHolder.mType = (TextView) convertView.findViewById(R.id.tv_type_item_ranking);
                myViewHolder.mTime = (TextView) convertView.findViewById(R.id.tv_time_item_ranking);
                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyVidewHolder) convertView.getTag();
            }
            SimpleDateFormat sdr1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String time = sdr1.format(new Date(resultDaoList.get(position).currentTimeAsId));
            myViewHolder.mTime.setText("游戏时间：" + time);
            myViewHolder.mScore.setText("游戏得分：" + resultDaoList.get(position).getScore());
            switch (resultDaoList.get(position).getType()) {
                case 1:
                    myViewHolder.mType.setText("游戏等级：初级模式");
                    break;
                case 2:
                    myViewHolder.mType.setText("游戏等级：中级模式");
                    break;
                case 3:
                    myViewHolder.mType.setText("游戏等级：高级模式");
                    break;
                default:
                    break;
            }
            return convertView;
        }

        class MyVidewHolder {
            TextView mScore;
            TextView mType;
            TextView mTime;
        }
    }
}
