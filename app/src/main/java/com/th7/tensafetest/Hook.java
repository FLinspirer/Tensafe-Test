package com.th7.tensafetest;

import android.content.Context;
import android.content.pm.PackageManager;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.tensafe.app.safectrlmn")) {
        
            Class PolicyMn = loadPackageParam.classLoader.loadClass("com.tensafe.app.safectrlmn.PolicyMn");
            
            XposedHelpers.findAndHookMethod(PolicyMn, "CheckIsNeedDisableOnScreen",Context.class,String.class, PackageManager.class,new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "ChangeUrlByPolicy",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(param.args[0]);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "IsWhiteUrls",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "IsLockScreenShowPackage",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "IsWhiteNetPackageName",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "IsBlackNetPackageName",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                }  
            });
  
            XposedHelpers.findAndHookMethod(PolicyMn, "checkIsWhiteApplication",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "checkIsBlackApplication",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                }  
            });
            
            XposedHelpers.findAndHookMethod(PolicyMn, "IsLauncherLableHide", String.class,new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                }
            });
            
             
            
        }
    }
}