package com.example.e_softwarica.ui.students;

import android.os.Bundle;
import android.service.autofill.Dataset;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_softwarica.R;
import com.example.e_softwarica.model.StudentData;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment  {
    EditText name, age, address;
    RadioGroup radioGroup;
    Button save;
    String sname="", sage="", sadd="", gen="";

    List<StudentData> studentList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adduser, container, false);
        name= view.findViewById(R.id.name);
        age= view.findViewById(R.id.age);
        address= view.findViewById(R.id.address);
        name= view.findViewById(R.id.name);
        radioGroup=view.findViewById(R.id.gender);
        save=view.findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (TextUtils.isEmpty(name.getText().toString())){
                name.setError("enter your name");
                return;
            }else if(TextUtils.isEmpty(age.getText().toString())){
                age.setError("enter yor age");
            }else if(TextUtils.isEmpty(address.getText().toString())){
                address.setError("enter your address");
            }else{
                sname=name.getText().toString();
                sage=age.getText().toString();
                sadd=address.getText().toString();
            }
                int selectid = radioGroup.getCheckedRadioButtonId();
                if (selectid > 0) {
                    RadioButton radioButton = getView().findViewById(selectid);
                    gen = radioButton.getText().toString();
                    Toast.makeText(getContext(), "Welcome " + sname + sage + sadd + gen, Toast.LENGTH_SHORT).show();
                    StudentData studentData= new StudentData(sname,sage,sadd,gen);

                    studentList=studentData.getList();
                    studentList.add(studentData);
                    studentData.setList(studentList);
                    name.setText("");
                    address.setText("");
                    age.setText("");

                } else {
                    Toast.makeText(getContext(), "Please select gender", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }
}