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
 * Use the {@link TestResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestResultFragment extends Fragment {

    private ImageView imageViewBack;

    public static TestResultFragment newInstance() {
        TestResultFragment fragment = new TestResultFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageViewBack = view.findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_result, container, false);
    }
}