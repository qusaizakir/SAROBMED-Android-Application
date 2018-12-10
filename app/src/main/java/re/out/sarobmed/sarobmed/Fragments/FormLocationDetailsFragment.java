package re.out.sarobmed.sarobmed.Fragments;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.HelperModels.GPSHelper;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;

@RuntimePermissions
public class FormLocationDetailsFragment extends Fragment {

    private Context context;
    private FormLocationDetailsListener mListener;
    private GPSHelper gpsHelper;

    private EditText posOfVesselLong;
    private EditText posOfVesselLat;

    public FormLocationDetailsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_location_details, container, false);
        setHasOptionsMenu(true);
        mListener.setupFormLocationToolbar();
        gpsHelper = new GPSHelper(context);
        initViews(v);
        setUpTimeAndDate();
        setUpAutoComplete();
        setUpDialogs();
        findCurrentLocation();
        return v;
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    public void findCurrentLocation() {
        gpsHelper.getMyLocation();
        posOfVesselLong.setText(gpsHelper.getLongitude() + "");
        posOfVesselLat.setText(gpsHelper.getLatitude() + "");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FormLocationDetailsFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void setUpTimeAndDate() {

    }

    private void setUpAutoComplete() {

    }

    private void setUpDialogs() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                ((AppCompatActivity)context).onBackPressed();
                return true;
            case R.id.currentLocation:
                FormLocationDetailsFragmentPermissionsDispatcher.findCurrentLocationWithPermissionCheck(this);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_toolbar_location_details, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initViews(View v) {
        posOfVesselLong = v.findViewById(R.id.edit_posOfVesselLong);
        posOfVesselLat = v.findViewById(R.id.edit_posOfVesselLat);

    }

    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;

        //Parse the long and lat doubles
        double lng = 0;
        try {
            lng = Double.parseDouble(posOfVesselLong.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }
        double lat = 0;
        try {
            lat = Double.parseDouble(posOfVesselLat.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        report.setPosOfVesselLong(lng);
        report.setPosOfVesselLat(lat);

        ((AddFormActivity)context).updateReport();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormLocationDetailsListener) {
            mListener = (FormLocationDetailsListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FormLocationDetailsListener {
        void setupFormLocationToolbar();
    }
}
