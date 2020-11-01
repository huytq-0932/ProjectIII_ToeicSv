package hangbt.hust.projectiii_toeicsv.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hangbt.hust.projectiii_toeicsv.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingTestFragment extends Fragment {


    private ImageView imageViewBack;
    public SettingTestFragment() {
        // Required empty public constructor
    }


    public static SettingTestFragment newInstance() {
        SettingTestFragment fragment = new SettingTestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageViewBack = view.findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(view1 -> {
            getActivity().onBackPressed();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting_test, container, false);
    }
}