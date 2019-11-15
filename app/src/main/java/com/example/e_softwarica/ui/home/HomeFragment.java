package com.example.e_softwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_softwarica.R;
import com.example.e_softwarica.adapter.StudentList;
import com.example.e_softwarica.model.StudentData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public RecyclerView recyclerView;
    View view;
    List<StudentData> studentList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.RcView);
        StudentData studentData= new StudentData("Subarna","20","Suryabinayak","Female");
        studentList=studentData.getList();

        if (studentList.isEmpty()){
            studentList.add(studentData);
            studentList.add(new StudentData("Sandeep","22","Baneshwor","Male"));
            studentData.setList(studentList);
        }
        StudentList sl =new StudentList(getActivity(),studentList);
        recyclerView.setAdapter(sl);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}