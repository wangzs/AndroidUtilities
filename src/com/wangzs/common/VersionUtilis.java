package com.wangzs.common;

import android.os.Build;

/**
 * 
 * @author wangzhenshui@yy.com
 * @date   2014年11月6日
 */
public class VersionUtilis {
	private final static String TAG = "VersionUtilis";
	
	/**
	 * May 2009: Android 1.5
	 * @return
	 */
	public static boolean supportCupCake() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.CUPCAKE;
	}
	public static boolean supportAndroid_1_5() {
		return supportCupCake();
	}
	public static boolean supportLevel_3() {
		return supportCupCake();
	}
	
	/**
	 * September 2009: Android 1.6. 
	 * @return
	 */
	public static boolean supportDonut() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.DONUT;
	}
	public static boolean supportAndroid_1_6() {
		return supportDonut();
	}
	public static boolean supportLevel_4() {
		return supportDonut();
	}
	
	/**
	 * November 2009: Android 2.0 
	 * @return
	 */
	public static boolean supportEclair() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR;
	}
	public static boolean supportAndroid_2_0() {
		return supportEclair();
	}
	public static boolean supportLevel_5() {
		return supportEclair();
	}
	
	/**
	 * December 2009: Android 2.0.1
	 * @return
	 */
	public static boolean supportEclair_0_1() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR_0_1;
	}
	public static boolean supportAndroid_2_0_1() {
		return supportEclair_0_1();
	}
	public static boolean supportLevel_6() {
		return supportAndroid_2_0_1();
	}
	
	/**
	 * January 2010: Android 2.1
	 * @return
	 */
	public static boolean supportEclair_2_1() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR_MR1;
	}
	public static boolean supportAndroid_2_1() {
		return supportEclair_2_1();
	}
	public static boolean supportLevel_7() {
		return supportAndroid_2_1();
	}
	
	/**
	 * June 2010: Android 2.2
	 * @return
	 */
	public static boolean supportFroyo() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.FROYO;
	}
	public static boolean supportAndriod_2_2() {
		return supportFroyo();
	}
	public static boolean supportLevel_8() {
		return supportFroyo();
	}
	
	/**
	 * November 2010: Android 2.3
	 * @return
	 */
	public static boolean supportGingerbread() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD;
	}
	public static boolean supportAndroid_2_3() {
		return supportGingerbread();
	}
	public static boolean supportLevel_9() {
		return supportGingerbread();
	}
	
	/**
	 * February 2011: Android 2.3.3
	 * @return
	 */
	public static boolean supportGingerbread_2_3_3() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD_MR1;
	}
	public static boolean supportAndroid_2_3_3() {
		return supportGingerbread_2_3_3();
	}
	public static boolean supportLevel_10() {
		return supportGingerbread_2_3_3();
	}
	
	/**
	 * February 2011: Android 3.0
	 * @return
	 */
	public static boolean supportHoneycomb() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB;
	}
	public static boolean supportAndroid_3_0() {
		return supportHoneycomb();
	}
	public static boolean supportLevel_11() {
		return supportHoneycomb();
	}
	
	/**
	 * May 2011: Android 3.1
	 * @return
	 */
	public static boolean supportHoneycomb_3_1() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB_MR1;
	}
	public static boolean supportAndroid_3_1() {
		return supportHoneycomb_3_1();
	}
	public static boolean supportLevel_12() {
		return supportHoneycomb_3_1();
	}
	
	/**
	 * June 2011: Android 3.2
	 * @return
	 */
	public static boolean supportHoneycomb_3_2() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB_MR2;
	}
	public static boolean supportAndroid_3_2() {
		return supportHoneycomb_3_2();
	}
	public static boolean supportLevel_13() {
		return supportHoneycomb_3_2();
	}
	
	/**
	 * October 2011: Android 4.0
	 * @return
	 */
	public static boolean supportIceCreamSandwich() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH;
	}
	public static boolean supportAndroid_4_0() {
		return supportIceCreamSandwich();
	}
	public static boolean supportLevel_14() {
		return supportIceCreamSandwich();
	}
	
	/**
	 * December 2011: Android 4.0.3
	 * @return
	 */
	public static boolean supportIceCreamSandwich_4_0_3() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
	}
	public static boolean supportAndroid_4_0_3() {
		return supportIceCreamSandwich_4_0_3();
	}
	public static boolean supportLevel_15() {
		return supportIceCreamSandwich_4_0_3();
	}
	
	/**
	 * June 2012: Android 4.1
	 * @return
	 */
	public static boolean supportJellyBean() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN;
	}
	public static boolean supportAndroid_4_1() {
		return supportJellyBean();
	}
	public static boolean supportLevel_16() {
		return supportJellyBean();
	}
	
	/**
	 * Android 4.2: Moar jelly beans!
	 * @return
	 */
	public static boolean supportJellyBean_4_2() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR1;
	}
	public static boolean supportAndroid_4_2() {
		return supportJellyBean_4_2();
	}
	public static boolean supportLevel_17() {
		return supportJellyBean_4_2();
	}
	
	/**
	 * Android 4.3: Jelly Bean MR2, the revenge of the beans
	 * @return
	 */
	public static boolean supportJellyBean_4_3() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2;
	}
	public static boolean supportAndroid_4_3() {
		return supportJellyBean_4_3();
	}
	public static boolean supportLevel_18() {
		return supportJellyBean_4_3();
	}
	
	/**
	 * Android 4.4: KitKat, another tasty treat
	 * @return
	 */
	public static boolean supportKitKat() {
		return Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT;
	}
	public static boolean supportAndroid_4_4() {
		return supportKitKat();
	}
	public static boolean supportLevel_19() {
		return supportKitKat();
	}
	
	
	
	
	
}
