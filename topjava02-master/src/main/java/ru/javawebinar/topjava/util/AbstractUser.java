package ru.javawebinar.topjava.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * GKislin
 * 24.04.2015.
 */
public interface AbstractUser {

    Integer getId();

    void setId(Integer id);

    @NotEmpty
    String getName();

    void setName(String password);

    @Email
    @NotEmpty
    String getEmail();

    void setEmail(String password);

    @Size(min = 5, max = 64, message = " must between 5 and 64 characters")
    String getPassword();

    void setPassword(String password);

    @Digits(fraction = 0, integer = 4)
    @NotNull
    int getCaloriesPerDay();

    void setCaloriesPerDay(int caloriesPerDay);
}
