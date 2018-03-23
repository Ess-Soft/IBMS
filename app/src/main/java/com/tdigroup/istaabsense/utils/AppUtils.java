package com.tdigroup.istaabsense.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.CountDownTimer;
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
import java.util.Random;

/**
 * Created by ayoub on 5/21/17.
 */

public class AppUtils {

    private static final String TAG = "AppUtils";
    private Context mContext;
    private String LOG_TAG = "Utils Log";

    //----------------------------------------------------------------------------------------------------------
    public static final String MARKET_GOOGLE_URL = "market://details?id=";
    public static final String WEB_GOOGLE_URL = "http://play.google.com/store/apps/details?id=";

    public static final String MARKET_SAMSUNG_URL = "samsungapps://ProductDetail/";
    public static final String WEB_SAMSUNG_URL = "http://www.samsungapps.com/appquery/appDetail.as?appId=";

    public static final String MARKET_AMAZON_URL = "amzn://apps/android?p=";
    public static final String WEB_AMAZON_URL = "http://www.amazon.com/gp/mas/dl/android?p=";
    //------------------------------------------------------------------------------------------------------------

    public AppUtils(Context context) {
        this.mContext = context;
    }

    /**
     * public void saveFirstOpened(int number) {
     * SharedPreferences sp = PreferenceManager
     * .getDefaultSharedPreferences(mContext);
     * sp.edit().putInt("bookmarked_page", number).apply();
     * showToast(String.format(mContext.getResources().getString(R.string.page_bookmarked), number));
     * }
     */

    public void openOnMarket(String market, String web, Context context, String packageName) {

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(market + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException anfe) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(web + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            showToast("Galaxy store is not installed on this phone.");
        }

    }


    public void openOnGooglePlayMarket(Context context, String packageName) {
        openOnMarket(MARKET_GOOGLE_URL, WEB_GOOGLE_URL, context, packageName);
    }

    public void openOnSamsungMarket(Context context, String packageName) {
        openOnMarket(MARKET_SAMSUNG_URL, WEB_SAMSUNG_URL, context, packageName);
    }

    public void openOnAmazonMarket(Context context, String packageName) {
        openOnMarket(MARKET_AMAZON_URL, WEB_AMAZON_URL, context, packageName);
    }


    public void doRestart(Context c) {
        try {
            //check if the context is given
            if (c != null) {
                //fetch the packagemanager so we can get the default launch activity
                // (you can replace this intent with any other activity if you want
                PackageManager pm = c.getPackageManager();
                //check if we got the PackageManager
                if (pm != null) {
                    //create the intent with the default start activity for your application
                    Intent mStartActivity = pm.getLaunchIntentForPackage(
                            c.getPackageName()
                    );
                    if (mStartActivity != null) {
                        mStartActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //create a pending intent so the application is restarted after System.exit(0) was called.
                        // We use an AlarmManager to call this intent in 100ms
                        int mPendingIntentId = 223344;
                        PendingIntent mPendingIntent = PendingIntent
                                .getActivity(c, mPendingIntentId, mStartActivity,
                                        PendingIntent.FLAG_CANCEL_CURRENT);
                        AlarmManager mgr = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
                        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                        //kill the application
                        System.exit(0);
                    } else {
                        Log.e(TAG, "Was not able to restart application, mStartActivity null");
                    }
                } else {
                    Log.e(TAG, "Was not able to restart application, PM null");
                }
            } else {
                Log.e(TAG, "Was not able to restart application, Context null");
            }
        } catch (Exception ex) {
            Log.e(TAG, "Was not able to restart application");
        }
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

    public void runAppFromPackage(String packageName) {
        try {
            Intent LaunchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
            mContext.startActivity(LaunchIntent);
        } catch (Exception ex) {
            showToast("Couldn't run app ! maybe it doesn't exist anymore. please check that.");
        }
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void hideView(View v) {
        if (v != null) {
            v.setVisibility(View.GONE);
        } else {
            Log.e(TAG, "View is null !!");
        }
    }

    public void showView(View v) {
        if (v != null) {
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
        return rand.nextInt((max - min) + 1) + max;
        //  Toast.makeText(,random()+" Milli", Toast.LENGTH_LONG).show();
    }

    public int randomNumber(int max) {
        Random ran = new Random();
        return ran.nextInt(max);
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void WriteDirectory(String dirName) {
        File f1 = new File(Environment.getExternalStorageDirectory() + "/" + dirName);
        if (!f1.exists()) {
            f1.mkdirs();
            Log.e("WriteDir", f1.getAbsolutePath() + " written");
        }
    }

    public String getWritableDir(String dirName) {
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

    public boolean isUnknownSourceActivated() {
        try {
            return Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS) == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return Boolean.parseBoolean(null);
        }
    }

    public boolean isAdminActive(DevicePolicyManager DPM, ComponentName CN) {
        return DPM != null && CN != null && DPM.isAdminActive(CN);
    }

        public void requestDeviceAdmin(ComponentName CN, String request_explanation){

                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, CN);
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, request_explanation);
                mContext.startActivity(intent);

        }

    public void installAppDialog(String title, String message, String positiveButtonText, String negativeButtonText,
                                 final String packageName) {
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

    public void showMessageDialogAndRestart(final String title, final String message, final String positiveButtonText, final boolean kill) {
            try {
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                                .setTitle(title)
                                .setMessage(message)
                                .setCancelable(false)
                                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        if (kill) {
                                            doRestart(mContext);
                                        }
                                        //  openInStore(mContext.getPackageName());
                                    }
                                });

                        alderDialog.show();
                    }
                });

            } catch(Exception ex){
                    ex.printStackTrace();
                }

    }

    public void showMessageDialogAndKill(String title, String message, String positiveButtonText, final boolean kill) {
        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (kill) {
                            System.exit(0);
                        }
                        //  openInStore(mContext.getPackageName());
                    }
                });

        alderDialog.show();
    }

    public void showMessageDialogAndRate(String title, String message, String positiveButtonText) {
        AlertDialog.Builder alderDialog = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        openInStore(mContext.getPackageName());
                        //  openInStore(mContext.getPackageName());
                    }
                });

        alderDialog.show();
    }

    public void openDeveloper(String devName) {
        try {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + devName)));
        } catch (ActivityNotFoundException anfe) {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + devName)));
        }
    }

    public void initializeToken(Activity activity) {
        activity.finish();
    }

    public void openInStore(String packageName) {
        try {
            Intent storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(storeIntent);
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(mContext, "Google Play app is not installed on this phone.", Toast.LENGTH_LONG).show();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void showToast(final String msg) {
        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void log(String msg) {
        if (msg != null) {
            Log.e(LOG_TAG, msg);
        }
    }

    public void fullScreen(boolean isFullScreen) {
        if (!isFullScreen) {
            ((Activity) mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            ((Activity) mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else {
            ((Activity) mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            ((Activity) mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        }

    }

    /**
     * Match signature of application to identify that if it is signed by system
     * or not.
     *
     * @param packageName package of application. Can not be blank.
     * @return <code>true</code> if application is signed by system certificate,
     * otherwise <code>false</code>
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

    public void shareApp() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "DOWNLOAD IT NOW");

        sharingIntent.putExtra(Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=" + mContext.getPackageName());
        mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public Drawable getAppIconFromPackage(String packageName) {
        return mContext.getPackageManager().getApplicationIcon(mContext.getApplicationInfo());
    }

    public String getApplicationVersionFromPackage(String packageName) {
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

    public void saveStatusChecker(boolean status) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        sp.edit().putBoolean("status", status).apply();
        //   showToast(String.format(mContext.getResources().getString(R.string.page_bookmarked), number));
    }

    public void prefStringSaver(String prefName, String value) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        sp.edit().putString(prefName, value).apply();
        //   showToast(String.format(mContext.getResources().getString(R.string.page_bookmarked), number));
    }

    public String prefStringLoader(String prefName) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        return sp.getString(prefName, "");
    }

    public boolean loadStatusChecker() {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);
        return sp.getBoolean("status", false);
    }

    public boolean preferenceFileExist(String fileName) {
        File f = new File(mContext.getApplicationInfo().dataDir + "/shared_prefs/"
                + fileName + ".xml");
        return f.exists();
    }

    public void runSplashScreen(final int interval, final Intent intent) {
        new CountDownTimer(interval * 1000, 1000) {
            int remaining = interval;

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            }

            /** This method will be invoked in every 1000 milli seconds until
             * this timer is expired.Because we specified 1000 as tick time
             * while creating this CountDownTimer
             */
            @Override
            public void onTick(long millisUntilFinished) {
                //     icon.setVisibility(View.VISIBLE);
                //     new ExplodeAnimation(icon).animate();
                Log.e("=> Splash Counter", --remaining + " seconds remained to pass to " + intent.getComponent().getClassName());
            }
        }.start();
    }
}
