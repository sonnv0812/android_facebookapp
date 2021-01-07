package com.example.facebookapp.data.repository.home.menu;

import com.example.facebookapp.data.base.OnDataLoadedListener;
import com.example.facebookapp.data.model.BaseResponse;
import com.example.facebookapp.network.ApiService;
import com.example.facebookapp.network.ResponseCode;
import com.example.facebookapp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuRepositoryImpl implements MenuRepository {

    private final ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

    @Override
    public void logoutApi(String token, OnDataLoadedListener<String> callback) {
        apiService.logout(token).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful())
                    switch (response.body().getCode()) {
                        case ResponseCode.OK:
                            callback.onSuccess("Logout Successful");
                            break;
                        default:
                            break;
                    }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }
}
