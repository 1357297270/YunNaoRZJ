package com.dayu.recycler;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Shinelon on 2018/3/22.
 */

public class Levelone implements MultiItemEntity {

    public String friendName;
    public int friendSculpture;


    public Levelone(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public int getItemType() {
        return Adapter.TYPE_LEVEL_1;
    }
}
