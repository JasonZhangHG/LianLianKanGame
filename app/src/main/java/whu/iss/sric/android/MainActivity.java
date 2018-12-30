package whu.iss.sric.android;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import whu.iss.sric.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_start_game_main_activity) Button mStartGame;
    @BindView(R.id.btn_ranking_main_activity) Button mRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start_game_main_activity)
    public void startGame() {
        toActivity(SelectGameActivity.class);
    }

    @OnClick(R.id.btn_ranking_main_activity)
    public void toRankingActivity() {
        toActivity(RankingActivity.class);
    }

}
