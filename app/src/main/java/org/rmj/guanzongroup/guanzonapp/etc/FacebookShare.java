package org.rmj.guanzongroup.guanzonapp.etc;

import android.net.Uri;

import androidx.fragment.app.Fragment;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class FacebookShare {

    private Fragment mFragment;
    private ShareDialog mShareDialog;

    public FacebookShare(Fragment fragment){
        this.mFragment = fragment;
        this.mShareDialog = new ShareDialog(mFragment);
    }

    public void shareLink(String PromoLink, String Caption){
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(PromoLink))
                .setQuote(Caption)
                .build();
        mShareDialog.show(content, ShareDialog.Mode.AUTOMATIC);
    }
}
