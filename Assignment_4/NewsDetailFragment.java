package com.example.newsapp;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class NewsDetailFragment extends Fragment {

    TextView tvTitle, tvDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvDescription = view.findViewById(R.id.tvDescription);

        // Receive data from Activity
        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String description = getArguments().getString("desc");

            tvTitle.setText(title);
            tvDescription.setText(description);
        }

        return view;
    }
}