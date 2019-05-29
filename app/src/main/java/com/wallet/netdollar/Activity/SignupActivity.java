package com.wallet.netdollar.Activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wallet.netdollar.Api.RetrofitClient;
import com.wallet.netdollar.Helpers.SaltHelper;
import com.wallet.netdollar.R;
import com.wallet.netdollar.models.BaseModel;
import com.wallet.netdollar.models.LoginResponse;
import com.wallet.netdollar.models.RegisterUser;

import org.stellar.sdk.Account;
import org.stellar.sdk.CreateAccountOperation;
import org.stellar.sdk.CreateAccountOperation.Builder;
import org.stellar.sdk.KeyPair;
import org.stellar.sdk.Server;
import org.stellar.sdk.Transaction;
import org.stellar.sdk.requests.EventListener;
import org.stellar.sdk.responses.AccountResponse;

import java.io.IOException;
import java.security.Key;

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
//                getParams();
            }
        });
        new LongOperation().execute("");
    }






    public void register(){
        KeyPair keyPair = KeyPair.random();

        RegisterUser registerUser = new RegisterUser();
        registerUser.setUsername("8146358363");
        registerUser.setPassword("Demo1234");
        registerUser.setPublicKey(keyPair.getPublicKey());
//        registerUser.setWalletId(Base64.encode(keyPair.getAccountId(), Base64.);
//        registerUser.setAccountId(keyPair.getAccountId());
        registerUser.setKeychainData(String.valueOf(keyPair.getSecretSeed()));
        registerUser.setKdfParams(registerUser.getKdfParams());
        registerUser.setSalt(SaltHelper.getNextSalt());


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

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            KeyPair keyPair = KeyPair.random();

            try {
                final Server server = new Server("http://blockchain.netdollar.us");

//                server.accounts().stream(new EventListener<AccountResponse>() {
//                    @Override
//                    public void onEvent(AccountResponse accountResponse) {
//                        Log.d("EVENT", accountResponse.getInflationDestination());
//                    }
//                });
//            server.operations().forAccount(keyPair).
                AccountResponse accountResponse = server.accounts().cursor("0.9855420897486635").account(keyPair);
                Log.d("ASD", "here");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("here", e.getLocalizedMessage());

            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
//            TextView txt = (TextView) findViewById(R.id.output);
//            txt.setText("Executed"); // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
