package com.wangzs.common;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * ImageUtilis - Image process utilities
 * @author wang.zhenshui07@gamil.com
 * @date   2014/11/12
 */
public class ImageUtilis {
	private final static String TAG = "ImageUtilis";
	
	/**
	 * 
	 * @param filePath - local image file path
	 * @param w - width of the compress image
	 * @param h - height of the compress image
	 * @return
	 */
	public static Bitmap getCompressBitmap(
			String filePath, int w, int h) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);
		
		options.inSampleSize = calculteInSampleSize(options, w, h);
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(filePath, options);
	}
	
	public static int calculteInSampleSize(
			BitmapFactory.Options opts, int w, int h) {
		// Raw height and width of image  
        final int height = opts.outHeight;  
        final int width = opts.outWidth;  
        int inSampleSize = 1;  
        if (w == 0 && h== 0) {
        	inSampleSize = 1;
        } else if (w==0 || h==0) {
        	int m = (w == 0 ? h : w);
        	if (width > height) {
        		inSampleSize = Math.round((float) width / (float) m); 
        	} else {
        		inSampleSize = Math.round((float) height / (float) m); 
        	}
        	// if inSample value is not a pow of 2, set value round up pow of 2
            if ((inSampleSize & (inSampleSize - 1)) != 0) {
            	inSampleSize = inSampleSize << 1;	
            }
        } else if (height > h || width > w) {  
            if (width > height) {  
                inSampleSize = Math.round((float) height / (float) h);  
            } else {  
                inSampleSize = Math.round((float) width / (float) w);  
            }  
        }
        
        return inSampleSize;  
	} 
	
	
}
