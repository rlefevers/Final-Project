package edu.iupui.elliott.cocktailappsupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import edu.iupui.elliott.cocktailappsupport.model.Cocktail;

public class CocktailListActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference cocktailsRef = db.collection("cocktails");

    private CocktailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_list);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = cocktailsRef;

        FirestoreRecyclerOptions<Cocktail> options = new FirestoreRecyclerOptions.Builder<Cocktail>()
                .setQuery(query, Cocktail.class)
                .build();

        adapter = new CocktailAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_cocktail_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}