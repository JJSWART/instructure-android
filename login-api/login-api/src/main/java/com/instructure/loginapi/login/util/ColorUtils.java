/*
 * Copyright (C) 2016 - present Instructure, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.instructure.loginapi.login.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;


public class ColorUtils {

    public static Drawable tintIt(int color, Drawable drawable) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    public static Drawable tintIt(Context context, int color, @DrawableRes int drawableResId) {
        Drawable wrappedDrawable = DrawableCompat.wrap(context.getResources().getDrawable(drawableResId));
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    public static Drawable colorIt(int color, Drawable drawable) {
        drawable.mutate().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return drawable;
    }

    public static void colorIt(int color, ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if(drawable == null) return;

        drawable.mutate().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        imageView.setImageDrawable(drawable);
    }

    public static Drawable colorIt(Context context, int color, int drawableResId) throws NullPointerException {
        Drawable drawable = context.getResources().getDrawable(drawableResId);
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return drawable;
    }

    public static Bitmap colorIt(int color, Bitmap map) {
        Canvas canvas = new Canvas(map);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(map, 0, 0, paint);
        return map;
    }
}
