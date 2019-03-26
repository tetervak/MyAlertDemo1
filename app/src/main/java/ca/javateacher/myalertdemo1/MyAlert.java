package ca.javateacher.myalertdemo1;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class MyAlert {

  private static int count = 0;
  private static final String ALERT = "alert";

  public static void alert(@NonNull FragmentActivity activity, String message){
    AlertFragment fragment = AlertFragment.newInstance(message);
    FragmentManager fragmentManager = activity.getSupportFragmentManager();
    fragment.show(fragmentManager, ALERT + (++count));
  }

  public static void alert(Fragment fragment, String message){
    FragmentActivity activity = fragment.getActivity();
    if(activity != null){
      alert(activity, message);
    }

  }

  /**
   * A simple {@link Fragment} subclass.
   */
  public static class AlertFragment extends DialogFragment {

    private static final String ARG_MESSAGE = "message";

    public AlertFragment() {
      // Required empty public constructor
    }

    public static AlertFragment newInstance(String message){
      AlertFragment fragment = new AlertFragment();
      Bundle arguments = new Bundle();
      arguments.putString(ARG_MESSAGE, message);
      fragment.setArguments(arguments);
      return fragment;
    }

    private static String getApplicationName(Context context) {
      ApplicationInfo applicationInfo = context.getApplicationInfo();
      int stringId = applicationInfo.labelRes;
      if(stringId == 0){
        return applicationInfo.nonLocalizedLabel.toString();
      }else{
        return context.getString(stringId);
      }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {

      String message = getArguments().getString(ARG_MESSAGE);
      String appName = getApplicationName(getActivity());

      // create a new AlertDialog Builder
      AlertDialog.Builder builder =
          new AlertDialog.Builder(getActivity());
      builder.setTitle(appName);
      builder.setMessage(message);
      builder.setPositiveButton(android.R.string.yes, null);

      return builder.create(); // return the AlertDialog
    }

  }
}
