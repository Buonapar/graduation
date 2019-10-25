package ru.alekseiovechkin.votesystem.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity{

//    @NotBlank
//    @Column(name = "restaurant_name")
//    @Size(min = 2, max = 100)
//    private String name;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotBlank
    @Column(name = "menu")
    private String menu;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, @NotNull LocalDate date, @NotBlank String menu) {
        super(id, name);
        this.date = date;
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
