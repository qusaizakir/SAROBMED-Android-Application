package re.out.sarobmed.sarobmed.HelperModels;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SetAutoComplete implements View.OnFocusChangeListener{

    private AutoCompleteTextView editText;
    private int array;
    private Context context;

    public SetAutoComplete(AutoCompleteTextView editText, int array, Context context) {
        this.editText = editText;
        this.array = array;
        this.context = context;
        setAdapter();
        this.editText.setOnFocusChangeListener(this);
    }

    private void setAdapter() {

        String[] strings = context.getResources().getStringArray(array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_dropdown_item_1line,
                strings);
        editText.setAdapter(adapter);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            editText.showDropDown();
        }
    }
}
