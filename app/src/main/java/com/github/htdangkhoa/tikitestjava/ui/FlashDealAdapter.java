package com.github.htdangkhoa.tikitestjava.ui;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.github.htdangkhoa.tikitestjava.R;
import com.github.htdangkhoa.tikitestjava.model.FlashDealModel;
import com.github.htdangkhoa.tikitestjava.util.NumberUtil;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class FlashDealAdapter extends BaseQuickAdapter<FlashDealModel, BaseViewHolder> {
    public FlashDealAdapter() {
        super(R.layout.item_flash_deal);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, FlashDealModel flashDealModel) {
        Picasso.get()
                .load(flashDealModel.getProduct().getThumbnailUrl())
                .into((ImageView) holder.getView(R.id.imgProduct));

        holder.setText(R.id.txtPrice, NumberUtil.formatPrice(flashDealModel.getProduct().getPrice()));

        holder.setText(R.id.txtBadgeDiscount, String.format("%d ", flashDealModel.getDiscountPercent()) + "%");
    }
}
