package globalSolution.interwiev.patients.model;

import globalSolution.interwiev.patients.dto.request.LocationRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private double latitude;
    private double longitude;

    public Location(LocationRequestDTO location) {
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }
}
