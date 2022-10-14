/**
 * 
 */
package com.Neon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Neon.Bean.Customer;

/**
 * @author user364
 *
 */

public interface CustomerOperationDao {

	public List<Customer> createCustomer(Customer customer);

	public void deleteCustomer(int id);

	public Customer updateCustomer(Customer customer, int customerId);

	public List<Customer> listCustomer();

}
