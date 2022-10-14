package com.Neon.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.Neon.Bean.Customer;
import com.Neon.Dao.CustomerOperationDao;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
//@RequestMapping("/controller")
public class CustomerController {

	@Autowired
	private CustomerOperationDao customerOperationDao;
	
	private static List<Customer> list = new ArrayList<>();

	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			method = RequestMethod.GET, value = "/customer")
	public @ResponseBody Iterable<Customer> getCustomer() {
		 //List<Customer> list = new ArrayList<>();
		list = customerOperationDao.listCustomer();
		System.out.println("record get succesfully");
		return list;

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.POST, value = "/customer")
	@ResponseBody
	// @PostMapping("/customer")
	public ResponseEntity<List<Customer>> createCustomer(@RequestBody Customer customer, HttpServletRequest request) {
		// List<Customer> list = new ArrayList<>();
		System.out.println("create customer");
		list = customerOperationDao.createCustomer(customer);
		
		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
			method = RequestMethod.PUT, value = "/customer/{customerId}")

	@ResponseBody
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,
			@PathVariable("customerId") int customerId) {

		System.out.println("Update Customer");
		this.customerOperationDao.updateCustomer(customer, customerId);
		System.out.println("customer record update succesfully");
		return ResponseEntity.ok().body(customer);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON,
			method = RequestMethod.DELETE, value = "/customer/{id}")
	@ResponseBody

	// @DeleteMapping("/customer/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int id) {
		System.out.println("Delete Customer");
		this.customerOperationDao.deleteCustomer(id);
		System.out.println("customer record delete succesfully");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
