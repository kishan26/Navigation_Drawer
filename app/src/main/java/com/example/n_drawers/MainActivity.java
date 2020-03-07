package com.example.n_drawers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
Toolbar toolbar;
DrawerLayout drawerLayout;
NavigationView navigationView;

	ArrayList<gettersetter> arrayList=new ArrayList<>();
	RecyclerView recyclerView;
	int img[]={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h,R.mipmap.i,R.mipmap.j,R.mipmap.k,R.mipmap.l,R.mipmap.m,R.mipmap.n,R.mipmap.o,R.mipmap.p,R.mipmap.q,R.mipmap.s,R.mipmap.t,R.mipmap.u,R.mipmap.v,R.mipmap.w,R.mipmap.x,R.mipmap.y,R.mipmap.z,R.mipmap.ab,R.mipmap.ac,R.mipmap.ad,R.mipmap.ae,R.mipmap.af,R.mipmap.ag,R.mipmap.ah,R.mipmap.ai,R.mipmap.aj};
	String name[]={"1234ry","234fgfd","2q3fgd","rew23","hdfd","sfsdf","4kjxds","dfug7","dfd8d","kdjf80","sfhsdf8","dsjb7","sfds4","sd98","dfdn4","sdks7","sdfnk7","sdg8","sdhg8","fldsf7","fdds9","lkd7","kfjb","fdgf","dgkje","kdjf","fkjdhf","kfh44","jhdf5","dlfhi5","dfkdgf","fdfkgh","dh4df","dfhsf4"};

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

recyclerView = findViewById(R.id.rev);

		RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
		recyclerView.setLayoutManager(layoutManager);

		for (int i=0;i<img.length;i++){
			gettersetter gettersetter=new gettersetter(img[i],name[i]);
			arrayList.add(gettersetter);
		}

		RVAdapter adapter=new RVAdapter(MainActivity.this,arrayList);                             // adapter set on recycleview
		recyclerView.setAdapter(adapter);
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

	class RVAdapter extends RecyclerView.Adapter<RVAdapter.myclass>{
		Context context;
		ArrayList<gettersetter> arrayList;

		public RVAdapter(Context context, ArrayList<gettersetter> arrayList) {
			this.context = context;
			this.arrayList = arrayList;
		}

		@NonNull
		@Override
		public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			View view= LayoutInflater.from(context).inflate(R.layout.list_raw,parent,false);
			return new myclass(view);
		}

		@Override
		public void onBindViewHolder(@NonNull myclass holder, int position) {
			gettersetter gettersetter=arrayList.get(position);
			holder.imageView.setImageResource(gettersetter.getImage());
			holder.textView.setText(gettersetter.getName());
		}

		@Override
		public int getItemCount() {
			return arrayList.size();
		}

		public class myclass extends RecyclerView.ViewHolder {
			ImageView imageView;
			TextView textView;

			public myclass(@NonNull View itemView) {
				super(itemView);
				imageView=itemView.findViewById(R.id.imagec);
				textView=itemView.findViewById(R.id.tv);
			}
		}
	}

	class gettersetter{                                         //getter & setter
		int image;
		String name;

		public gettersetter(int image, String name) {
			this.image = image;
			this.name = name;
		}

		public int getImage() {
			return image;
		}

		public void setImage(int image) {
			this.image = image;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
