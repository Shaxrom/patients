package globalSolution.interwiev.patients.service;

import globalSolution.interwiev.patients.model.Location;
import org.springframework.stereotype.Service;


@Service
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double findDistance(Location location) {
        return Math.sqrt(Math.pow(location.getLatitude(),2)+Math.pow(location.getLongitude(),2));
    }
}
