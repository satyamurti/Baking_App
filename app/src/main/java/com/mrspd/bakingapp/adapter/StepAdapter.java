package com.mrspd.bakingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.model.Step;
import com.mrspd.bakingapp.utiil.customitemclick;

import java.util.List;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {
    private Context context;
    private List<Step> stepData;
    private customitemclick stepItemClickListener;

    public StepAdapter(Context context, List<Step> stepData, customitemclick stepItemClickListener) {
        this.context = context;
        this.stepData = stepData;
        this.stepItemClickListener = stepItemClickListener;
    }

    public class StepViewHolder extends RecyclerView.ViewHolder {

        public TextView stepOrder;
        public TextView stepName;

        public StepViewHolder(@NonNull View itemView) {
            super(itemView);

            stepName = itemView.findViewById(R.id.tv_name11);
            stepOrder = itemView.findViewById(R.id.tv_amount1);
        }
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.iteem_list_main_steps, parent, false);
        return new StepViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link HomeScreenAdapter.ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link HomeScreenAdapter.ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override
     * instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        Step step = stepData.get(position);
        holder.stepName.setText(step.getShortDescription());

        String stepOrderStr = "";
        if (position > 0) {
            stepOrderStr = position + "";
        }
        holder.stepOrder.setText(stepOrderStr);

        holder.itemView.setOnClickListener(view -> {
            if (stepItemClickListener != null) {
                stepItemClickListener.onItemClick(position);
            }
        });
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return stepData.size();
    }
}
