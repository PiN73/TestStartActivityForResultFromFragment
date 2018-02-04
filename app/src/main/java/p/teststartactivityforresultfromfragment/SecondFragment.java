package p.teststartactivityforresultfromfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class SecondFragment extends Fragment {


    private static final int REQUEST_CODE_PICK_IMAGE = 1;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second, container, false);

        root.findViewById(R.id.button).setOnClickListener(v ->
                startActivityForResult(
                        new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        ), REQUEST_CODE_PICK_IMAGE
                )
        );

        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_IMAGE
                && resultCode == AppCompatActivity.RESULT_OK) {
            String path = Utils.getPathFromCameraData(data, this.getActivity());
            Toast.makeText(getContext(),"Selected image" + path, Toast.LENGTH_LONG).show();
        }
    }

}
