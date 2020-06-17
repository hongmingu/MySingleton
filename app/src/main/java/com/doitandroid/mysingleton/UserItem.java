package com.doitandroid.mysingleton;

import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class UserItem implements Serializable {

    private static final String TAG = "UserItem";

    String username, userID, fullName, userPhoto;

    boolean isFollowed, isFullyUpdated;

    ArrayList<UserItem> relatedFollowingList, relatedFollowerList;

    int usedStack;


    ArrayList<OnUserItemChangedCallback> onUserItemChangedCallbackArrayList;

    @SuppressWarnings("serial")
    public interface OnUserItemChangedCallback extends Serializable {
        void onItemChanged(UserItem userItem);
    }

    public void setOnUserItemChangedListener(OnUserItemChangedCallback onUserItemChangedCallback){
        Log.d(TAG, "setOnUserItemChangedListener");

        onUserItemChangedCallbackArrayList.add(onUserItemChangedCallback);

    }

    public UserItem(String username,
                    String userID,
                    String fullName,
                    String userPhoto,
                    ArrayList<UserItem> relatedFollowerList,
                    ArrayList<UserItem> relatedFollowingList,
                    boolean isFullyUpdated,
                    boolean isFollowed,
                    boolean followUpdate) {

        this.username = username;
        this.userID = userID;
        this.fullName = fullName;
        this.userPhoto = userPhoto;

        this.isFullyUpdated = isFullyUpdated;

        this.relatedFollowerList = relatedFollowerList;
        this.relatedFollowingList = relatedFollowingList;
        this.isFollowed = isFollowed;

        this.onUserItemChangedCallbackArrayList = new ArrayList<>();

        this.onUserItemChangedCallbackArrayList.add(new OnUserItemChangedCallback() {
            @Override
            public void onItemChanged(UserItem userItem) {

            }
        });

        usedStack = 0;

    }
}
