package com.example.android.quakereport;
import android.graphics.drawable.GradientDrawable;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<EarthQuake> {
    public CustomAdapter(@NonNull Context context,@NonNull List<EarthQuake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        EarthQuake eq = getItem(position);
        TextView ob1 = (TextView)listItemView.findViewById(R.id.t1);
        ob1.setText(formatMagnitude(eq.getMag()));
        GradientDrawable magnitudeCircle = (GradientDrawable) ob1.getBackground();
        int magnitudeColor = getMagnitudeColor(eq.getMag());
        magnitudeCircle.setColor(magnitudeColor);
        TextView ob2a = (TextView)listItemView.findViewById(R.id.t2a);
        TextView ob2b = (TextView)listItemView.findViewById(R.id.t2b);
        String[] str = location(eq.getEqPlace());
        ob2a.setText(str[0]);
        ob2b.setText(str[1]);
        Date dateObject = new Date(eq.getTimeInMilliseconds());
        TextView ob3 = (TextView) listItemView.findViewById(R.id.t3);
        String formattedDate = formatDate(dateObject);
        ob3.setText(formattedDate);
        TextView ob4 = (TextView) listItemView.findViewById(R.id.t4);
        String formattedTime = formatTime(dateObject);
        ob4.setText(formattedTime);

        return listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String[] location(String str){
        String [] st;
        if(str.contains("of")){
            st = str.split("of ");
            st[0]+="of";
        } else {
            st = new String[2];
            st[0] ="Near the";
            st[1] =str;
        }
        return st;
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude){
        switch ((int)magnitude){
            case 0 : return  ContextCompat.getColor(getContext(),R.color.magnitude1);
            case 1 :return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2 : return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3 :return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4 : return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5 :return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6 : return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7 :return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8 : return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9 :return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default: return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }
}
