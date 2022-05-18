/*
 * Copyright (C) 2016 venshine.cn@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhpan.idea.utils;

import android.text.TextUtils;
import android.util.Log;


/**
 * Log日志打印操作
 *
 * @author Weiss
 */
public class LogUtils {

    public static String tagPrefix = "";
    public static boolean showDebug = true;


    /**
     * 得到tag（所在类.方法（L:行））
     *
     * @return
     */
    private static String generateTag() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String callerClazzName = stackTraceElement.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        String tag = "%s.%s(L:%d)";
        tag = String.format(tag, new Object[]{callerClazzName, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
        //给tag设置前缀
        tag = TextUtils.isEmpty(tagPrefix) ? tag : tagPrefix + ":" + tag;
        return tag;
    }

    public static void v(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.v(tag, msg);
        }
    }

    public static void v(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.v(tag, msg, tr);
        }
    }

    public static void d(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.d(tag, msg);
        }
    }

    public static void d(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.d(tag, msg, tr);
        }
    }

    public static void d(String tag, String msg) {
        if (showDebug) {
            Log.d(generateTag(), tag + msg);
        }
    }

    public static void i(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.i(tag, msg);
        }
    }

    public static void i(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.i(tag, msg, tr);
        }
    }

    public static void w(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.w(tag, msg);
        }
    }

    public static void w(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.w(tag, msg, tr);
        }
    }

    public static void e(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (showDebug) {
            Log.e(generateTag(), tag + msg);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.e(tag, msg, tr);
        }
    }

    public static void wtf(String msg) {
        if (showDebug) {
            String tag = generateTag();
            Log.wtf(tag, msg);
        }
    }

    public static void wtf(String msg, Throwable tr) {
        if (showDebug) {
            String tag = generateTag();
            Log.wtf(tag, msg, tr);
        }
    }

}
