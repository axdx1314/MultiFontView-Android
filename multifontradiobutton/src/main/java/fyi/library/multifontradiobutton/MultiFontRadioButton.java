package fyi.library.multifontradiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;


public class MultiFontRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    private static final String LOG_TAG = "MultiFontRadioButton";

    public MultiFontRadioButton(Context context) {
        super(context);
    }

    public MultiFontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeCustomTypeface(attrs, context);
    }

    public MultiFontRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeCustomTypeface(attrs, context);
    }

    private void initializeCustomTypeface(AttributeSet attrs, Context context) {
        if (attrs != null) {

            TypedArray attributesArray = context.obtainStyledAttributes(attrs,
                    R.styleable.MultiFontRadioButton);
            int fontID = attributesArray.getInt(R.styleable.MultiFontRadioButton_typeface_from_list, -1);
            String[] fontStringArray = context.getResources().getStringArray(R.array.customFonts);

            //if a typeface is selected for the Edittext and if the font names are declared in the
            // string array customFonts then load that typeface from cache
            if ((fontID != -1) && (fontStringArray.length != 0)) {
                try {
                    Typeface myTypeface = FontLoader.getTypeface(context, fontStringArray[fontID]);
                    setTypeface(myTypeface);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.e(LOG_TAG, "Either of the string array CustomFonts or" +
                        " attribute typeface_from_list is not present" + fontID);
            }
            attributesArray.recycle();
        }

    }
}
