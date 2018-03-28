
package com.software.idea.selfiecamera.filter;

import android.content.Context;
import android.opengl.GLES20;

import com.software.idea.selfiecamera.MyGLUtils;
import com.software.idea.selfiecamera.R;


public class TileMosaicFilter extends CameraFilter {
    private int program;

    public TileMosaicFilter(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.tile_mosaic);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId},
                new int[][]{});
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }
}
