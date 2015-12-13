package com.example.aravind.cardviewdemo;

/**
 * Created by aravind on 13-12-2015.
 */
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Edwin on 18/01/2015.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<NatureItem> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<NatureItem>();
        NatureItem nature = new NatureItem();
        nature.setName("The Great Barrier Reef");
        nature.setDes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
        nature.setThumbnail(R.drawable.bat);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Grand Canyon");
        nature.setDes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                "ut labore et dolore magna aliqua.");
        nature.setThumbnail(R.drawable.cap);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Baltoro Glacier");
        nature.setDes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis.");
        nature.setThumbnail(R.drawable.bat);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Iguazu Falls");
        nature.setDes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
        nature.setThumbnail(R.drawable.cap);
        mItems.add(nature);


        nature = new NatureItem();
        nature.setName("Aurora Borealis");
        nature.setDes("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.");
        nature.setThumbnail(R.drawable.bat);
        mItems.add(nature);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        NatureItem nature = mItems.get(i);
        viewHolder.tvNature.setText(nature.getName());
        viewHolder.tvDesNature.setText(nature.getDes());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView imgThumbnail;
        public TextView tvNature;
        public TextView tvDesNature;
        public View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvNature = (TextView)itemView.findViewById(R.id.tv_nature);
            tvDesNature = (TextView)itemView.findViewById(R.id.tv_des_nature);
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    Intent intent = new Intent(v.getContext(),ResultView.class);
                    intent.putExtra("tvNature",tvNature.getText().toString());
                    intent.putExtra("tvDesNature", tvDesNature.getText().toString());
                    Log.d("Look the value", tvNature.getText().toString());
                    v.getContext().startActivity(intent);

                }
            });


        }
    }
}