package globalSolution.interwiev.patients.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientsRequestDTO {
    private String id;
    private String name;
    private LocationRequestDTO location;
    private int age;
    private int acceptedOffers;
    private int canceledOffers;
    private int averageReplyTime;

}
