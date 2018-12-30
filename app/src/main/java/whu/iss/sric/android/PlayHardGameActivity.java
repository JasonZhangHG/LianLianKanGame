package whu.iss.sric.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import whu.iss.sric.bean.DBRankingBean;
import whu.iss.sric.utils.DBRankingBeanDaoUtils;
import whu.iss.sric.utils.SharePreferenceUtil;
import whu.iss.sric.view.GameView;
import whu.iss.sric.view.HardGameView;
import whu.iss.sric.view.OnStateListener;
import whu.iss.sric.view.OnTimerListener;
import whu.iss.sric.view.OnToolsChangeListener;

public class PlayHardGameActivity extends Activity
        implements OnClickListener, OnTimerListener, OnStateListener, OnToolsChangeListener {

    private ImageButton btnPlay;
    private ImageButton btnRefresh;
    private ImageButton btnTip;
    private ImageView imgTitle;
    private HardGameView gameView;
    private SeekBar progress;
    private MyHardDialog dialog;
    private ImageView clock;
    private TextView textRefreshNum;
    private TextView textTipNum;
    private MediaPlayer player;
    private TextView mType;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    gameOver();
                    dialog = new MyHardDialog(PlayHardGameActivity.this, gameView, "Success", gameView.getTotalTime() - progress.getProgress());
                    dialog.show();
                    break;
                case 1:
                    gameOver();
                    dialog = new MyHardDialog(PlayHardGameActivity.this, gameView, "Failed", gameView.getTotalTime() - progress.getProgress());
                    dialog.show();
                    break;
                default:
                    break;
            }
        }
    };

    public void gameOver() {
        if (gameView == null) {return;}
        int mScoreCount = gameView.getGameStoreCount();
        if (mScoreCount > 0) {
            DBRankingBean dbRankingBean = new DBRankingBean();
            dbRankingBean.setCurrentTimeAsId(System.currentTimeMillis());
            dbRankingBean.setScore(mScoreCount);
            dbRankingBean.setType(3);
            DBRankingBeanDaoUtils.getInstance().insertOneData(dbRankingBean);
        }
        gameView.initGameCount();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_game);
        btnPlay = (ImageButton) findViewById(R.id.play_btn);
        btnRefresh = (ImageButton) findViewById(R.id.refresh_btn);
        btnTip = (ImageButton) findViewById(R.id.tip_btn);
        imgTitle = (ImageView) findViewById(R.id.title_img);
        gameView = (HardGameView) findViewById(R.id.game_view);
        clock = (ImageView) findViewById(R.id.clock);
        progress = (SeekBar) findViewById(R.id.timer);
        textRefreshNum = (TextView) findViewById(R.id.text_refresh_num);
        textTipNum = (TextView) findViewById(R.id.text_tip_num);
        mType = (TextView) findViewById(R.id.tv_type_play_game_activity);

        //XXX
        progress.setMax(gameView.getTotalTime());
        gameView.initGameCount();

        btnPlay.setOnClickListener(this);
        btnRefresh.setOnClickListener(this);
        btnTip.setOnClickListener(this);
        gameView.setOnTimerListener(this);
        gameView.setOnStateListener(this);
        gameView.setOnToolsChangedListener(this);
        HardGameView.initSound(this);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        imgTitle.startAnimation(scale);
        btnPlay.startAnimation(scale);

        player = MediaPlayer.create(this, R.raw.bg);
        if (SharePreferenceUtil.getInstance().getBoolean("OpenMusic")) {
            player.setLooping(true);
            player.start();
        }

//        GameView.soundPlay.play(GameView.ID_SOUND_BACK2BG, -1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.setMode(GameView.PAUSE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameView.setMode(GameView.QUIT);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.play_btn:
                Animation scaleOut = AnimationUtils.loadAnimation(this, R.anim.scale_anim_out);
                Animation transIn = AnimationUtils.loadAnimation(this, R.anim.trans_in);

                btnPlay.startAnimation(scaleOut);
                btnPlay.setVisibility(View.GONE);
                imgTitle.setVisibility(View.GONE);
                gameView.setVisibility(View.VISIBLE);

                btnRefresh.setVisibility(View.VISIBLE);
                btnTip.setVisibility(View.VISIBLE);
                progress.setVisibility(View.VISIBLE);
                clock.setVisibility(View.VISIBLE);
                textRefreshNum.setVisibility(View.VISIBLE);
                textTipNum.setVisibility(View.VISIBLE);
                mType.setVisibility(View.GONE);

                btnRefresh.startAnimation(transIn);
                btnTip.startAnimation(transIn);
                gameView.startAnimation(transIn);
                player.pause();
                gameView.startPlay();
                break;
            case R.id.refresh_btn:
                Animation shake01 = AnimationUtils.loadAnimation(this, R.anim.shake);
                btnRefresh.startAnimation(shake01);
                gameView.refreshChange();
                break;
            case R.id.tip_btn:
                Animation shake02 = AnimationUtils.loadAnimation(this, R.anim.shake);
                btnTip.startAnimation(shake02);
                gameView.autoClear();
                break;
        }
    }

    @Override
    public void onTimer(int leftTime) {
        Log.i("onTimer", leftTime + "");
        progress.setProgress(leftTime);
    }

    @Override
    public void OnStateChanged(int StateMode) {
        switch (StateMode) {
            case GameView.WIN:
                handler.sendEmptyMessage(0);
                break;
            case GameView.LOSE:
                handler.sendEmptyMessage(1);
                break;
            case GameView.PAUSE:
                player.stop();
                gameView.player.stop();
                gameView.stopTimer();
                break;
            case GameView.QUIT:
                player.release();
                gameView.player.release();
                gameView.stopTimer();
                break;
        }
    }

    @Override
    public void onRefreshChanged(int count) {
        textRefreshNum.setText("" + gameView.getRefreshNum());
    }

    @Override
    public void onTipChanged(int count) {
        textTipNum.setText("" + gameView.getTipNum());
    }

    public void quit() {
        this.finish();
    }
}