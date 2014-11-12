package com.wangzs.common;

import java.io.File;

import android.content.Context;
import android.os.Environment;

/**
 * Utilis - Common Utilities
 * @author wang.zhenshui07@gamil.com
 * @date   2014/11/12
 */
public class Utilis {
	private final static String TAG = "Utilis";
	
	
	/**
	 * Get the sdcard absolute path, if don't 
	 * has sdcard, return null
	 * @return
	 */
	public static String getSDCardPath() {
		String path = null;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			path = Environment.getExternalStorageDirectory().getAbsolutePath();
		}
		return path;
	}
	
	/**
	 * Get the app data path. eg:/data/data/com.xx.xx
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public static String getAppDataPath(Context context) {
		return context.getApplicationInfo().dataDir;
	}
	
	/**
	 * Get external directory file. eg:/sdcard/xxx/
	 * @param context
	 * @param appFileName
	 * @return
	 */
	public static File getAppExternalFile(Context context, String appFileName) {
		if (!Environment.getExternalStorageState()
				.equals(Environment.MEDIA_MOUNTED)) {
			return null;
		}
		File externalFile = new File(
				Environment.getDownloadCacheDirectory(), appFileName);
		if (!externalFile.exists() || !externalFile.isDirectory()) {
			externalFile.mkdirs();
		}
		
		return externalFile;
	}
	
	
	
	
	
	
}
