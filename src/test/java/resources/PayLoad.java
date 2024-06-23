package resources;

import Pojo.AddPlace;
import Pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class PayLoad {

    public static AddPlace AddPlacePayload(String name, String language,String address){
        AddPlace addPlace=new AddPlace();

        addPlace.setAccuracy(50);
        addPlace.setName(name);
        addPlace.setPhone_number("+91-9876543210");
        addPlace.setAddress(address);
        addPlace.setWebsite("https://google.co.in");
        addPlace.setLanguage(language);

        List<String> types=new ArrayList<>();
        types.add("Shoe Park");
        types.add("Shop");

        addPlace.setTypes(types);

        Location location=new Location();
        location.setLat(-38.383494);
        location.setLng(35.383494);

        addPlace.setLocation(location);

        return addPlace;
    }
}