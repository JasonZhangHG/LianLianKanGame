package whu.iss.sric.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import whu.iss.sric.base.BaseActivity;
import whu.iss.sric.utils.SharePreferenceUtil;

public class SelectGameActivity extends BaseActivity {

    @BindView(R.id.btn_easy_select_game_activity) Button mSelectEasyGame;
    @BindView(R.id.btn_middle_select_game_activity) Button mSelectMiddleGame;
    @BindView(R.id.btn_hard_select_game_activity) Button mSelectHardGame;
    @BindView(R.id.tb_settings_fragment) ToggleButton mAcceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);
        ButterKnife.bind(this);
        mAcceptButton.setSelected(SharePreferenceUtil.getInstance().getBoolean("OpenMusic"));
        mAcceptButton.setChecked(SharePreferenceUtil.getInstance().getBoolean("OpenMusic"));
    }

    @OnClick(R.id.btn_easy_select_game_activity)
    public void selectEasyGame() {
        toActivity(PlayEastGameActivity.class);
    }

    @OnClick(R.id.btn_middle_select_game_activity)
    public void selectMiddleGame() {
        toActivity(PlayMiddleGameActivity.class);
    }

    @OnClick(R.id.btn_hard_select_game_activity)
    public void selectHardGame() {
        toActivity(PlayHardGameActivity.class);
    }

    @OnClick(R.id.tb_settings_fragment)
    public void onAcceptButtonClicked(View view) {
        boolean isCheck = mAcceptButton.isChecked();
        if (isCheck) {
            mAcceptButton.setSelected(true);
            mAcceptButton.setChecked(true);
            SharePreferenceUtil.getInstance().putBoolean("OpenMusic", true);
        } else {
            mAcceptButton.setSelected(false);
            mAcceptButton.setChecked(false);
            SharePreferenceUtil.getInstance().putBoolean("OpenMusic", false);
        }
    }
}

