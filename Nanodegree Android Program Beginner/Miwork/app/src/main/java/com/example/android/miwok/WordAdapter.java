package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jennifernghinguyen on 8/16/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private int backgroundColor;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param objects A List of Word objects to display in a list
     */
    public WordAdapter(Context context, List<Word> objects, int backgroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, objects);
        this.backgroundColor = backgroundColor;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        LinearLayout textViewLayout = (LinearLayout) listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        textViewLayout.setBackgroundColor(color);
        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miworkTextView.setText(currentWord.getMiwokWord());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getEnglishWord());

        ImageView miworkImage = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            miworkImage.setVisibility(View.VISIBLE);
            miworkImage.setImageResource(currentWord.getImageResourceId());
        } else {
            miworkImage.setVisibility(View.GONE);
        }


        return listItemView;
    }


}
