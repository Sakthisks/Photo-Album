package com.example.photoalbum;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button m_prev = null;
    Button m_next = null;
    OnButtonPressListener buttonListener;
    OnStateChanged mListener;
    OnCheckChanged sListener;
    CheckBox m_gallery = null;
    CheckBox m_slideshow = null;


    public fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_fragment2,container,true);
        m_gallery = root.findViewById(R.id.gallery);
        m_slideshow = root.findViewById(R.id.slideshow);
        m_prev=root.findViewById(R.id.previous);
        m_next=root.findViewById(R.id.next);
        //previous button "<<"
        m_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onButtonPressed(1);
            }
        });
        // next button ">>"
        m_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onButtonPressed(2);
            }
        });
        //gallery list view checkbox
        m_gallery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    mListener.onChanged(1);
                }
                else{
                    mListener.onChanged(0);
                }
            }
        });
        //slide show check box
        m_slideshow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked )
                {
                    sListener.OnChecked(1);
                }
                else{
                    sListener.OnChecked(0);
                }
            }
        });



        return root;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnStateChanged) getActivity();
            buttonListener = (OnButtonPressListener)getActivity();
            sListener = (OnCheckChanged) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement all the methods");
        }
    }
}
