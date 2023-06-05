package com.th7.tensafetest;

import static com.th7.tensafetest.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        String cmd = DataUtil.ReadStringValue(this,"cmd","");
        TextView tvs = (TextView) findViewById (id.bootcmd);
        tvs.setText(cmd);
    }

    public void OnClick(final View view) {
        try {
            switch (view.getId()) {
                case id.xposed: {
                    RunCommand("am start -n de.robv.android.xposed.installer/de.robv.android.xposed.installer.WelcomeActivity");
                    break;
                }
                case id.xposeddebug: {
                    RunCommand("am start -n de.robv.android.xposed.installer/de.robv.android.xposed.installer.DebugActivity");
                    break;
                }
                case id.savecmd:{
                    String cmd = ((EditText) findViewById(id.bootcmd)).getText().toString();
                    DataUtil.SaveStringValue(this, "cmd", cmd);
                }
                default:
                    break;
            }
        }
        catch (Exception ex) {}
    }

    public void RunCommand(String str){
        Intent intent = new Intent("com.tensafe.app.onerun.fun.sucmd");
        intent.setPackage("com.topjohnwu.magisk");
        intent.putExtra("argv", str);
        intent.putExtra("magic", "!@#$@ss2$");
        this.sendBroadcast(intent);
    }

}