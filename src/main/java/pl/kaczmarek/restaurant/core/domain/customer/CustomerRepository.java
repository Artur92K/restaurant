package pl.kaczmarek.restaurant.core.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
}
