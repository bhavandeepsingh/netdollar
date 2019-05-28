package com.wallet.netdollar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wallet.netdollar.Api.RetrofitClient;
import com.wallet.netdollar.R;
import com.wallet.netdollar.models.BaseModel;
import com.wallet.netdollar.models.RegisterUser;

import org.stellar.sdk.KeyPair;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitle=findViewById(R.id.txttitle);
        txtTitle.setText(R.string.titre_newcompte);
        findViewById(R.id.btn_creer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register(){
        KeyPair keyPair = KeyPair.random();

        RegisterUser registerUser = new RegisterUser();
        registerUser.setUsername("8146358363");
        registerUser.setPassword("Demo1234");
        registerUser.setPublicKey(keyPair.getAccountId());
        registerUser.setAccountId(keyPair.getAccountId());
        registerUser.setKeychainData(String.valueOf(keyPair.getSecretSeed()));
        registerUser.setKdfParams(registerUser.getKdfParams());

        RetrofitClient.getInstance().getApi().register(registerUser).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                Log.d("here", response.toString());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Log.d("here", t.getMessage());
            }
        });
    }
}
