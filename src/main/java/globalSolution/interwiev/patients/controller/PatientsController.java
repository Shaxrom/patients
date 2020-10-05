package globalSolution.interwiev.patients.controller;


import globalSolution.interwiev.patients.dto.request.PatientsRequestDTO;
import globalSolution.interwiev.patients.dto.response.PatientsResponseDTO;
import globalSolution.interwiev.patients.repository.MockDBPatientsRepository;
import globalSolution.interwiev.patients.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @PostMapping
    public void addAll(@RequestBody List<PatientsRequestDTO> patientsRequestDTOs){

    }

}
