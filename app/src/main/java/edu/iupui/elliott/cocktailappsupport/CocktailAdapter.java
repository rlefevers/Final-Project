package edu.iupui.elliott.cocktailappsupport;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import edu.iupui.elliott.cocktailappsupport.model.Cocktail;

public class CocktailAdapter extends FirestoreRecyclerAdapter<Cocktail, CocktailAdapter.CocktailHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CocktailAdapter(@NonNull FirestoreRecyclerOptions<Cocktail> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CocktailHolder holder, int position, @NonNull Cocktail model) {
        holder.textViewName.setText(model.getName());
        //holder.textViewGlass.setText(model.getGlass());
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_cocktail,
                viewGroup, false);
        return new CocktailHolder(v);
    }

    class CocktailHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        //TextView textViewGlass;

        public CocktailHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.txt_cocktail_name);
            //textViewGlass = itemView.findViewById(R.id.text_view_glass);
        }
    }

}
