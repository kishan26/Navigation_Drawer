package com.example.n_drawers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
Toolbar toolbar;
DrawerLayout drawerLayout;
NavigationView navigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

toolbar = findViewById(R.id.toolbars);
setSupportActionBar(toolbar);

drawerLayout = findViewById(R.id.activity_main);

		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
		toggle.syncState();

navigationView = findViewById(R.id.nav_view);
navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {

		switch (item.getItemId()) {
			case R.id.camera:
				Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
				break;
			case R.id.comment:
				Toast.makeText(this, "comment", Toast.LENGTH_SHORT).show();
				break;
			case R.id.lock:
				Toast.makeText(this, "power", Toast.LENGTH_SHORT).show();
				break;
			case R.id.search:
				Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
				break;
			case R.id.notification:
				Toast.makeText(this, "notification", Toast.LENGTH_SHORT).show();
				break;
		}
		DrawerLayout drawer = findViewById(R.id.activity_main);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
