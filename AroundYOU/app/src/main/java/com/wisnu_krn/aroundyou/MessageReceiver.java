package com.wisnu_krn.aroundyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;


public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NearbyMessage nearbyMessage = intent.getParcelableExtra(MessageFragment.EXTRA_MESSAGE);
        EventBus.getDefault().post(nearbyMessage);
    }
}