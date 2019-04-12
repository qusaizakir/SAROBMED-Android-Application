package re.out.sarobmed.sarobmed.Adapters;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.R;

public class ReportEditableAdapter extends ReportAdapter {

    private Context context;
    private boolean multiSelect = false;
    private ArrayList<Integer> selectedItems = new ArrayList<>();

    ActionMode actionMode;
    ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            multiSelect = true;
            actionMode = mode;
            mode.getMenuInflater().inflate(R.menu.report_actionmode_menu, actionMode.getMenu());
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch(item.getItemId()){

                case R.id.actionmode_delete:
                    //TODO add interface to delete reports selected
                    break;
            }
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            multiSelect = false;
            selectedItems.clear();
            notifyDataSetChanged();
        }
    };

    public ReportEditableAdapter(List<ReportMinimal> reportMinimalList, Context context) {
        super(reportMinimalList, context);
        this.context = context;

    }

    void selectItem(Integer item, View layout) {
        if (multiSelect) {
            if (selectedItems.contains(item)) {
                selectedItems.remove(item);
                if(selectedItems.isEmpty() && actionMode != null){
                    actionMode.finish();
                }
                layout.setActivated(false);
            } else {
                selectedItems.add(item);
                layout.setActivated(true);
            }
            if(actionMode != null){
                actionMode.setTitle("" + selectedItems.size() + " selected");
            }
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        super.onBindViewHolder(holder, position);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID = (int) getItemId(position);
                if(multiSelect){
                    selectItem(ID, holder.layout);
                }else{
                    Toast.makeText(context, "This is a single click!", Toast.LENGTH_SHORT).show();
                    //TODO EDIT page onlclick action
                }
            }
        });

        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ((AppCompatActivity) v.getContext()).startSupportActionMode(actionModeCallbacks);
                selectItem((int)getItemId(position), holder.layout);
                return true;
            }
        });
    }

}
