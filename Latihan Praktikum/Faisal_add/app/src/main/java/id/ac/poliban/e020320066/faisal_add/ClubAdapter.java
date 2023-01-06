package id.ac.poliban.e020320066.faisal_add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {
    private final Context mContext;
    private final List<String> mList;

    public ClubAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(convertView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvItem.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        private final ClubAdapter mAdapter;

        public ViewHolder(@NonNull View itemView, ClubAdapter mAdapter) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            this.mAdapter = mAdapter;

            itemView.setOnClickListener(this::onItemClicked);
            itemView.setOnLongClickListener(this::onItemLongClicked);
        }

        private boolean onItemLongClicked(View view) {
            int position = getLayoutPosition();
            String club = mAdapter.mList.get(position);
            //Tampilkan dialog hapus
            new AlertDialog.Builder(mAdapter.mContext)
                    .setTitle("Delete Confirmation")
                    .setMessage(String.format("Hapus data %s", club))
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        mAdapter.mList.remove(club);
                        mAdapter.notifyDataSetChanged();
                    })
                    .show();

            return true;
        }

        private void onItemClicked(View view) {
            //ambil posisi club yang mana yang sedang diklik
            int position = getLayoutPosition();
            String club = mAdapter.mList.get(position);
            club = String.format("%s terkena clicked!", club);
            Snackbar.make(view, club, Snackbar.LENGTH_SHORT).show();

        }

    }
}
