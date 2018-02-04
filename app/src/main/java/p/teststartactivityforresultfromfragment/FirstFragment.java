package p.teststartactivityforresultfromfragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        root.findViewById(R.id.button).setOnClickListener(v ->
                getFragmentManager().beginTransaction()
                        .replace(R.id.root, new SecondFragment())
                        .addToBackStack(null)
                        .commit()
        );

        return root;
    }

}
