package com.github.htdangkhoa.tikitestjava.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.denzcoskun.imageslider.models.SlideModel;
import com.github.htdangkhoa.tikitestjava.databinding.ActivityMainBinding;
import com.github.htdangkhoa.tikitestjava.model.FlashDealModel;
import com.github.htdangkhoa.tikitestjava.model.QuickLinkModel;
import com.github.htdangkhoa.tikitestjava.core.ObserverResource;
import com.github.htdangkhoa.tikitestjava.ui.widget.QuickLinkView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private MainViewModel mainViewModel;

    FlashDealAdapter adapter = new FlashDealAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        setContentView(binding.getRoot());

        binding.recyclerView.setAdapter(adapter);

        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            // Clear all data.
            binding.imageSlider.setImageList(new ArrayList<>(), null);

            binding.quickLinksContainer.removeAllViews();

            adapter.setNewInstance(new ArrayList<>());

            // Hide views
            binding.imageSlider.setVisibility(View.GONE);

            binding.horizontalView.setVisibility(View.GONE);

            binding.flashDealContainer.setVisibility(View.GONE);

            fetchBannersAndQuickLinks();
        });

        Timber.w("----- CALL API -----");

        onObserveLiveData();

        fetchBannersAndQuickLinks();
    }

    private void fetchBannersAndQuickLinks() {
        mainViewModel.fetchBanners();

        mainViewModel.fetchQuickLinks();
    }

    private void onObserveLiveData() {
        mainViewModel.counting.observe(this, integer -> {
            Timber.w("----- COUNTING ----- %d", integer);

            if (integer.intValue() >= 2) {
                mainViewModel.fetchFlashDeals();
            }
        });

        mainViewModel.banners.observe(this, new ObserverResource<List<SlideModel>>() {
            @Override
            public void onSuccess(@NonNull List<SlideModel> data) {
                if (data != null && !data.isEmpty()) {
                    binding.imageSlider.setVisibility(View.VISIBLE);

                    binding.imageSlider.setImageList(data, null);
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoading(boolean show) {
                binding.progressBar.setVisibility(show ? View.VISIBLE : View.GONE);

                binding.swipeRefreshLayout.setRefreshing(show);
            }
        });

        mainViewModel.quickLinks.observe(this, new ObserverResource<List<List<QuickLinkModel>>>() {
            @Override
            public void onSuccess(@NonNull List<List<QuickLinkModel>> data) {
                if (data != null && !data.isEmpty()) {
                    binding.horizontalView.setVisibility(View.VISIBLE);

                    data.forEach(quickLinkModels -> {
                        binding.quickLinksContainer.addView(renderQuickLinks(quickLinkModels));
                    });
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoading(boolean show) {
                binding.progressBar.setVisibility(show ? View.VISIBLE : View.GONE);

                binding.swipeRefreshLayout.setRefreshing(show);
            }
        });

        mainViewModel.flashDeals.observe(this, new ObserverResource<List<FlashDealModel>>() {
            @Override
            public void onSuccess(@NonNull List<FlashDealModel> data) {
                if (data != null && !data.isEmpty()) {
                    binding.flashDealContainer.setVisibility(View.VISIBLE);

                    adapter.setNewInstance(data);
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoading(boolean show) {
                binding.progressBar.setVisibility(show ? View.VISIBLE : View.GONE);

                binding.swipeRefreshLayout.setRefreshing(show);
            }
        });
    }

    private View renderQuickLinks(List<QuickLinkModel> quickLinkModels) {
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        container.setOrientation(LinearLayout.HORIZONTAL);

        quickLinkModels.forEach(quickLinkModel -> {
            QuickLinkView view = new QuickLinkView(container.getContext(), quickLinkModel);
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            view.setOnQuickLinkClickListener((v, ql) -> {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ql.getUrl()));

                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();

                    Toast.makeText(MainActivity.this, "Please install Tiki app.", Toast.LENGTH_SHORT).show();
                }
            });

            container.addView(view);
        });

        return container;
    }
}