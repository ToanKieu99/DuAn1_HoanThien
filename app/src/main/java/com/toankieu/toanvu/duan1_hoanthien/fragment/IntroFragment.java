package com.toankieu.toanvu.duan1_hoanthien.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.toankieu.toanvu.duan1_hoanthien.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IntroFragment extends Fragment {
    private ViewFlipper viewFlipper;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFlipper = view.findViewById(R.id.viewFlipper);
        ActionViewFlipper();

    }

    private void ActionViewFlipper() {
        ArrayList<Integer> mangquangcao = new ArrayList<>();
        mangquangcao.add(R.drawable.gioithieu1);
        mangquangcao.add(R.drawable.gioithieu2);
        mangquangcao.add(R.drawable.gioithieu);
        mangquangcao.add(R.drawable.gioithieu4);
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);


        Animation animation_silde_in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_silde_in);
        viewFlipper.setOutAnimation(animation_slide_out);


    }
}
