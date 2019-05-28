package com.wallet.netdollar.models;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Body;
import retrofit2.http.Field;

public class RegisterUser {

    @SerializedName("username") String username;
    @SerializedName("password") String password;
    @SerializedName("accountId") String accountId;
    @SerializedName("publicKey") String publicKey;
    @SerializedName("keychainData") String keychainData;
    @SerializedName("mainData") String mainData;
    @SerializedName("phoneAsLogin") boolean phoneAsLogin;
    @SerializedName("kdfParams") KdfParams kdfParams;

    class KdfParams {

        @SerializedName("algorithm")
        String algorithm = "scrypt";

        @SerializedName("bits")
        int bits = 256;

        @SerializedName("n")
        int n = 2;

        @SerializedName("r")
        int r = 8;

        @SerializedName("p")
        int p = 1;

        @SerializedName("passwordHashAlgorithm ")
        String passwordHashAlgorithm = "sha256";

        @SerializedName("hashRounds")
        int hashRounds = (int) Math.pow(2, 19);

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public int getBits() {
            return bits;
        }

        public void setBits(int bits) {
            this.bits = bits;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public String getPasswordHashAlgorithm() {
            return passwordHashAlgorithm;
        }

        public void setPasswordHashAlgorithm(String passwordHashAlgorithm) {
            this.passwordHashAlgorithm = passwordHashAlgorithm;
        }

        public int getHashRounds() {
            return hashRounds;
        }

        public void setHashRounds(int hashRounds) {
            this.hashRounds = hashRounds;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getKeychainData() {
        return keychainData;
    }

    public void setKeychainData(String keychainData) {
        this.keychainData = keychainData;
    }

    public String getMainData() {
        return mainData;
    }

    public void setMainData(String mainData) {
        this.mainData = mainData;
    }

    public boolean isPhoneAsLogin() {
        return phoneAsLogin;
    }

    public void setPhoneAsLogin(boolean phoneAsLogin) {
        this.phoneAsLogin = phoneAsLogin;
    }

    public KdfParams getKdfParams() {
        return kdfParams;
    }

    public void setKdfParams(KdfParams kdfParams) {
        this.kdfParams = kdfParams;
    }
}
