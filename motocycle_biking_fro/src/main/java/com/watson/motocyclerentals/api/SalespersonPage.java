package com.watson.motocyclerentals.api;

import com.watson.motocyclerentals.domain.SalesPerson;
import com.watson.motocyclerentals.services.SalesPersonService;
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
public class SalespersonPage {
    @Autowired
    private SalesPersonService service;

    //-------------------Retrieve All SalesPersons--------------------------------------------------------

    @RequestMapping(value = "/salespersons/", method = RequestMethod.GET)
    public ResponseEntity<List<SalesPerson>> listAllMotorCycles() {
        List<SalesPerson> SalesPerson = service.findAll();
        if(SalesPerson.isEmpty()){
            return new ResponseEntity<List<SalesPerson>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SalesPerson>>(SalesPerson, HttpStatus.OK);
    }


    //-------------------Retrieve Single SalesPerson--------------------------------------------------------

    @RequestMapping(value = "/salesperson/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalesPerson> getSalesPerson(@PathVariable("id") long id) {
        System.out.println("Fetching SalesPerson with id " + id);
        SalesPerson SalesPerson = service.findById(id);
        if (SalesPerson == null) {
            System.out.println("SalesPerson with id " + id + " not found");
            return new ResponseEntity<SalesPerson>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SalesPerson>(SalesPerson, HttpStatus.OK);
    }



    //-------------------Create a SalesPerson--------------------------------------------------------

    @RequestMapping(value = "/salesperson/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSalesPerson(@RequestBody SalesPerson salesPerson,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating SalesPerson " + salesPerson.getFirstName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(salesPerson);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/salesperson/{id}").buildAndExpand(salesPerson.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a SalesPerson --------------------------------------------------------

    @RequestMapping(value = "/salesperson/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalesPerson> updateSalesPerson(@PathVariable("id") long id, @RequestBody SalesPerson SalesPerson) {
        System.out.println("Updating Subject " + id);

        SalesPerson currentSalesPerson = service.findById(id);

        if (currentSalesPerson==null) {
            System.out.println("SalesPerson with id " + id + " not found");
            return new ResponseEntity<SalesPerson>(HttpStatus.NOT_FOUND);
        }

        SalesPerson updatedSalesPerson = new SalesPerson
                .Builder(currentSalesPerson.getLastName())
                .copy(currentSalesPerson)
                .build();
        service.update(updatedSalesPerson);
        return new ResponseEntity<SalesPerson>(updatedSalesPerson, HttpStatus.OK);
    }

    //------------------- Delete a SalesPerson --------------------------------------------------------

    @RequestMapping(value = "/salesperson/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SalesPerson> deleteSalesPerson(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting SalesPerson with id " + id);

        SalesPerson salesPerson = service.findById(id);
        if (salesPerson == null) {
            System.out.println("Unable to delete. SalesPerson with id " + id + " not found");
            return new ResponseEntity<SalesPerson>(HttpStatus.NOT_FOUND);
        }

        service.delete(salesPerson);
        return new ResponseEntity<SalesPerson>(HttpStatus.NO_CONTENT);
    }
}
