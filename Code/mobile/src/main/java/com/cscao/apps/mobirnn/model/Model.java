package com.cscao.apps.mobirnn.model;

import android.content.Context;

/**
 * Created by qqcao on 5/11/17Thursday.
 *
 * Runtime model
 */

public class Model {
    private AbstractModel mModel;

    public Model(Context context, ModelMode mode, int layerSize, int hiddenUnits) {
        switch (mode) {
            case CPU:
                mModel = new CpuModel(context, layerSize, hiddenUnits);
                break;
            case GPU:
                mModel = new GpuModel(context, layerSize, hiddenUnits);
                break;
            case TensorFlow:
                mModel = new TensorFlowModel(context, layerSize, hiddenUnits);
                break;
            default:
                mModel = new TensorFlowModel(context, layerSize, hiddenUnits);
        }
    }

    public int predict(float[][] x) {
        return mModel.predictLabel(x);
    }
}