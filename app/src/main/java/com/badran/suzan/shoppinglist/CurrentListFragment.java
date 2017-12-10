package com.badran.suzan.shoppinglist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.badran.suzan.shoppinglist.data.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrentListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CurrentListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //1
    private TextView tvTotal,tvTotalValue,tvCount,tvCountValue;
    private ImageButton imbSave;
    private ListView lstCurrent;


    private OnFragmentInteractionListener mListener;

    public CurrentListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentListFragment newInstance(String param1, String param2) {
        CurrentListFragment fragment = new CurrentListFragment();
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
    //3.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history_list, container, false);
        //5.
        tvTotal= (TextView) view.findViewById(R.id.tvTotal);
        tvTotalValue= (TextView) view.findViewById(R.id.tvTotalValue);
        tvCount=(TextView) view.findViewById(R.id.tvCount);
        tvCountValue= (TextView) view.findViewById(R.id.tvCountValue);
        imbSave= (ImageButton) view.findViewById(R.id.imbSave);
        lstCurrent=(ListView) view.findViewById(R.id.lstvCurrent);

        String[] ar={"suzan","adham","adam","amani"};
       //rrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,)
        readAndListen();
        //4.
        return view;
    }
//read and listen data from firebase
    private void readAndListen()
    {
        //5.to get user emails...user info
        //to get user emaill...user info
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');

        //6.bulding data refernce = data path= ata address
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();

        //7
        reference.child(email).child("myList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {

                    Product p=ds.getValue(Product.class);
                    Log.d("LS",p.toString());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
