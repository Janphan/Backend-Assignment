package fi.haagahelia.customerlist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.customerlist.domain.Customer;
import fi.haagahelia.customerlist.domain.CustomerDAO;
import fi.haagahelia.customerlist.domain.CustomerRepository;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/customerlist")
    public String customerList(Model model) {
        // Fetch all customer
        List<Customer> customers = repository.findAll();

        // Add studentlist to model and return view name
        model.addAttribute("customers", customers);
        return "customerlist";
    }

    // Add new customer
    @RequestMapping(value = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    // Save new customer
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Customer customer) {
        customerDAO.save(customer);
        return "redirect:customerlist";
    }
}
