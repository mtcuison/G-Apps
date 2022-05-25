package org.rmj.guanzongroup.notifications.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMViewNotification;

public class Fragment_ViewMessage extends Fragment {

    private TextView lblTitle, lblMesgx;

    String[] descriptionData = {"Processing", "Packed", "Shipped", "Delivered"};

    private VMViewNotification mViewModel;

    public static Fragment_ViewMessage newInstance() {
        return new Fragment_ViewMessage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View loView = inflater.inflate(R.layout.fragment_view_message, container, false);
        mViewModel = new ViewModelProvider(this).get(VMViewNotification.class);
        lblTitle = loView.findViewById(R.id.lbl_messageTitle);
        lblMesgx = loView.findViewById(R.id.lbl_messageBody);

//        StateProgressBar progressBar = (StateProgressBar) loView.findViewById(R.id.your_state_progress_bar_id);
//        progressBar.setStateDescriptionData(descriptionData);

        if(requireActivity().getIntent().hasExtra("sMsgIDxxx")){
            String lsMesgID = requireActivity().getIntent().getStringExtra("sMsgIDxxx");
            mViewModel.GetNotificationInfo(lsMesgID).observe(requireActivity(), loNotif -> {
                try{
                    lblTitle.setText(loNotif.MsgTitle);
                    lblMesgx.setText(loNotif.Messagex);
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        } else {

        }
        return loView;
    }
}