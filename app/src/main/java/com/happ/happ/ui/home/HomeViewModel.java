package com.happ.happ.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText, testText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        testText = new MutableLiveData<>();
        mText.setValue("This is home fragmentssss");
        testText.setValue("Welcome User Test Text");

    }

    public LiveData<String> getText() {
        return mText;

    }

    public LiveData<String> getTestText(){

        return testText;
    }


}