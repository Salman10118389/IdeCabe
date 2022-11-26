// Generated by view binder compiler. Do not edit!
package com.example.idecabe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.idecabe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProjectBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView backArrow;

  @NonNull
  public final TextView choose;

  @NonNull
  public final TextView createNewProject;

  @NonNull
  public final Spinner maskingSelection;

  @NonNull
  public final TextView textDashboard;

  private FragmentProjectBinding(@NonNull LinearLayout rootView, @NonNull ImageView backArrow,
      @NonNull TextView choose, @NonNull TextView createNewProject,
      @NonNull Spinner maskingSelection, @NonNull TextView textDashboard) {
    this.rootView = rootView;
    this.backArrow = backArrow;
    this.choose = choose;
    this.createNewProject = createNewProject;
    this.maskingSelection = maskingSelection;
    this.textDashboard = textDashboard;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_project, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProjectBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backArrow;
      ImageView backArrow = ViewBindings.findChildViewById(rootView, id);
      if (backArrow == null) {
        break missingId;
      }

      id = R.id.choose;
      TextView choose = ViewBindings.findChildViewById(rootView, id);
      if (choose == null) {
        break missingId;
      }

      id = R.id.create_new_project;
      TextView createNewProject = ViewBindings.findChildViewById(rootView, id);
      if (createNewProject == null) {
        break missingId;
      }

      id = R.id.maskingSelection;
      Spinner maskingSelection = ViewBindings.findChildViewById(rootView, id);
      if (maskingSelection == null) {
        break missingId;
      }

      id = R.id.text_dashboard;
      TextView textDashboard = ViewBindings.findChildViewById(rootView, id);
      if (textDashboard == null) {
        break missingId;
      }

      return new FragmentProjectBinding((LinearLayout) rootView, backArrow, choose,
          createNewProject, maskingSelection, textDashboard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}