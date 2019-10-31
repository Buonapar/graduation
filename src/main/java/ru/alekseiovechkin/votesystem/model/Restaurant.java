package ru.alekseiovechkin.votesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity{

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
