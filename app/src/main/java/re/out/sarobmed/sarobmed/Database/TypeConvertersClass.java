package re.out.sarobmed.sarobmed.Database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import androidx.room.TypeConverter;
import re.out.sarobmed.sarobmed.HelperModels.AssetActor;
import re.out.sarobmed.sarobmed.HelperModels.InterferenceOptions;
import re.out.sarobmed.sarobmed.HelperModels.ShipActor;

public class TypeConvertersClass {

    @TypeConverter
    public static ArrayList<String> fromStringArray(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromStringArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<ShipActor> fromShipActorString(String value) {
        Type listType = new TypeToken<ArrayList<ShipActor>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromShipActorArrayList(ArrayList<ShipActor> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<AssetActor> fromAssetActorString(String value) {
        Type listType = new TypeToken<ArrayList<AssetActor>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAssetActorArrayList(ArrayList<AssetActor> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<InterferenceOptions> fromInterferenceOptionsString (String value) {
        Type listType = new TypeToken<ArrayList<AssetActor>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromInterferenceOptionsArrayList (ArrayList<InterferenceOptions> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }
}
