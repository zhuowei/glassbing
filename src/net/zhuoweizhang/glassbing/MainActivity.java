package net.zhuoweizhang.glassbing;

import java.net.*;

import android.app.Activity;
import android.os.Bundle;
import android.content.*;
import android.net.*;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//grab the voice recognition terms
		Intent intent = getIntent();
		String searchTerm = intent.getStringExtra("recognitionResult");
		Uri searchUri;
		try {
			searchUri = Uri.parse("http://m.bing.com/search?q=" + URLEncoder.encode(searchTerm, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			finish();
			return;
		}
		Intent browseIntent = new Intent(Intent.ACTION_VIEW, searchUri);
		startActivity(browseIntent);
		finish();
	}
}
