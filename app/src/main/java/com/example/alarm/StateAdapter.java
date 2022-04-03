package com.example.alarm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.ViewHolder> implements GestureDetector.OnGestureListener  {

    private final LayoutInflater inflater;
    private final List<Alarm> notatkas;
    public CharSequence text;

    private OnClickToMore onClickToMore;
    private Context context;




    public OnClickToMore getOnClickToMore() {
        return onClickToMore;
    }

    public void setOnClickToMore(OnClickToMore onClickToMore) {
        this.onClickToMore = onClickToMore;
    }

    StateAdapter(Context context, List<Alarm> notatkas) {
        this.context = context;
        this.notatkas = notatkas;
        this.inflater = LayoutInflater.from(context);

//        this.colorFav = colorFav;
//        this.colorTitle = colorTitle;
//        this.colorDec = colorDec;
//        this.colorTitle1 = colorTitle1;
//        this.colorDec1 = colorDec1;
//        this.colorBottom = colorBottom;
//        this.colorBack = colorBack;
//        this.colorText = colorText;


    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new StateAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        Alarm notatka = notatkas.get(position);




        holder.time.setText(notatka.getMilisec());

        holder.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.time.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {



                return true;
            }

        });

        holder.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    public int getItemCount() {
        return notatkas.size();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView time;



        ViewHolder(View view) {
            super(view);

            time = (TextView) view.findViewById(R.id.oclock);


        }
    }

    public interface OnClickToMore{
        public void onClick(Alarm notatka);
    }

}