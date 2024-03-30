package com.example.mymusic.ui.presentation.util

import android.graphics.*

import androidx.palette.graphics.Palette




/**
 * Created by ManhalKhwashki on 3/30/2024.
 */

object PaletteUtils {
    fun getUpperSideDominantColor(bitmap: Bitmap): Int {
        val builder = Palette.Builder(bitmap)
            .setRegion(0, 0, bitmap.width, bitmap.height / 2)
        val defaultValue = 0xFFFFFF
        val p = builder.generate()
        return p.getDominantColor(defaultValue)
    }

    fun getLowerSideDominantColor(bitmap: Bitmap): Int {
        val defaultValue = 0xFFFFFF
        val builder = Palette.Builder(bitmap)
            .setRegion(0, bitmap.height / 2, bitmap.width, bitmap.height)
        return builder.generate().getDominantColor(defaultValue)
    }

    fun getDominantGradient(bitmap: Bitmap, height: Int, width: Int): Bitmap {
        var topColor = 0
        var bottomColor = 0
        topColor = getUpperSideDominantColor(bitmap)
        bottomColor = getLowerSideDominantColor(bitmap)
        var topHex = Integer.toHexString(topColor)
        topHex = topHex.trim { it <= ' ' }
        topHex = "#$topHex"
        var bottomHex = Integer.toHexString(bottomColor)
        bottomHex = bottomHex.trim { it <= ' ' }
        bottomHex = "#$bottomHex"

        val colors = intArrayOf(Color.parseColor(topHex), Color.parseColor(bottomHex))
        //int[]colors = new int[]{ Color.GREEN,Color.BLACK};
        val mShader: Shader = LinearGradient(
            0f, 0f, width / 2f, height / 2f, colors,
            null, Shader.TileMode.CLAMP
        )
        val m = Matrix()
        m.setRotate(90f)
        mShader.setLocalMatrix(m)
        val paint = Paint()
        paint.setShader(mShader)
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(resultBitmap)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        //canvas.drawRect(0,0,640,1137,paint);
        val matrix = Matrix()
        canvas.drawBitmap(resultBitmap, matrix, paint)
        return resultBitmap
    }
}