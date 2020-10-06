package globalSolution.interwiev.patients.service;

import globalSolution.interwiev.patients.dto.request.LocationRequestDTO;
import globalSolution.interwiev.patients.dto.request.PatientsRequestDTO;
import globalSolution.interwiev.patients.model.Location;
import globalSolution.interwiev.patients.model.PatientsDetail;
import globalSolution.interwiev.patients.repository.MockDBPatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PatientsServiceImpl implements PatientsService {
    @Autowired
    private DistanceService distanceService;

    private static final double AGE = 0.1;
    private static final double DISTANCE_TO_PRACTICE = 0.1;
    private static final double ACCEPTED_OFFERS = 0.3;
    private static final double CANCELLED_OFFERS = 0.3;
    private static final double REPLY_TIME = 0.2;

    @Override
    public void addAllPatients(List<PatientsRequestDTO> patientsRequestDTO) {
        Map<String, PatientsDetail> patientsDetailMap = patientsRequestDTO.stream().collect(Collectors.toMap(PatientsRequestDTO::getId, PatientsDetail::new));
        MockDBPatientsRepository.patientsDetail.putAll(patientsDetailMap);
    }

    @Override
    public List<Map.Entry<String, Double>> getFirstTenPatients(LocationRequestDTO locationRequestDTO) {
        Map<String, Double> resultMap = new HashMap<>();
        double distanceFacility = distanceService.findDistance(new Location(locationRequestDTO));
        for (String key : MockDBPatientsRepository.patientsDetail.keySet()) {
            double chance = calculateChance(MockDBPatientsRepository.patientsDetail.get(key), distanceFacility);
            resultMap.put(key,chance);
        }
        return resultMap.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(10).collect(Collectors.toList());
    }

    private double calculateChance(PatientsDetail patientsDetail,double distanceFacility){
        double age = patientsDetail.getAge()*AGE;
        double distance = Math.abs(distanceFacility-distanceService.findDistance(patientsDetail.getLocation()));
        double accepted = patientsDetail.getAcceptedOffers()*ACCEPTED_OFFERS;
        double cancelled = patientsDetail.getCanceledOffers()*CANCELLED_OFFERS;
        double averageReplyTime = patientsDetail.getAverageReplyTime()*REPLY_TIME;
        double chance = age+distance+accepted+cancelled+averageReplyTime;
        return chance;
    }

}
