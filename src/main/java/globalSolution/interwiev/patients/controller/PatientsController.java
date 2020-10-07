package globalSolution.interwiev.patients.controller;


import globalSolution.interwiev.patients.dto.request.LocationRequestDTO;
import globalSolution.interwiev.patients.dto.request.PatientsRequestDTO;
import globalSolution.interwiev.patients.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    /**
     * Add all patients from patients.json to MockDB,before get
     * @return void
     */

    @PostMapping
    public void addAll(@RequestBody PatientsRequestDTO[] patientsRequestDTOs){
        patientsService.addAllPatients(patientsRequestDTOs);
    }

    @GetMapping
    public List<Map.Entry<String, Double>> get (@RequestBody LocationRequestDTO locationRequestDTO){
        return patientsService.getFirstTenPatients(locationRequestDTO);
    }

}
