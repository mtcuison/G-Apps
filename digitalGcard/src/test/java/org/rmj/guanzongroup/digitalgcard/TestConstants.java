package org.rmj.guanzongroup.digitalgcard;

import android.app.Application;
import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCartItems;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;

public class TestConstants{
    public static final Application APPLICATION = ApplicationProvider.getApplicationContext();
    public static final GcardCredentials GCARD_CREDENTIALS = new GcardCredentials("09123456789", "01/01/2022");
    public static final CartItem CART_ITEM = new CartItem("M00122132122", "01", 2, 500.0);
    public static final GcardCartItems GCARD_CART_ITEMS = new GcardCartItems();
    public static final String FAKE_DATE = "01/01/2022";
}
