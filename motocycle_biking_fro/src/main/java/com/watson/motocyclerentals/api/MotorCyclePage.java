package com.watson.motocyclerentals.api;

import com.watson.motocyclerentals.domain.MotorCycle;
import com.watson.motocyclerentals.services.MotorCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@RestController
@RequestMapping("/api/**")
public class MotorCyclePage {
    @Autowired
    private MotorCycleService service;

    //-------------------Retrieve All MotorCycles--------------------------------------------------------

    @RequestMapping(value = "/motorcycles/", method = RequestMethod.GET)
    public ResponseEntity<List<MotorCycle>> listAllMotorCycles() {
        List<MotorCycle> MotorCycle = service.findAll();
        if(MotorCycle.isEmpty()){
            return new ResponseEntity<List<MotorCycle>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MotorCycle>>(MotorCycle, HttpStatus.OK);
    }


    //-------------------Retrieve Single MotorCycle--------------------------------------------------------

    @RequestMapping(value = "/motorcycle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MotorCycle> getMotorCycle(@PathVariable("id") long id) {
        System.out.println("Fetching MotorCycle with id " + id);
        MotorCycle MotorCycle = service.findById(id);
        if (MotorCycle == null) {
            System.out.println("MotorCycle with id " + id + " not found");
            return new ResponseEntity<MotorCycle>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MotorCycle>(MotorCycle, HttpStatus.OK);
    }



    //-------------------Create a MotorCycle--------------------------------------------------------

    @RequestMapping(value = "/motorcycle/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createMotorCycle(@RequestBody MotorCycle motorCycle, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating MotorCycle " + motorCycle.getSerialNumber());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(motorCycle);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/motorcycle/{id}").buildAndExpand(motorCycle.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a MotorCycle --------------------------------------------------------

    @RequestMapping(value = "/motorcycle/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MotorCycle> updateMotorCycle(@PathVariable("id") long id, @RequestBody MotorCycle Subject) {
        System.out.println("Updating Subject " + id);

        MotorCycle currentMotorCycle = service.findById(id);

        if (currentMotorCycle==null) {
            System.out.println("MotorCycle with id " + id + " not found");
            return new ResponseEntity<MotorCycle>(HttpStatus.NOT_FOUND);
        }

        MotorCycle updatedMotorCycle = new MotorCycle
                .Builder(currentMotorCycle.getSerialNumber())
                .copy(currentMotorCycle)
                .build();
        service.update(updatedMotorCycle);
        return new ResponseEntity<MotorCycle>(updatedMotorCycle, HttpStatus.OK);
    }

    //------------------- Delete a MotorCycle --------------------------------------------------------

    @RequestMapping(value = "/motorcycle/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MotorCycle> deleteMotorCycle(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting MotorCycle with id " + id);

        MotorCycle motorCycle = service.findById(id);
        if (motorCycle == null) {
            System.out.println("Unable to delete. MotorCycle with id " + id + " not found");
            return new ResponseEntity<MotorCycle>(HttpStatus.NOT_FOUND);
        }

        service.delete(motorCycle);
        return new ResponseEntity<MotorCycle>(HttpStatus.NO_CONTENT);
    }
}
