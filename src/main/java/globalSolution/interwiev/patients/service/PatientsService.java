package globalSolution.interwiev.patients.service;

import globalSolution.interwiev.patients.dto.request.LocationRequestDTO;
import globalSolution.interwiev.patients.dto.request.PatientsRequestDTO;

import java.util.List;
import java.util.Map;

public interface PatientsService {
    void addAllPatients(PatientsRequestDTO[] patientsRequestDTO);
    List<Map.Entry<String, Double>> getFirstTenPatients(LocationRequestDTO locationRequestDTO);
}
