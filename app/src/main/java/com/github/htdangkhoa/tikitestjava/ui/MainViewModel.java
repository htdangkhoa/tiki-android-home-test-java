package com.github.htdangkhoa.tikitestjava.ui;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.denzcoskun.imageslider.models.SlideModel;
import com.github.htdangkhoa.tikitestjava.model.BannerModel;
import com.github.htdangkhoa.tikitestjava.model.FlashDealModel;
import com.github.htdangkhoa.tikitestjava.model.QuickLinkModel;
import com.github.htdangkhoa.tikitestjava.model.ResponseModel;
import com.github.htdangkhoa.tikitestjava.network.NetworkCallback;
import com.github.htdangkhoa.tikitestjava.network.Network;
import com.github.htdangkhoa.tikitestjava.core.Resource;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainViewModel extends ViewModel {
    private Network network = new Network();

    Type bannerType = new TypeToken<ResponseModel<List<BannerModel>>>(){}.getType();

    Type quickLinkType = new TypeToken<ResponseModel<List<List<QuickLinkModel>>>>(){}.getType();

    Type flashDealType = new TypeToken<ResponseModel<List<FlashDealModel>>>(){}.getType();

    MutableLiveData<Integer> counting = new MutableLiveData<>();

    MutableLiveData<Resource<List<SlideModel>>> banners = new MutableLiveData<>();

    MutableLiveData<Resource<List<List<QuickLinkModel>>>> quickLinks = new MutableLiveData<>();

    MutableLiveData<Resource<List<FlashDealModel>>> flashDeals = new MutableLiveData<>();

    public MainViewModel() {
        counting.postValue(0);

        banners.postValue(Resource.nothing());

        quickLinks.postValue(Resource.nothing());

        flashDeals.postValue(Resource.nothing());
    }

    public void fetchBanners() {
        network.execute(
                "v2/home/banners/v2",
                bannerType,
                new NetworkCallback<List<BannerModel>>() {
                    @Override
                    public void onSuccess(ResponseModel<List<BannerModel>> res) {
                        counting.postValue(counting.getValue() + 1);

                        List<SlideModel> models = res.getData()
                                .stream()
                                .map(bannerModel -> {
                                    if (!TextUtils.isEmpty(bannerModel.getMobileUrl())) {
                                        return new SlideModel(
                                                bannerModel.getMobileUrl(),
                                                null
                                        );
                                    }

                                    return null;
                                })
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());

                        banners.postValue(Resource.success(models));
                    }

                    @Override
                    public void onError(Exception e) {
                        counting.postValue(counting.getValue() + 1);

                        banners.postValue(Resource.error(e.getMessage()));
                    }

                    @Override
                    public void onLoading(boolean isLoading) {
                        banners.postValue(isLoading ? Resource.loading() : Resource.nothing());
                    }
                });
    }

    public void fetchQuickLinks() {
        network.execute(
                "shopping/v2/widgets/quick_link",
                quickLinkType,
                new NetworkCallback<List<List<QuickLinkModel>>>() {
                    @Override
                    public void onSuccess(ResponseModel<List<List<QuickLinkModel>>> res) {
                        counting.postValue(counting.getValue() + 1);

                        quickLinks.postValue(Resource.success(res.getData()));
                    }

                    @Override
                    public void onError(Exception e) {
                        counting.postValue(counting.getValue() + 1);

                        quickLinks.postValue(Resource.error(e.getMessage()));
                    }

                    @Override
                    public void onLoading(boolean isLoading) {
                        quickLinks.postValue(isLoading ? Resource.loading() : Resource.nothing());
                    }
                });
    }

    public void fetchFlashDeals() {
        network.execute(
                "v2/widget/deals/hot",
                flashDealType,
                new NetworkCallback<List<FlashDealModel>>() {
                    @Override
                    public void onSuccess(ResponseModel<List<FlashDealModel>> res) {
                        flashDeals.postValue(Resource.success(res.getData()));
                    }

                    @Override
                    public void onError(Exception e) {
                        flashDeals.postValue(Resource.error(e.getMessage()));
                    }

                    @Override
                    public void onLoading(boolean isLoading) {
                        flashDeals.postValue(isLoading ? Resource.loading() : Resource.nothing());
                    }
                }
        );
    }
}
