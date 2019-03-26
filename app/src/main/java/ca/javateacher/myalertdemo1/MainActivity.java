package ca.javateacher.myalertdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import static ca.javateacher.myalertdemo1.MyAlert.alert;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void showAlert(View view) {
    alert(this, "Hello Sheridan!");
  }
}
