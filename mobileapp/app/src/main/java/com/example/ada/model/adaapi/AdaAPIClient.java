package com.example.ada.model.adaapi;

import android.content.Context;

import com.example.ada.R;
import com.example.ada.model.APIClient;

public class AdaAPIClient {

    private AdaApiInterface apiInterface;

    public AdaAPIClient(Context context) {
        apiInterface = APIClient.getClient(context.getResources().getString(R.string.ada_api_url))
                .create(AdaApiInterface.class);
    }
}
