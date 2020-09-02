package com.ann.whatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"New Group", "New Contact", "Baekhyun", "Chanyeol", "Jongdae", "Kai", "Kyungsoo", "Sehun", "Suho", "Xiumin", "Yixing"};
    String mDescription[] = {"", "", "Kkaebsong", "Ann", "왜?", "Umm", "Hey There! I am using WhatsApp.", "Yehet", "사랑하자", "Busy", "Sheep" };
    int images[] ={R.drawable.group, R.drawable.contact, R.drawable.baekhyun, R.drawable.loey, R.drawable.chen, R.drawable.kai, R.drawable.kyungsoo,
    R.drawable.sehun, R.drawable.suho, R.drawable.xiumin, R.drawable.lay};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Adapter adapter = new Adapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "New Group", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "New Contact", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Chanyeol", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class Adapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        Adapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.text1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}