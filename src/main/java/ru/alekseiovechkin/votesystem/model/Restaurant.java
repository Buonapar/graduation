package ru.alekseiovechkin.votesystem.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "restaurants", uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx"))
@NamedEntityGraph(
        name = Restaurant.WITH_MENU,
        attributeNodes = @NamedAttributeNode("menu")
)
public class Restaurant extends AbstractNamedEntity{
    public static final String WITH_MENU = "Restaurant.withMenu";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    @OrderBy("date desc")
    private List<Dish> menu;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Dish> menu) {
        super(id, name);
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
