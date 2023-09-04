package org.rmj.guanzongroup.ganado.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

//import org.rmj.g3appdriver.GCircle.room.Entities.EMcModel;
import org.rmj.guanzongroup.ganado.R;

import java.util.ArrayList;
import java.util.List;

public class ModelGridAdapter extends BaseAdapter {

    Context context;
    String[] ModelNm;
    int[] modelimg;



    @Override
    public int getCount() {
        return ModelNm.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
