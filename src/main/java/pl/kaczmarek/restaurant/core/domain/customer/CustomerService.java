package pl.kaczmarek.restaurant.core.domain.customer;

import org.modelmapper.ModelMapper;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDTO getCustomer(Long id) {
        return modelMapper.map(customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new), CustomerDTO.class);
    }
}
