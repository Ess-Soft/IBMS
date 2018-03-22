package com.tdigroup.istaabsense.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by ayoub on 5/21/17.
 */

public class AppUtils {

    private static final String TAG = "AppUtils";
    private Context mContext;
    private String LOG_TAG = "Utils Log";

    public AppUtils(Context context){
        this.mContext = context;
    }

    public boolean isInstalled(String codePackage) {
            try {
                PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(codePackage, 0);
                Log.i(TAG, codePackage + " is properly installed.");
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.i("==> PluginManager", codePackage + "  is not installed: return false...");
                return false;
            }
    }

    public void runAppFromPackage(String packageName){
        try {
            Intent LaunchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
            mContext.startActivity(LaunchIntent);
        } catch (Exception ex){
            showToast("Couldn't run app ! maybe it doesn't exist anymore. please check that.");
        }
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void hideView(View v){
        if(v != null){
            v.setVisibility(View.GONE);
        } else {
            Log.e(TAG, "View is null !!");
        }
    }
    public void showView(View v){
        if(v != null){
            v.setVisibility(View.VISIBLE);
        } else {
            Log.e(TAG, "View is null !!");
        }
    }

    public int random(int min, int max) {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((max - min) +1 ) + max;
        //  Toast.makeText(,random()+" Milli", Toast.LENGTH_LONG).show();
    }

    public int randomNumber(int max){
        Random ran = new Random();
        return ran.nextInt(max);
    }

    public boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    private void WriteDirectory(String dirName){
        File f1 = new File(Environment.getExternalStorageDirectory() + "/" + dirName);
        if (!f1.exists()) {
            f1.mkdirs();
            Log.e("WriteDir", f1.getAbsolutePath()+ " written");
        }
    }

    public String getWritableDir(String dirName){
        // String writeDir = "";
        WriteDirectory(dirName);
        Log.e("WritableDir", Environment.getExternalStorageDirectory() + "/" + dirName);
        return Environment.getExternalStorageDirectory() + "/" + dirName;
    }

    public void requestPermission(Activity activity, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, 0);
        }
    }

    public boolean isUnknownSourceActivated(){
        try {
            return Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS) == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return Boolean.parseBoolean(null);
        }
    }

    public void installAppDialog(String title, String message, String positiveButtonText, String negativeButtonText,
                                 final String packageName){
        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       openInStore(packageName);
                    }
                })
                .setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alderDialog.show();
    }

    public void showMessageDialog(String title, String message, String positiveButtonText,final boolean kill){
        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(kill) {
                            System.exit(0);
                        }
                    }
                });

        alderDialog.show();
    }

    public void showRateDialog(String title, String message, String positiveButtonText){
        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openInStore(mContext.getPackageName());
                    }
                })
                .setNegativeButton("NOT NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alderDialog.show();
    }


    public void openUrl(String Url){
        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(Url));
            mContext.startActivity(i);
        } catch (ActivityNotFoundException e){
            e.printStackTrace();
        }

    }

    public void initializeToken(Activity activity){
        activity.finish();
    }

    public void openInStore(String packageName){
        try {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(mContext, "Google Play app is not installed on this phone.", Toast.LENGTH_LONG).show();
        }
    }

    public void showToast(String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public void log(String msg){ if(msg != null) {Log.e(LOG_TAG, msg);} }

    public void fullScreen(boolean isFullScreen){
        if(!isFullScreen)
        {
            ((Activity)mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            ((Activity)mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else
        {
            ((Activity)mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            ((Activity)mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        }

    }

    /**
     * Match signature of application to identify that if it is signed by system
     * or not.
     *
     * @param packageName
     *            package of application. Can not be blank.
     * @return <code>true</code> if application is signed by system certificate,
     *         otherwise <code>false</code>
     */
    public boolean isSystemApp(String packageName) {
        try {
            // Get packageinfo for target application
            PackageManager mPackageManager = mContext.getPackageManager();
            PackageInfo targetPkgInfo = mPackageManager.getPackageInfo(
                    packageName, PackageManager.GET_SIGNATURES);
            // Get packageinfo for system package
            PackageInfo sys = mPackageManager.getPackageInfo(
                    "android", PackageManager.GET_SIGNATURES);
            // Match both packageinfo for there signatures
            return (targetPkgInfo != null && targetPkgInfo.signatures != null && sys.signatures[0]
                    .equals(targetPkgInfo.signatures[0]));
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public void shareApp(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "DOWNLOAD IT NOW");

        sharingIntent.putExtra(Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=" + mContext.getPackageName());
        mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public Drawable getAppIconFromPackage(String packageName){
        return mContext.getPackageManager().getApplicationIcon(mContext.getApplicationInfo());
    }

    public String getApplicationVersionFromPackage(String packageName){
        PackageInfo pinfo = null;
        try {
            pinfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
       // String verCode = pinfo.versionName;
        assert pinfo != null;
        return pinfo.versionName;
    }

    public Drawable setImageFromString(String img_name){
        Resources res = mContext.getResources();
        int resID = res.getIdentifier(img_name, "drawable", mContext.getPackageName());
        return res.getDrawable(resID );
    }

    public ArrayList<String> getAds(String[] ads){
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(ads).subList(0, ads.length));
            return  data;
    }
    public void saveAdsCounterRemained(long number) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        sp.edit().putLong("adCounter", number).apply();
     //   showToast(String.format(mContext.getResources().getString(R.string.page_bookmarked), number));
    }

    public long loadAdCounterRemained() {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        return sp.getLong("adCounter", 0);
    }

    /**
    public void saveFirstOpened(int number) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        sp.edit().putInt("bookmarked_page", number).apply();
        showToast(String.format(mContext.getResources().getString(R.string.page_bookmarked), number));
    }
     */
}
