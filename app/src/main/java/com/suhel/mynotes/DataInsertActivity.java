package com.suhel.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.suhel.mynotes.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {

    ActivityDataInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type=getIntent().getStringExtra("type");
        if (type.equals("update")){
            setTitle("Update Note");
            binding.inTitle.setText(getIntent().getStringExtra("title"));
            binding.inDisp.setText(getIntent().getStringExtra("disp"));
            int id=getIntent().getIntExtra("id",0);
            binding.add.setText("Update");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.inTitle.getText().toString());
                    intent.putExtra("disp", binding.inDisp.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
        else {
            setTitle("Add Note");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.inTitle.getText().toString());
                    intent.putExtra("disp", binding.inDisp.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}