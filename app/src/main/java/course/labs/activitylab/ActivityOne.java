package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		private TextView onCreate;
		private TextView onStart;
		private TextView onResume;
		private TextView onPause;
		private TextView onStop;
		private TextView onRestart;
		private TextView onDestroy;

		private int createCount=0;
		private int startCount=0;
		private int resumeCount=0;
		private int pauseCount=0;
		private int stopCount=0;
		private int restartCount=0;
		private int destroyCount=0;

		private String onCreateStr;
		private String onStartStr;
		private String onResumeStr;
		private String onPauseStr;
		private String onStopStr;
		private String onRestartStr;
		private String onDestroyStr;
		// lifecycle counts
		//TODO:
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			//Log cat print out
			Log.i(TAG, "onCreate called");

			//Get values from last session
			SharedPreferences prefs = getPreferences(MODE_PRIVATE);
			createCount = prefs.getInt("createCount", 0);
			startCount = prefs.getInt("startCount", 0);
			resumeCount = prefs.getInt("resumeCount", 0);
			pauseCount = prefs.getInt("pauseCount", 0);
			stopCount = prefs.getInt("stopCount", 0);
			restartCount = prefs.getInt("restartCount", 0);
			destroyCount = prefs.getInt("destroyCount", 0);

			onCreateStr = getResources().getString(R.string.onCreate);
			onStartStr = getResources().getString(R.string.onStart);
			onResumeStr = getResources().getString(R.string.onResume);
			onPauseStr = getResources().getString(R.string.onPause);
			onStopStr = getResources().getString(R.string.onStop);
			onRestartStr = getResources().getString(R.string.onRestart);
			onDestroyStr = getResources().getString(R.string.onDestroy);

			onCreate = (TextView) findViewById(R.id.create);
			onStart = (TextView) findViewById(R.id.start);
			onResume = (TextView) findViewById(R.id.resume);
			onPause = (TextView) findViewById(R.id.pause);
			onStop = (TextView) findViewById(R.id.stop);
			onRestart = (TextView) findViewById(R.id.restart);
			onDestroy = (TextView) findViewById(R.id.destroy);

			createCount++;
			onCreate.setText(onCreateStr + createCount);

		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}

		// lifecycle callback overrides

		@Override
		public void onStart(){
			super.onStart();

			//Log cat print out
			Log.i(TAG, "onStart called");

			startCount++;
			onStart.setText(onStartStr + startCount);
		}

	    // TODO: implement 5 missing lifecycle callback methods

		public void onResume() {
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");

			resumeCount++;
			onResume.setText(onRestartStr + resumeCount);
		}

		public void onPause(){
			super.onPause();

			//Log cat print out
			Log.i(TAG, "onPause called");

			pauseCount++;
			onPause.setText(onPauseStr + pauseCount);
		}

		public void onStop(){
			super.onStop();

			//Log cat print out
			Log.i(TAG, "onStop called");

			stopCount++;
			onStop.setText(onStopStr + stopCount);

			SharedPreferences prefs = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();

			editor.putInt("createCount", createCount);
			editor.putInt("startCount", startCount);
			editor.putInt("resumeCount", resumeCount);
			editor.putInt("pauseCount", pauseCount);
			editor.putInt("stopCount", stopCount);
			editor.putInt("restartCount", restartCount);
			editor.putInt("destroyCount", destroyCount);

			editor.commit();
		}

		public void onRestart(){
			super.onRestart();

			//Log cat print out
			Log.i(TAG, "onRestart called");

			restartCount++;
			onRestart.setText(onRestartStr + restartCount);
		}

		public void onDestroy(){
			super.onDestroy();

			//Log cat print out
			Log.i(TAG, "onDestroy called");

			destroyCount++;
			onDestroy.setText(onDestroyStr + destroyCount);
		}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			super.onSaveInstanceState(savedInstanceState);
			savedInstanceState.putInt("createCount", createCount);
			savedInstanceState.putInt("startCount", startCount);
			savedInstanceState.putInt("resumeCount", resumeCount);
			savedInstanceState.putInt("pauseCount", pauseCount);
			savedInstanceState.putInt("stopCount", stopCount);
			savedInstanceState.putInt("restartCount", restartCount);
			savedInstanceState.putInt("destroyCount", destroyCount);
		}

		@Override
		public void onRestoreInstanceState(Bundle savedInstanceState){
			super.onRestoreInstanceState(savedInstanceState);

			createCount = savedInstanceState.getInt("createCount");
			startCount = savedInstanceState.getInt("startCount");
			resumeCount = savedInstanceState.getInt("resumeCount");
			pauseCount = savedInstanceState.getInt("pauseCount");
			stopCount = savedInstanceState.getInt("stopCount");
			restartCount = savedInstanceState.getInt("restartCount");
			destroyCount = savedInstanceState.getInt("destroyCount");

			onCreate.setText(onCreateStr + createCount);
			onStart.setText(onStartStr + startCount);
			onResume.setText(onRestartStr + resumeCount);
			onPause.setText(onPauseStr + pauseCount);
			onStop.setText(onStopStr + stopCount);
			onRestart.setText(onRestartStr + restartCount);
			onDestroy.setText(onDestroyStr + destroyCount);

		}

		public void launchActivityTwo(View view) {
			//TODO:
			// This function launches Activity Two.
			// Hint: use Context’s startActivity() method.
			Intent myIntent = new Intent(ActivityOne.this, ActivityTwo.class);
			ActivityOne.this.startActivity(myIntent);
		}

		public void clearCounterData(View view) {
			Log.i(TAG, "clearCounterData called");

			SharedPreferences prefs = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();

			editor.clear();

			editor.commit();
		}
}
