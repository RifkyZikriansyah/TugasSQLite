package com.example.tugassqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugassqlite.PersonBean;
import com.example.tugassqlite.R;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;
    List<PersonBean> listPersonInfo;

    public RecyclerviewAdapter(Context context, List<PersonBean> listPersonInfo, OnUserClickListener listener) {
        this.context=context;
        this.listPersonInfo=listPersonInfo;
        this.listener = listener;

    }

    public interface OnUserClickListener{
        void onUserClick(PersonBean currentPerson, String action);
    }
    @NonNull
    @Override
    public RecyclerviewAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.  UserViewHolder holder, int position) {
        final PersonBean currentPerson=listPersonInfo.get(position);
        holder.txtName.setText(currentPerson.getNAME());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClick(currentPerson);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
        }
    }
}