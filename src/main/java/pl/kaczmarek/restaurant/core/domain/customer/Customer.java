package pl.kaczmarek.restaurant.core.domain.customer;

import javax.persistence.*;

@Entity
@Table(name = "users")
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

}
