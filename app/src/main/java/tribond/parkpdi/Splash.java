package tribond.parkpdi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splash extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        image = (ImageView) findViewById(R.id.iv_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("Login Me", "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(Splash.this, image, getString(R.string.activity_image_trans));
                    startActivity(intent, options.toBundle());

                } else {
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);

    }


}
