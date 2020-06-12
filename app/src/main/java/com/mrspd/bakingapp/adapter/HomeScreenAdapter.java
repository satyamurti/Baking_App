package com.mrspd.bakingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mrspd.bakingapp.R;
import com.mrspd.bakingapp.model.Recipe;
import com.mrspd.bakingapp.utiil.OnclickManger;

import java.util.List;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.ViewHolder> {

    private Context myc;
    private List<Recipe> myresults;
    private OnclickManger onclickManger;

    public HomeScreenAdapter(Context myc, List<Recipe> myresults, OnclickManger onclickManger) {
        this.myc = myc;
        this.myresults = myresults;
        this.onclickManger = onclickManger;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myrecipename;
        public ImageView ifLOL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            myrecipename = itemView.findViewById(R.id.tv_name);
            ifLOL = itemView.findViewById(R.id.iv_image);
        }
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * . Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myc);
        View view = inflater.inflate(R.layout.iteem_list_main_recipe, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override  instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = myresults.get(position);

        holder.myrecipename.setText(recipe.getName());

        String recipeImage = myresults.get(position).getImage();
        if (!recipeImage.isEmpty()) {
            Glide.with(myc)
                    .load(recipeImage)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.ifLOL);
        }

        holder.itemView.setOnClickListener(view -> {
            if (onclickManger != null) {
                onclickManger.OnITemCLickk(position);
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
        return myresults.size();
    }

    public Recipe geRecipeonTHisIndex(int index) {
        return myresults.get(index);
    }

}
