package com.woaiqw.utils.core;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by haoran on 2019/2/18.
 */
public class TextViewUtils {

    /*
     * 为TextView设置特殊颜色   比如： 共5个项目 （5是红色，其他黑色）
     *
     * str:内容
     * normalColor:正常颜色
     * specialColor:特殊颜色
     * specialStart:起始位置
     * specialEnd:结束位置
     * */
    public static void setSpecialTextColor(TextView textView, String str, int normalColor, int specialColor, int specialStart, int specialEnd){
        int len = str.length();
        if(!(specialStart<specialEnd)){/*specialStart必须小于specialEnd*/
            return;
        }
        if(specialEnd>len){/*specialEnd必须小于等于len*/
            return;
        }
        try{
            textView.setText(str);
            SpannableStringBuilder builder = new SpannableStringBuilder(str);

            //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
            ForegroundColorSpan specialSpan = new ForegroundColorSpan(specialColor);
            ForegroundColorSpan normalSpan = new ForegroundColorSpan(normalColor);
            builder.setSpan(normalSpan, 0, specialStart, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(specialSpan, specialStart, specialEnd, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            builder.setSpan(normalSpan, specialEnd, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            textView.setText(builder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
