package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterName  extends RecyclerView.Adapter<AdapterName.ViewHolder> {

    Context mcontext;
    List<model> Namelist;


    public AdapterName(Context mcontext,List<model> Namelist){
        this.mcontext=mcontext;
        this.Namelist=Namelist;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Nameview= LayoutInflater.from(parent.getContext()).inflate(R.layout.mycustomview,parent,false);
        return new ViewHolder(Nameview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        model Name=Namelist.get(position);
        holder.modelName.setText(Name.getName());
        holder.modelCall.setText(Name.getCall());
        holder.modelEmail.setText(Name.getEmail());
        holder.modelAddress.setText(Name.getAddress());
        holder.modeldob.setText(Name.getDob());


    }

    @Override
    public int getItemCount() {
        return Namelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView modelName;
        TextView modelCall;
        TextView modelEmail;
        TextView modelAddress;
        TextView modeldob;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            modelName=itemView.findViewById(R.id.text1);
            modelCall=itemView.findViewById(R.id.text2);
            modelEmail= itemView.findViewById(R.id.text3);
            modelAddress=itemView.findViewById(R.id.text4);
            modeldob=itemView.findViewById(R.id.text5);


            modelName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Intent intent=new Intent(mcontext,recyclerview3.class);
                    //intent.putExtra("Name",modelName.getText().toString().trim());
                    //intent.putExtra("Call",modelCall.getText().toString().trim());
                    //intent.putExtra("Email",modelEmail.getText().toString().trim());
                    //intent.putExtra("Address",modelAddress.getText().toString().trim());
                    //intent.putExtra("dob",modeldob.getText().toString().trim());
                    //mcontext.startActivity(intent);

                    model modelname=Namelist.get(getAdapterPosition());
                    Intent intent=new Intent(mcontext,recyclerview3.class);
                    intent.putExtra("show",modelname);
                    mcontext.startActivity(intent);


                }
            });

            modelEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(Intent.ACTION_SEND);
                    intent1.putExtra(Intent.EXTRA_EMAIL,modelEmail.getText().toString().trim());
                    intent1.putExtra(Intent.EXTRA_SUBJECT,"open email");
                    intent1.putExtra(Intent.EXTRA_TEXT,"welcome");
                    intent1.setType("message/rfc822");
                    mcontext.startActivity(Intent.createChooser(intent1,"choose app"));
                }
            });



           modelCall.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent4=new Intent(Intent.ACTION_DIAL);
                   intent4.setData(Uri.parse("tel:"+modelCall.getText().toString().trim()));
                   mcontext.startActivity(intent4);
               }
           });

        }
    }
}
