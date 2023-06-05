package com.th7.tensafetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            String command = DataUtil.ReadStringValue(context, "cmd", "");

            if (command.equals("")){
                return;
            }

            try {
                Intent bs = new Intent("com.tensafe.app.onerun.fun.sucmd");
                bs.setPackage("com.topjohnwu.magisk");
                bs.putExtra("argv", command);
                bs.putExtra("magic", "!@#$@ss2$");
                context.sendBroadcast(bs);
            } catch (Exception e) {
                return;
            }

            Toast.makeText(context, "TensafeTest: Boot Command Run Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
