package com.sanbot.librarydemod.control;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanbot.librarydemod.HandControlActivity;
import com.sanbot.librarydemod.R;
import com.sanbot.opensdk.function.beans.handmotion.CombinationHandMotion;

/**
 * BothHandFragment.java
 * "Functional Description"
 * <p>
 * Created by Cris_Peng on 2018/11/7
 * Copyright (c) 2016 QihanCloud, Inc. All Rights Reserved.
 */
public class BothHandFragment extends Fragment implements View.OnClickListener {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_both, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initData();
    }

    private void initView() {
        view.findViewById(R.id.hand_1).setOnClickListener(this);
        view.findViewById(R.id.hand_3).setOnClickListener(this);
        view.findViewById(R.id.hand_4).setOnClickListener(this);
        view.findViewById(R.id.hand_6).setOnClickListener(this);
        view.findViewById(R.id.hand_7).setOnClickListener(this);
        view.findViewById(R.id.hand_12).setOnClickListener(this);
        view.findViewById(R.id.hand_17).setOnClickListener(this);
        view.findViewById(R.id.hand_19).setOnClickListener(this);
        view.findViewById(R.id.hand_20).setOnClickListener(this);
        view.findViewById(R.id.hand_21).setOnClickListener(this);
        view.findViewById(R.id.hand_26).setOnClickListener(this);
        view.findViewById(R.id.hand_27).setOnClickListener(this);
        view.findViewById(R.id.hand_29).setOnClickListener(this);
        view.findViewById(R.id.hand_30).setOnClickListener(this);
    }

    private HandControlActivity activity;

    private void initData() {
        activity = (HandControlActivity) getActivity();
    }

    int whichHand=3;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hand_1:
                activity.sendHandCommand(whichHand, 1);
                break;
            case R.id.hand_3:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_STRETCH_SIDE);
                break;
            case R.id.hand_4:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_STRETCH_FRONT);
                break;
            case R.id.hand_6:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_HAND_FORWARD1);
                break;
            case R.id.hand_7:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_RAISE_HAND);
                break;
            case R.id.hand_12:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_DEFEND);
                break;
            case R.id.hand_17:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_DROP_HAND3);
                break;
            case R.id.hand_19:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_STRETCH_FLAT_NARROW);
                break;
            case R.id.hand_20:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_STRETCH_HIGH_WIDE);
                break;
            case R.id.hand_21:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_STRETCH_FLAT_WIDE);
                break;
            case R.id.hand_26:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_CHEER);
                break;
            case R.id.hand_27:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_HAND_FORWARD2);
                break;
            case R.id.hand_29:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_MUSCLE);
                break;
            case R.id.hand_30:
                activity.sendHandCommand(whichHand, CombinationHandMotion.MOTION_HAND_FORWARD3);
                break;
        }
    }

}
