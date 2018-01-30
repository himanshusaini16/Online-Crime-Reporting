package com.example.himanshu.onlinecrimereporting.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.himanshu.onlinecrimereporting.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class View_Criminals extends Fragment {

    View v;

    GridView androidGridView;

    Integer[] imageIDs = {
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image, R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,
            R.drawable.criminal_image,R.drawable.criminal_image,R.drawable.criminal_image,


    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_view__criminals, container, false);

        androidGridView = (GridView)v.findViewById(R.id.gridview_android_example);
        androidGridView.setAdapter(new ImageAdapterGridView(getActivity()));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Toast.makeText(getActivity(), "Criminal " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }


    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(280, 280));
                mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                mImageView.setPadding(2, 2, 2, 10);

            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
}
