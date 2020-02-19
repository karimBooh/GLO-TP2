package ca.ulaval.ima.tp2.ui.internet;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import ca.ulaval.ima.tp2.R;

class NetworkUtil {
    public static String getConnectivityStatusString(Context context, GradientDrawable circle) {
        String status = "Aucune connexion";
        circle.setColor(ContextCompat.getColor(context, R.color.colorCircle));
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            circle.setColor(ContextCompat.getColor(context,R.color.colorGoodCircle));
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "WIFI";
                return status;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "3G/LTE";
                return status;
            }
        }
        return status;
    }
}