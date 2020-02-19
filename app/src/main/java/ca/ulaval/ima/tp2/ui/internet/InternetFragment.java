package ca.ulaval.ima.tp2.ui.internet;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import ca.ulaval.ima.tp2.R;

public class InternetFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_internet, container, false);


        Button statusInternet = root.findViewById(R.id.status_internet);

        Drawable drawable = root.findViewById(R.id.circle).getBackground();

        final GradientDrawable circle = (GradientDrawable) drawable;




        final TextView TextStatus = root.findViewById(R.id.text_status);

        statusInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextStatus.setText(NetworkUtil.getConnectivityStatusString(getContext(), circle));
            }
        });

        return root;
    }
}