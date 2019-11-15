package com.example.e_softwarica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_softwarica.R;
import com.example.e_softwarica.model.StudentData;

import java.util.List;

public class StudentList extends RecyclerView.Adapter<StudentList.Studentview> {
    Context context;
    List<StudentData> studentDataList;

    public StudentList(Context context, List<StudentData> studentDataList){
        this.context=context;
        this.studentDataList= studentDataList;
    }


    @NonNull
    @Override
    public StudentList.Studentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new Studentview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentList.Studentview holder, final int position) {
        final StudentData studentData=studentDataList.get(position);
        if(studentData.getSgender().equalsIgnoreCase("male")){
            holder.imgcard.setImageResource(R.drawable.ic_male_user);
        }else{
            holder.imgcard.setImageResource(R.drawable.ic_woman_avatar);
        }
        holder.txname.setText(studentData.getSname());
        holder.txaddress.setText(studentData.getSaddress());
        holder.txage.setText(studentData.getSage());
        holder.txgender.setText(studentData.getSgender());

        holder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDataList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    public class Studentview extends RecyclerView.ViewHolder {
        ImageView imgcard;
        TextView txname,txaddress,txage,txgender;
        Button btndel;
        public Studentview(@NonNull View itemView) {
                super(itemView);
                imgcard= itemView.findViewById(R.id.cv);
                txname= itemView.findViewById(R.id.tvname);
                txaddress= itemView.findViewById(R.id.tvaddresss);
                txage= itemView.findViewById(R.id.tvage);
                btndel= itemView.findViewById(R.id.btndele);
                txgender=itemView.findViewById(R.id.tvgender);
            }
        }
}



