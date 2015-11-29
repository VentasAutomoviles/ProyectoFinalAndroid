package com.example.christopher.proyecto;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NamesFragment extends Fragment {


    public NamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final String[] names = {"TOYOTA $1000", "HONDA $2000", "HYUNDAI $3000","BMW $5000"};
        // use android.R.layout.simple_list_item_activated_1
        // to have the selected item in a different color
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, names);
        View view = inflater.inflate(R.layout.fragment_names, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.ListView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                if (callback != null) {
                    callback.onItemSelected(names[position]);
                }
            }
        });
        listView.setAdapter(adapter);
        //return inflater.inflate(R.layout.fragment_names, container, false);
        return view;
    }

    public interface Callback {
        public void onItemSelected(String id);
    }
    private Callback callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof Callback) {
            callback = (Callback) activity;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

}