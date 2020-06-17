package com.doitandroid.mysingleton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InitializationOnDemandHolderIdiom {

    public ArrayList<String> object;
    public ArrayList<UserItem> userItemArrayList;


    private InitializationOnDemandHolderIdiom () {
        object = new ArrayList<>();
        userItemArrayList = new ArrayList<>();
    }
    private static class Singleton {
        private static final InitializationOnDemandHolderIdiom instance = new InitializationOnDemandHolderIdiom();
    }

    public static InitializationOnDemandHolderIdiom getInstance () {
        System.out.println("create instance");
        return Singleton.instance;
    }
}