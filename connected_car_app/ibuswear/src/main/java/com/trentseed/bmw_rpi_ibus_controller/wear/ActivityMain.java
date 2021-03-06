package com.trentseed.bmw_rpi_ibus_controller.wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class ActivityMain extends Activity {

	/* track parent page id of first column of options (i.e. Driver Window, Locks, etc.) */
	public static int parent_page_id;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // disable action bar for swipe dismissal support
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
        
        // inflate the 'rectangle' or 'round' view depending on device screen
        final WatchViewStub stub = findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {
				// set adapter for 2D Picker pattern
				final GridViewPager pager = findViewById(R.id.pager);
		        pager.setAdapter(
                    new IBUSGridPagerAdapter(ActivityMain.this, getFragmentManager())
                );
			}
		});
    }

    /**
     * Display toast message for Toast.LENGTH_SHORT period. Uses the fragments
     * activity for context.
     * @param message content to display in toast message
     */
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    
}
