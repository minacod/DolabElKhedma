package com.example.shafy.dolabelkhedma.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by shafy on 06/11/2017.
 */

public class BitmapUtils {

    private final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private LruCache<String, Bitmap> mMemoryCache=new LruCache<String, Bitmap>(maxMemory){
        @Override
        protected int sizeOf(String key, Bitmap bitmap) {
            // The cache size will be measured in kilobytes rather than
            // number of items.
            return bitmap.getByteCount() / 1024;
        }
    };
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }
}
