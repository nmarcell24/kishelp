package hu.heropractice.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ListHero {
    private String name;
    private String nationality;
}
