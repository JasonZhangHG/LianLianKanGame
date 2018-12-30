// Generated code from Butter Knife. Do not modify!
package whu.iss.sric.android;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131230761;

  private View view2131230760;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_start_game_main_activity, "field 'mStartGame' and method 'startGame'");
    target.mStartGame = Utils.castView(view, R.id.btn_start_game_main_activity, "field 'mStartGame'", Button.class);
    view2131230761 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startGame();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_ranking_main_activity, "field 'mRanking' and method 'toRankingActivity'");
    target.mRanking = Utils.castView(view, R.id.btn_ranking_main_activity, "field 'mRanking'", Button.class);
    view2131230760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toRankingActivity();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mStartGame = null;
    target.mRanking = null;

    view2131230761.setOnClickListener(null);
    view2131230761 = null;
    view2131230760.setOnClickListener(null);
    view2131230760 = null;

    this.target = null;
  }
}
