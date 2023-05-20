package dz.esi.tdm.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ArrayList<Note> Notes ;
    ListView listViewNotes;
    NotesAdapter adapterNote;
    private ArrayAdapter<Note> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNotes = findViewById(R.id.list);
        Notes = new ArrayList<Note>();
        NotesAdapter adapterNote = new NotesAdapter(MainActivity.this, Notes);
        adapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, Notes);
        listViewNotes.setAdapter(adapterNote);
        listViewNotes.setOnItemClickListener(this);
        listViewNotes.setOnItemLongClickListener(this);

    }
/************************************** Save contents until rotation ************************************/
/********************************************************************************************************/

    @Override

    protected void onSaveInstanceState (Bundle outState) {

        super.onSaveInstanceState (outState);
        outState.putSerializable("Notes", Notes);

    }

    @Override

    protected void onRestoreInstanceState (Bundle savedInstanceState) {

        super.onRestoreInstanceState (savedInstanceState);
        this.Notes.clear();
        this.Notes.addAll((ArrayList<Note>) savedInstanceState.getSerializable("Notes"));
        this.adapter.notifyDataSetChanged();
    }
    /**************************************   ActionBar configuration   **************************************/
    /********************************************************************************************************/
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.icon:
                final Dialog dialog = new Dialog(MainActivity.this);
                // I use personalised dialogue Box
                dialog.setContentView(R.layout.dialoguepage);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //Animation for dialogue box
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                Button Noterbutton=dialog.findViewById(R.id.NoterBut);
                Noterbutton.setBackgroundColor(Color.rgb(245,245,245));

                Noterbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText newNote=dialog.findViewById(R.id.newNote);
                        String descriptionNote = newNote.getText().toString();
                        Notes.add(new Note("Roufaida Saadallah",descriptionNote,R.drawable.note, Calendar.getInstance().getTime()));
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return true;
            case R.id.exit:
                finish();
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }

    /************************************** Manipulation des items de ListView ************************************/
    /********************************************************************************************************/
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //i is index of item in the ArrayList
        Note NoteSelectionne=Notes.get(i);
        Intent intr= new Intent(MainActivity.this,DetailsActivity.class);
        intr.putExtra("Note",NoteSelectionne);
        startActivity(intr);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder confirm = new AlertDialog.Builder(this);
        confirm.setTitle("Suppression");
        confirm.setIcon(android.R.drawable.ic_dialog_alert);
        confirm.setMessage("Vous confirmez la suppression ?");

        confirm.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idBtn) {
                        Notes.remove(i);
                        adapter.notifyDataSetChanged();
                        listViewNotes.invalidateViews();
                    }
                });
        confirm.setNegativeButton("Annuler", null);
        confirm.show();
        return true;
    }
}
