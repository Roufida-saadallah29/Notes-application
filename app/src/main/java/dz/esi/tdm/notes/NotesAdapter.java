package dz.esi.tdm.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Note>
{

    List<Note> es;
    public NotesAdapter(Context context, List<Note> Notes) {
        super(context, 0, Notes);
        this.es=Notes;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent, false);
        TextView nomm = (TextView)convertView.findViewById(R.id.titre);
        TextView description = (TextView) convertView.findViewById(R.id.Description);
        ImageView icon = (ImageView) convertView.findViewById(R.id.NoteImage);
        nomm.setText(es.get(position).getTitre());
        String descr=es.get(position).getDescription();
        if (descr.length()>=10)
        {
        description.setText(descr.substring(0,10) +"...");}
        else { description.setText(descr +"...");}
        icon.setImageResource(es.get(position).getIdImage());
        return convertView;
    }
}
