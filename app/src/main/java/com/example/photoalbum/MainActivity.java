package com.example.photoalbum;

import android.os.Handler;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements OnStateChanged, OnButtonPressListener, OnCheckChanged {
    Button m_next;
    Button m_previous;
    public static FragmentManager fragmentManager;
    listFragment lstfrg;
    int position=0;
    int animals[] = {R.drawable.animal13, R.drawable.animal14,
            R.drawable.animal15,
            R.drawable.animal16, R.drawable.animal17,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstfrg=new listFragment();
        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.container) != null) {

            if(savedInstanceState != null) {


                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            imageFragment imgfrag = imageFragment.newInstance("data",0);
            fragmentTransaction.add(R.id.container, imgfrag, null);
            fragmentTransaction.commit();
            m_previous=findViewById(R.id.previous);
            m_previous.setEnabled(false);

        }

    }

    @Override
    //gallery
    public void onChanged(int state) {
        if(state==1){


            fragmentManager.beginTransaction().replace(R.id.container,lstfrg).commit();


        }
        else{
            imageFragment imgfrg=imageFragment.newInstance("data",0);
            fragmentManager.beginTransaction().replace(R.id.container,imgfrg).commit();
        }
    }

    @Override
    public void onButtonPressed(int i) {
//front and back
        if(i==2){
            m_next=findViewById(R.id.next);
            imageFragment imgfrg= imageFragment.newInstance("data",position);
            fragmentManager.beginTransaction().replace(R.id.container, imgfrg, null).addToBackStack(null).commit();
            if(position!=0) {
                m_previous.setEnabled(true);
            }
            if(position<animals.length) {
                m_next.setEnabled(true);
                position++;

            }
            if(position>=animals.length){
                m_next.setEnabled(false);
                position = animals.length-1;
            }


        }
        else{
            m_previous=findViewById(R.id.previous);
            if(position>0) {
                m_previous.setEnabled(true);
                if(position==animals.length) {
                    m_next.setEnabled(false);
                }
                else{
                    m_next.setEnabled(true);
                }

                position--;
            }
            else if(position<=0) {
                position=0;
                m_previous.setEnabled(false);
            }

            imageFragment imgfrg=imageFragment.newInstance("data",position);
            fragmentManager.beginTransaction().replace(R.id.container, imgfrg, null).commit();
        }
    }

    @Override
    //slideshow
    public void OnChecked(int state) {
        if(state==1){
            int a;
            position=0;
            Handler handler1 = new Handler();

            for(a=0;a<animals.length;a++) {

                handler1.postDelayed(new Runnable(){
                    public void run() {

                        imageFragment imgfrg=imageFragment.newInstance("data",position);
                        fragmentManager.beginTransaction().replace(R.id.container, imgfrg, null).addToBackStack(null).commit();
                        position=position+1;

                    }
                    },3000*a);




            }
        }
        else{
            position=0;

            imageFragment imgfrg=imageFragment.newInstance("data",position);
            fragmentManager.beginTransaction().replace(R.id.container, imgfrg, null).addToBackStack(null).commit();
        }

    }
}
