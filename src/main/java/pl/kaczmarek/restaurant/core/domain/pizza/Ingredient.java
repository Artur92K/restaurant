package pl.kaczmarek.restaurant.core.domain.pizza;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredient_name")
    private String name;

    private double price;

    Ingredient(String ingredientName, double price) {
        this.name = ingredientName;
        this.price = price;
    }
}
