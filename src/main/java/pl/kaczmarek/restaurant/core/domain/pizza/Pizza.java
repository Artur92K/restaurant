package pl.kaczmarek.restaurant.core.domain.pizza;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizzas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
class Pizza {

    public static final int BASEPRICE = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pizzas_ingredients",
            joinColumns = {@JoinColumn(name = "ingridient_id", referencedColumnName = "id")})
    List<Ingredient> ingredients;


    public Pizza(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    double getBasePrice() {
        return BASEPRICE + this.ingredients.stream().mapToDouble(Ingredient::getPrice).max().getAsDouble();
    }
}
