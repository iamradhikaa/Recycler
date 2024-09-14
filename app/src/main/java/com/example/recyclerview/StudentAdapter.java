

package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter {
    List studentDataList;
    private OnItemClickListener listener;
    public StudentAdapter(List studentDataList, MainActivity listener) {
        this.studentDataList=studentDataList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView name,age;
        studentData data= (studentData) studentDataList.get(position);
        View view = holder.itemView;
        name=view.findViewById(R.id.name);
        age=view.findViewById(R.id.age);
        name.setText(data.name);
        age.setText(String.valueOf(data.age));


    }



    @Override
    public int getItemCount() {
        return studentDataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);

            itemView.setOnClickListener(v-> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }

            });
        }




    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
