package com.watson.motocyclerentals.api.integrationtests;

import com.watson.motocyclerentals.App;
import com.watson.motocyclerentals.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Long on 6/29/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8090"})
public class CustomerAPITest {
    final String BASE_URL = "http://localhost:8090/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/customer/readall", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8090/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllCustomers(){
        System.out.println("Testing listAllCustomers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> CustomersMap = restTemplate.getForObject(REST_SERVICE_URI+"/customers/", List.class);

        if(CustomersMap!=null){
            for(LinkedHashMap<String, Object> map : CustomersMap){
                System.out.println("Customer : id="+map.get("id")+", Name="+map.get("firstName")+", Surname="+map.get("lastName")+", PhoneNumber="+map.get("phoneNumber"));;
            }
        }else{
            System.out.println("No Customer exist----------");
        }
    }

    /* GET */
    private static void getCustomer(){
        System.out.println("Testing getCustomer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer Customer = restTemplate.getForObject(REST_SERVICE_URI+"/customer/1", Customer.class);
        System.out.println(Customer);
    }

    /* POST */
    private static void createCustomer() {
        System.out.println("Testing create Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer Customer = new Customer.Builder("100").firstName("Watson").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/customer/create/", Customer, Customer.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateCustomer() {
        System.out.println("Testing update Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer Customer  =  new Customer.Builder("100").firstName("Lina").build();
        restTemplate.put(REST_SERVICE_URI+"/customer/update/1", Customer);
        System.out.println(Customer);
    }

    /* DELETE */
    private static void deleteCustomer() {
        System.out.println("Testing delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/customer/delete/3");
    }


    /* DELETE */
    private static void deleteAllCustomers() {
        System.out.println("Testing all delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/customer/");
    }
}
