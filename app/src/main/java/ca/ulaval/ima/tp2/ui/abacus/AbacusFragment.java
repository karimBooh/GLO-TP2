package ca.ulaval.ima.tp2.ui.abacus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ca.ulaval.ima.tp2.R;

public class AbacusFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_abacus, container, false);

        final int[] x = {1};
        final int[] y = {2};
        final int[] z = {2};

        SeekBar value1 = root.findViewById(R.id.value1);
        SeekBar value2 = root.findViewById(R.id.value2);
        final SeekBar result = root.findViewById(R.id.result);
        result.setEnabled(false);
        final TextView value1View = root.findViewById(R.id.value1View);
        final TextView value2View = root.findViewById(R.id.value2View);
        final TextView resultView = root.findViewById(R.id.resultView);

        value1.setMax(8);
        value1.setProgress(0);
        value2.setMax(10);
        value1.setProgress(0);
        result.setProgress(2);
        value1View.setText(String.format("%d", x[0]));
        value2View.setText(String.format("%d", y[0]));
        resultView.setText(String.format("%d", z[0]));


        value1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                x[0] = i + 1;
                z[0] = x[0] * y[0];
                result.setProgress(z[0]);
                value1View.setText(String.format("%d", x[0]));
                resultView.setText(String.format("%d", z[0]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        value2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                y[0] = i + 2;
                z[0] = x[0] * y[0];
                result.setProgress(z[0]);
                value2View.setText(String.format("%d", y[0]));
                resultView.setText(String.format("%d", z[0]));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        return root;
    }
}