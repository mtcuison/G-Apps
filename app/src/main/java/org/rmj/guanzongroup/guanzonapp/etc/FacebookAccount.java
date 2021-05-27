package org.rmj.guanzongroup.guanzonapp.etc;

import android.content.Context;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class FacebookAccount {

    private Context mContext;
    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
    private onCallBackResultListener onCallBackResultListener;

    public interface onCallBackResultListener{
        void onSuccessResult();
        void onFailedResult(String message);
    }

    public FacebookAccount(Context context){
        this.mContext = context;
    }

    public void setCallBackParameters(LoginButton loginButton, CallbackManager callbackManager){
        this.mLoginButton = loginButton;
        this.mCallbackManager = callbackManager;
    }

    public void registerCallback(onCallBackResultListener listener){
        this.onCallBackResultListener = listener;
        mLoginButton.setPermissions(Arrays.asList("email"));
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public void LoadUserProfile(AccessToken accessToken){
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try{
                    String id = object.getString("id");
                    String firstname = object.getString("first_name");
                    String lastname = object.getString("last_name");
                    String middle_name = object.getString("middle_name");
                    String email = object.getString("email");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameter = new Bundle();
        parameter.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameter);
        request.executeAsync();
    }
}
