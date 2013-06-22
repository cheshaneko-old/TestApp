package info.elfapp.testapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String s = settings.getString("message", "Null");
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(s);
    }


    public void saveMessage(View view) {
        //EditText editText = (EditText) findViewById(R.id.editText);

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        EditText editText = (EditText) findViewById(R.id.editText);
        editor.putString("message", editText.getText().toString());
        // Commit the edits!
        editor.commit();


    }
}
