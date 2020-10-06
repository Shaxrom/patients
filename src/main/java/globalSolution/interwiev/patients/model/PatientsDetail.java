package globalSolution.interwiev.patients.model;

import globalSolution.interwiev.patients.dto.request.LocationRequestDTO;
import globalSolution.interwiev.patients.dto.request.PatientsRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientsDetail {
    private String name;
    private Location location;
    private int age;
    private int acceptedOffers;
    private int canceledOffers;
    private int averageReplyTime;

    public PatientsDetail(PatientsRequestDTO patientsRequestDTO){
        this.name = patientsRequestDTO.getName();
        this.location =new Location(patientsRequestDTO.getLocation());
        this.age = patientsRequestDTO.getAge();
        this.acceptedOffers = patientsRequestDTO.getAcceptedOffers();
        this.canceledOffers = patientsRequestDTO.getCanceledOffers();
        this.averageReplyTime = patientsRequestDTO.getAverageReplyTime();
    }

}
