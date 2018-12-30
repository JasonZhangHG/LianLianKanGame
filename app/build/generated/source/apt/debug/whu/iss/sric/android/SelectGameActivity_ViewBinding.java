// Generated code from Butter Knife. Do not modify!
package whu.iss.sric.android;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectGameActivity_ViewBinding<T extends SelectGameActivity> implements Unbinder {
  protected T target;

  private View view2131230757;

  private View view2131230759;

  private View view2131230758;

  private View view2131230889;

  @UiThread
  public SelectGameActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_easy_select_game_activity, "field 'mSelectEasyGame' and method 'selectEasyGame'");
    target.mSelectEasyGame = Utils.castView(view, R.id.btn_easy_select_game_activity, "field 'mSelectEasyGame'", Button.class);
    view2131230757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectEasyGame();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_middle_select_game_activity, "field 'mSelectMiddleGame' and method 'selectMiddleGame'");
    target.mSelectMiddleGame = Utils.castView(view, R.id.btn_middle_select_game_activity, "field 'mSelectMiddleGame'", Button.class);
    view2131230759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectMiddleGame();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_hard_select_game_activity, "field 'mSelectHardGame' and method 'selectHardGame'");
    target.mSelectHardGame = Utils.castView(view, R.id.btn_hard_select_game_activity, "field 'mSelectHardGame'", Button.class);
    view2131230758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectHardGame();
      }
    });
    view = Utils.findRequiredView(source, R.id.tb_settings_fragment, "field 'mAcceptButton' and method 'onAcceptButtonClicked'");
    target.mAcceptButton = Utils.castView(view, R.id.tb_settings_fragment, "field 'mAcceptButton'", ToggleButton.class);
    view2131230889 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAcceptButtonClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mSelectEasyGame = null;
    target.mSelectMiddleGame = null;
    target.mSelectHardGame = null;
    target.mAcceptButton = null;

    view2131230757.setOnClickListener(null);
    view2131230757 = null;
    view2131230759.setOnClickListener(null);
    view2131230759 = null;
    view2131230758.setOnClickListener(null);
    view2131230758 = null;
    view2131230889.setOnClickListener(null);
    view2131230889 = null;

    this.target = null;
  }
}
