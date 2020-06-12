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
import com.mrspd.bakingapp.model.Ingrediants;

import java.util.List;

///////////////////////////////////////////////////////////////////////////
// Created with ❤  by Satyamurti only for Udacity
///////////////////////////////////////////////////////////////////////////
public class IngredantsAdapter extends RecyclerView.Adapter<IngredantsAdapter.IngredientViewHolder>  {
    /**
     * Called when RecyclerView needs a new {@link HomeScreenAdapter.ViewHolder} of the given type to represent
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
     */
    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.iteem_list_main_ingrediants, parent, false);
        return new IngredientViewHolder(view);
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
     * on (e.g. in a click listener), use  which will
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
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Ingrediants ingredient = getmyrewulsts.get(position);
        holder.naeme.setText(ingredient.getIngredient());
        holder.myamount.setText(ingredient.gethutyf());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return getmyrewulsts.size();
    }

    private Context c;
    private List<Ingrediants> getmyrewulsts;

    public IngredantsAdapter(Context c, List<Ingrediants> getmyrewulsts) {
        this.c = c;
        this.getmyrewulsts = getmyrewulsts;
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {

        public TextView naeme;
        public TextView myamount;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);

            naeme = itemView.findViewById(R.id.tv_name1);
            myamount = itemView.findViewById(R.id.amount333);
        }
}

}
