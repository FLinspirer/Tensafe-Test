package com.th7.tensafetest;

import static com.th7.tensafetest.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }

    public void OnClick(final View view) {
        try {
            switch (view.getId()) {
                case id.network: {
                    RunCommand("sh /system/tshook/network.sh");
                    break;
                }
                case id.xposed: {
                    RunCommand("am start -n de.robv.android.xposed.installer/de.robv.android.xposed.installer.WelcomeActivity");
                    break;
                }
                case id.xposeddebug: {
                    RunCommand("am start -n de.robv.android.xposed.installer/de.robv.android.xposed.installer.DebugActivity");
                    break;
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