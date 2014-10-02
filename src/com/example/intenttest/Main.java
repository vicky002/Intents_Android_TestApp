package com.example.intenttest;

import java.io.File;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void process(View view) {
		// TODO Auto-generated method stub
	   Intent intent = null,chooser = null;
	   
	   if(view.getId()==R.id.launchmap) {
		   intent = new Intent(android.content.Intent.ACTION_VIEW);
		   intent.setData(Uri.parse("geo:19.076,72.8777"));
		   chooser=Intent.createChooser(intent,"Launch Maps");
		   startActivity(chooser);}
	   if(view.getId()==R.id.launchmarket) {
		   intent = new Intent(android.content.Intent.ACTION_VIEW);
		   intent.setData(Uri.parse("market://details?id=com.instagram.android"));
		   chooser = Intent.createChooser(intent, "Launch Market");
		   startActivity(chooser);
	   }
	   if(view.getId()==R.id.sendemail) {
		   intent = new Intent(Intent.ACTION_SEND);
		   intent.setData(Uri.parse("mailto:"));
		   String[] to = {"tvicky002@gmail.com","blackhat002@gmail.com"};
		   intent.putExtra(Intent.EXTRA_EMAIL,to);
		   intent.putExtra(Intent.EXTRA_SUBJECT,"Hiee Vicky Here send it to me");
		   intent.putExtra(Intent.EXTRA_TEXT,"You know Learning android is fun!!");
		   intent.setType("message/rfc822");
		   chooser = Intent.createChooser(intent, "Send Email");
		   startActivity(chooser);
		 }
	   if(view.getId()==R.id.sendimages) {
		   File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		   String[] listOfPictures = pictures.list();
		   Uri uri = null;
		   ArrayList<Uri> arrayList = new ArrayList<Uri>();
		   for(String picture : listOfPictures) {
			   uri = Uri.parse("file://"+pictures.toString()+"/"+picture);
			   arrayList.add(uri);
			   }
		   intent= new Intent(Intent.ACTION_SEND_MULTIPLE);
		   intent.setType("image/*");
		   intent.putExtra(Intent.EXTRA_STREAM, arrayList);
		   chooser = Intent.createChooser(intent,"Send Multiple images");
		   startActivity(chooser);
	   }
	   

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
