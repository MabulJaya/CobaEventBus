package id.web.hangga.latihaneventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import id.web.hangga.latihaneventbus.Module.MainEvent;


public class MainActivity extends AppCompatActivity {

    private EventBus myEventBus = EventBus.getDefault();
    private TextView txtMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myEventBus.getDefault().register(this);

        setContentView(R.layout.activity_main);
        txtMain = (TextView) findViewById(R.id.txtMain);
        Button smallbutton = (Button) findViewById(R.id.smallbutton);
        smallbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                intent.putExtra("name", txtMain.getText().toString());
                startActivity(intent);
            }
        });
    }

    /*

    Di coba register dan unreg disini tapi malah ndak jalan

    @Override
    public void onResume() {
        myEventBus.getDefault().register(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        myEventBus.getDefault().unregister(this);
    }*/


    @Subscribe
    public void onEvent(MainEvent event){
        txtMain.setText(event.getMessage());
    }

}
