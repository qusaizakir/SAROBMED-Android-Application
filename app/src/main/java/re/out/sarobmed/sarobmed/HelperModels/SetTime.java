package re.out.sarobmed.sarobmed.HelperModels;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class SetTime implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private EditText editText;
    private Calendar myCalendar;
    private Context context;

    public SetTime(EditText editText, Context context){
        this.editText = editText;
        this.editText.setOnClickListener(this);
        this.myCalendar = Calendar.getInstance();
        this.context = context;

    }

    @Override
    public void onClick(View v) {
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        new TimePickerDialog(context, this, hour, minute, true).show();
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        this.myCalendar.set(Calendar.MINUTE, minute);
        this.editText.setText( hourOfDay + ":" + minute);
    }

    public Calendar getMyCalendar() {
        return myCalendar;
    }

    public Date getCalendarDate(){
        return myCalendar.getTime();
    }

}
