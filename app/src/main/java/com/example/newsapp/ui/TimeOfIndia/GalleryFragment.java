package com.example.newsapp.ui.TimeOfIndia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.newsapp.R;
import com.example.newsapp.WebViewControl;
import com.example.newsapp.databinding.FragmentGalleryBinding;
import com.example.newsapp.ui.BBC.HomeViewModel;

public class GalleryFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize ViewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Load the BBC website
        WebView webView = root.findViewById(R.id.webViewBBC);
        webView.loadUrl("https://timesofindia.indiatimes.com/");
        webView.setWebViewClient(new WebViewControl());

        // Navigate to another fragment on button click
        Button btn = root.findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.foxnews);
        });

        return root;
    }
}
