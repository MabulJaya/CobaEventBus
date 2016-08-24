package id.web.hangga.latihaneventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import id.web.hangga.latihaneventbus.Module.MainEvent;

public class ChangeActivity extends AppCompatActivity {

    private EditText editText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        name = getIntent().getStringExtra("name");
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(name);
        editText.setSelection(editText.length());
    }

    @Override
    public void onBackPressed() {
        if (!editText.getText().toString().equalsIgnoreCase(name)) EventBus.getDefault().post(new MainEvent(editText.getText().toString()));
        super.onBackPressed();
    }
}
