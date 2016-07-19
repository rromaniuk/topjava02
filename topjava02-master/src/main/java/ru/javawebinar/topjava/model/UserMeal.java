package ru.javawebinar.topjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * GKislin
 * 06.03.2015.
 */
@NamedQueries({
        @NamedQuery(name = UserMeal.GET, query = "SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
        @NamedQuery(name = UserMeal.DELETE_ALL, query = "DELETE FROM UserMeal i WHERE i.user.id=:userId"),
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.GET_BETWEEN,
                query = "SELECT m from UserMeal m WHERE m.user.id=:userId "+
                        " AND m.dateTime>=:after and m.dateTime<:before ORDER BY m.dateTime DESC"),

//        @NamedQuery(name = UserMeal.UPDATE, query = "UPDATE UserMeal m SET m.dateTime = :datetime, m.calories= :calories," +
//                "m.description=:desc where m.id=:id and m.user.id=:userId")
})

@Entity
@Table(name = "meals")
public class UserMeal extends BaseEntity {

    public static final String GET = "UserMeal.get";
    public static final String ALL_SORTED = "UserMeal.getAll";
    public static final String DELETE = "UserMeal.delete";
    public static final String DELETE_ALL = "UserMeal.deleteAll";
    public static final String GET_BETWEEN = "UserMeal.getBetween";
//    public static final String UPDATE = "UserMeal.update";

    @Column(name = "datetime", nullable = false)
    protected LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    @NotEmpty
    protected String description;

    @Column(name = "calories")
    protected int calories;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserMeal() {
    }

    public UserMeal(UserMeal meal) {
        this(meal.id, meal.dateTime, meal.description, meal.calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String meal) {
        this.description = meal;
    }

    public int getCalories() {
        return calories;
    }

    public User getUser() {
        return user;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Meal(" + id + ", " + TimeUtil.toString(dateTime) + ", '" + description + "', calories:" + calories + ')';
    }

    public void setUser(User user) {
        this.user = user;
    }

}
