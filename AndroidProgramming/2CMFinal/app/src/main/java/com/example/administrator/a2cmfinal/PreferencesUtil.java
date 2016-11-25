package com.example.administrator.a2cmfinal;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016-11-25.
 */
@SuppressWarnings("static-access")
public class PreferencesUtil {

    /**
     * Preference 세팅
     * @author YT
     */
    public static void setPreferences(Context context, String key, boolean value) {
        SharedPreferences p = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Preference 가져오기
     * @author YT
     */
    public static Boolean getPreferences(Context context, String key) {
        SharedPreferences p = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        p = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        return p.getBoolean(key, false);
    }
}
