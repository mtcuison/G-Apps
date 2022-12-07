package org.rmj.guanzongroup.panalo.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.rmj.guanzongroup.panalo.R;
import org.rmj.guanzongroup.panalo.ViewModel.VMPanaloDashboard;

public class Fragment_PanaloDashboard extends Fragment {

    private VMPanaloDashboard mViewModel;
    private View view;
    private LinearLayout layout_GCard, layout_GPanalo, layout_GGanado;
    private TextView txt_GCardNo, txt_GCardNm, txt_GCardPnt;

    private FloatingActionButton fab_Scan;

    public static Fragment_PanaloDashboard newInstance() {
        return new Fragment_PanaloDashboard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPanaloDashboard.class);
        view = inflater.inflate(R.layout.fragment_panalo_dashboard, container, false);
        initViews();


        return view;
    }

    private void initViews() {
        layout_GCard = view.findViewById(R.id.layout_GCard);
        layout_GPanalo = view.findViewById(R.id.layout_GPanalo);
        layout_GGanado = view.findViewById(R.id.layout_GGanado);

        txt_GCardNo = view.findViewById(R.id.txt_GcardNumber);
        txt_GCardNm = view.findViewById(R.id.txt_GcardName);
        txt_GCardPnt = view.findViewById(R.id.txt_GcardPoints);

        fab_Scan = view.findViewById(R.id.fab_Scan);

    }

}