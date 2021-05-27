package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Events;
import org.rmj.guanzongroup.guanzonapp.R;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter_NewsEvents extends RecyclerView.Adapter<Adapter_NewsEvents.NewsEvents>{
    private static final String TAG = Adapter_NewsEvents.class.getSimpleName();

    private List<Events> news_eventsList;
    private Events news_events;
    private OnEventItemClickListener listener;

    public Adapter_NewsEvents(List<Events> news_eventsList, OnEventItemClickListener listener){
        this.news_eventsList = news_eventsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsEvents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_events, parent, false);
        return new NewsEvents(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsEvents holder, int position) {
        news_events = news_eventsList.get(position);
        holder.events = news_events;
        holder.lblTitle.setText(getTitle(news_events.getEventTitle(), news_events.getBranchName()));
        holder.lblDate.setText(Date_Readable_Format(news_events.getEventStart())+ " - " + Date_Readable_Format(news_events.getEventEnded()));
        holder.lblLocation.setText(news_events.getEventVenue());
        holder.lblTime.setText(news_events.getEventEnded());
        holder.imgThumbl.setImageBitmap(getImageThumbnail(news_events.getThumbnailx()));
    }

    @Override
    public int getItemCount() {
        return news_eventsList.size();
    }

    static class NewsEvents extends RecyclerView.ViewHolder{

        Events events;
        TextView lblTitle;
        TextView lblDate;
        TextView lblLocation;
        TextView lblTime;
        ImageView imgThumbl;

        NewsEvents(@NonNull View itemView, final OnEventItemClickListener listener) {
            super(itemView);

            lblTitle = itemView.findViewById(R.id.lbl_list_event_title);
            lblDate = itemView.findViewById(R.id.lbl_list_event_date);
            lblLocation = itemView.findViewById(R.id.lbl_list_event_location);
            lblTime = itemView.findViewById(R.id.lbl_list_event_time);
            imgThumbl = itemView.findViewById(R.id.img_list_event_thmbnl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG, "Item click");
                    listener.OnClick(events.getTramsNoxxx() ,events.getEventURLxx());
                }
            });
        }
    }

    private String getTitle(String Title, String BranchName){
        if(Title.isEmpty()){
            return BranchName;
        } else if(BranchName.isEmpty()){
            return BranchName;
        } else {
            return Title + " - " + BranchName;
        }
    }

    @SuppressLint("SimpleDateFormat")
    private String Date_Readable_Format(String dateReceive){
        try {
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(dateReceive);
            return new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    private Bitmap getImageThumbnail(String TransNox){
        File loFilePath = Environment.getExternalStorageDirectory() ;
        File imgFile = new File(loFilePath.getAbsolutePath() + "/Android/data/GuanzonApps/Events/" + TransNox + ".png");
        if(imgFile.exists()){
            Bitmap loBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return loBitmap;
        }
        return null;
    }

    public interface OnEventItemClickListener{
        void OnClick(String TransNox, String Url);
    }
}
