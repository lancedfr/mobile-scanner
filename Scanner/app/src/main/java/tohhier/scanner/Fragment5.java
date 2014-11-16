package tohhier.scanner;



import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment5 extends ListFragment {
    List<String> li;
    final ListView list=(ListView) getActivity().findViewById(R.id.listView1);
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        li=new ArrayList<String>();
        li.add("List 1");
        li.add("List 2");
        li.add("List 3");
        li.add("List 4");
        li.add("List 5");

        final Button show=(Button) getActivity().findViewById(R.id.button1);




    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (getActivity().getBaseContext(), R.layout.fragment_fragment5, li);
        list.setAdapter(adp);
    }
}

