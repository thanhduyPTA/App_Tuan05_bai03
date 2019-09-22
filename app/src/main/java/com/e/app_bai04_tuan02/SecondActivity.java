package com.e.app_bai04_tuan02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText edName, edCMND;
    TextView txtBangCap, txtSoThich, txtInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondctivity);

        edName = findViewById(R.id.edName);
        edCMND = findViewById(R.id.edCMND);
        txtBangCap = findViewById(R.id.txtBangCap);
        txtSoThich = findViewById(R.id.edHobbies);
        txtInfor = findViewById(R.id.edInfor);

        // Nhận dữ liệu từ intent
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("data");

        Person person = (Person) bundle.getSerializable("person");

        edName.setText(person.getTen());
        edCMND.setText(person.getCmnd());
        txtBangCap.setText("Bằng cấp: " + person.getBangcap());

        String hobs = "";
        int i = 0;
        for (String s : person.getHobbies()) {
            i++;
            if (i == person.getHobbies().size())
                hobs += s;
            else
                hobs += s + ", ";
        }

        txtSoThich.setText("Sở thích: " + hobs);
        txtInfor.setText("Thông tin: " + person.getInfor());
    }
}
