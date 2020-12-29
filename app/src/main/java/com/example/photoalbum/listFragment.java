package com.example.photoalbum;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//fragment for the listview-gallery display
public class listFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //defining the animals image array
    private int animals[] = {R.drawable.animal13, R.drawable.animal14,
            R.drawable.animal15,
            R.drawable.animal16, R.drawable.animal17,
    };


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    listview lv;
    ListView listview;
    public listFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static listFragment newInstance(String param1, String param2) {
        listFragment fragment = new listFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        lv = new listview(getContext(),animals);
        listview=view.findViewById(R.id.simpleListView);
        listview.setAdapter(lv);
        return view;
    }
}
