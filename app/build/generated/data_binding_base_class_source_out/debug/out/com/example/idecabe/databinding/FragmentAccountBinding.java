// Generated by view binder compiler. Do not edit!
package com.example.idecabe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.idecabe.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAccountBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView backArrow;

  @NonNull
  public final TextView nameOfProject;

  @NonNull
  public final TextView textAboutApp;

  @NonNull
  public final TextView textAccount;

  @NonNull
  public final TextView textLogout;

  @NonNull
  public final TextView textNotifications;

  private FragmentAccountBinding(@NonNull LinearLayout rootView, @NonNull ImageView backArrow,
      @NonNull TextView nameOfProject, @NonNull TextView textAboutApp,
      @NonNull TextView textAccount, @NonNull TextView textLogout,
      @NonNull TextView textNotifications) {
    this.rootView = rootView;
    this.backArrow = backArrow;
    this.nameOfProject = nameOfProject;
    this.textAboutApp = textAboutApp;
    this.textAccount = textAccount;
    this.textLogout = textLogout;
    this.textNotifications = textNotifications;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backArrow;
      ImageView backArrow = ViewBindings.findChildViewById(rootView, id);
      if (backArrow == null) {
        break missingId;
      }

      id = R.id.name_of_project;
      TextView nameOfProject = ViewBindings.findChildViewById(rootView, id);
      if (nameOfProject == null) {
        break missingId;
      }

      id = R.id.textAboutApp;
      TextView textAboutApp = ViewBindings.findChildViewById(rootView, id);
      if (textAboutApp == null) {
        break missingId;
      }

      id = R.id.textAccount;
      TextView textAccount = ViewBindings.findChildViewById(rootView, id);
      if (textAccount == null) {
        break missingId;
      }

      id = R.id.textLogout;
      TextView textLogout = ViewBindings.findChildViewById(rootView, id);
      if (textLogout == null) {
        break missingId;
      }

      id = R.id.text_notifications;
      TextView textNotifications = ViewBindings.findChildViewById(rootView, id);
      if (textNotifications == null) {
        break missingId;
      }

      return new FragmentAccountBinding((LinearLayout) rootView, backArrow, nameOfProject,
          textAboutApp, textAccount, textLogout, textNotifications);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
