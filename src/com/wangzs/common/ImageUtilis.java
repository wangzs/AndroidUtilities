package com.wangzs.common;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.util.Log;

/**
 * ImageUtilis - Image process utilities
 * @author wang.zhenshui07@gamil.com
 * @date   2014/11/12
 */
public class ImageUtilis {
	private final static String TAG = "ImageUtilis";
	
	/**
	 * <p>Get compress image from file with assign width and height,
	 * 	  keep aspect ratio</p>
	 * <p>if w = 0 && h = 0  return origin image<p>
	 * <p>if w = 0 || h = 0  according to large aside with nonzero params 
	 * 					  calculate compress rate</p>
	 * <p>other according to large aside compress rate get image</p>
	 * @param filePath - local image file path
	 * @param w - width of the compress image
	 * @param h - height of the compress image
	 * @return
	 */
	public static Bitmap getResizeBitmap(
			String filePath, int w, int h) {
		if (filePath == null) {
			return null;
		}
		
		Bitmap resizeBitmap = null;
		try {
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(filePath, options);
			options.inSampleSize = calculteSampleSize(options, w, h);
			options.inJustDecodeBounds = false;
			resizeBitmap = BitmapFactory.decodeFile(filePath, options);
		} catch (OutOfMemoryError e) {
			Log.e(TAG, "Out of memory error.", e);
		}
		return resizeBitmap;
	}
	
	/**
	 * <p>Get compress image from bytes data with assign width and height,
	 * 	  keep aspect ratio</p>
	 * <p>if w = 0 && h = 0  return origin image<p>
	 * <p>if w = 0 || h = 0  according to large aside with nonzero params 
	 * 					  calculate compress rate</p>
	 * <p>other according to large aside compress rate get image</p>
	 * @param imgBytes - image byte stream
	 * @param w - width of the compress image
	 * @param h - height of the compress image
	 * @return
	 */
	public static Bitmap getResizeBitmap(
			byte[] imgBytes, int w, int h) {
		if (imgBytes == null || imgBytes.length == 0) {
			return null;
		}
		
		Bitmap resizeBitmap = null;
		try {
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length, options);
			
			options.inSampleSize = calculteSampleSize(options, w, h);
			options.inJustDecodeBounds = false;
			resizeBitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length, options);
		} catch (OutOfMemoryError e) {
			Log.e(TAG, "Out of memory error.", e);
		}
		return resizeBitmap;
	}
	
	/**
	 * <p>Get compress image from inputstream with assign width and height,
	 * 	  keep aspect ratio</p>
	 * <p>if w = 0 && h = 0  return origin image<p>
	 * <p>if w = 0 || h = 0  according to large aside with nonzero params 
	 * 					  calculate compress rate</p>
	 * <p>other according to large aside compress rate get image</p>
	 * @param is - inputstream
	 * @param w - width of the compress image
	 * @param h - height of the compress image
	 * @return
	 */
	public static Bitmap getResizeBitmap(
			InputStream is, int w, int h) {
		if (is == null) {
			return null;
		}
		
		Bitmap resizeBitmap = null;
		try {
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(is, null, options);
			
			options.inSampleSize = calculteSampleSize(options, w, h);
			options.inJustDecodeBounds = false;
			options.inDither = false;
			options.inPreferredConfig = Config.ARGB_8888;
			resizeBitmap = BitmapFactory.decodeStream(is, null, options);
		} catch (OutOfMemoryError e) {
			Log.e(TAG, "Out of memory error.", e);
		}
		
		return resizeBitmap;
	}
	
	private static int calculteSampleSize(
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
	
	/**
	 * Write a compressed version of the bitmap to the specified outputstream
	 * @param bitmap - compress image
	 * @param format - format of the compressed image
	 * @param quality - compress quality(0~100)，100 meaning compress for max quality
	 * @param isRecycle - is or not recyle bitmap memory
	 * @return
	 */
	public static byte[] getCompressBitmap(Bitmap bitmap,
			Bitmap.CompressFormat format, int quality,
			boolean isRecycle) {
		if (bitmap == null) return null;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(format, quality, baos);
		if (isRecycle) {
			bitmap.recycle();
		}
		
		byte[] compressImgData = baos.toByteArray(); 
		try {
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return compressImgData;
	}
	
	/**
	 * Write a compressed version of the bitmap to the specified file
	 * @param bitmap
	 * @param fileName
	 * @param format
	 * @param quality
	 * @param isRecycle
	 * @return
	 */
	public static boolean saveBitmapToFile(Bitmap bitmap,
			String fileName, Bitmap.CompressFormat format,
			int quality, boolean isRecycle) {
		if (bitmap == null || fileName == null || fileName.length() == 0) {
			return false;
		}
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		File outFile = new File(fileName);
		if (!outFile.isFile() || !outFile.exists()) {
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fos = new FileOutputStream(outFile);
			bos = new BufferedOutputStream(fos);
			bitmap.compress(format, quality, bos);
			if (isRecycle) {
				bitmap.recycle();
			}
			
			bos.flush(); 
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (bos != null) {
					bos.close();
				} 
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	
	
}
