package com.github.htdangkhoa.tikitestjava.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.github.htdangkhoa.tikitestjava.R;
import com.github.htdangkhoa.tikitestjava.model.QuickLinkModel;
import com.squareup.picasso.Picasso;

public class QuickLinkView extends LinearLayout {
    private QuickLinkModel quickLinkModel;

    ImageView imgQuickLink;

    TextView txtQuickLinkTitle;

    public QuickLinkView(Context context, QuickLinkModel quickLinkModel) {
        super(context);
        this.quickLinkModel = quickLinkModel;

        LayoutInflater.from(context).inflate(
                R.layout.item_quick_link, this, true);

        imgQuickLink = findViewById(R.id.imgQuickLink);
        txtQuickLinkTitle = findViewById(R.id.txtQuickLinkTitle);

        Picasso.get().load(quickLinkModel.getImageUrl()).into(imgQuickLink);

        txtQuickLinkTitle.setText(quickLinkModel.getTitle());
//
//        setOnClickListener(v -> {
////            onQuickLinkClickListener?.invoke(it, quickLinkModel)
//        });
    }

    public void setOnQuickLinkClickListener(OnQuickLinkClickListener onQuickLinkClickListener) {
        setOnClickListener(v -> {
            if (onQuickLinkClickListener != null) {
                onQuickLinkClickListener.onClick(v, quickLinkModel);
            }
        });
    }

    public interface OnQuickLinkClickListener {
        void onClick(View v, QuickLinkModel quickLinkModel);
    }
}
