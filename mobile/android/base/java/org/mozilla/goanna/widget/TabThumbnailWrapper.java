package org.mozilla.goanna.widget;

import android.content.Context;
import android.util.AttributeSet;
import org.mozilla.goanna.R;
import org.mozilla.goanna.widget.themed.ThemedRelativeLayout;


public class TabThumbnailWrapper extends ThemedRelativeLayout {
    private boolean mRecording;
    private static final int[] STATE_RECORDING = { R.attr.state_recording };

    public TabThumbnailWrapper(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TabThumbnailWrapper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);

        if (mRecording) {
            mergeDrawableStates(drawableState, STATE_RECORDING);
        }
        return drawableState;
    }

    public void setRecording(boolean recording) {
        if (mRecording != recording) {
            mRecording = recording;
            refreshDrawableState();
        }
    }

}
