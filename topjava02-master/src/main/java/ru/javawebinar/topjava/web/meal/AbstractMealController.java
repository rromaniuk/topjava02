package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.web.ExceptionInfoHandler;

import java.time.LocalDateTime;
import java.util.List;

public class AbstractMealController extends ExceptionInfoHandler {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractMealController.class);

    @Autowired
    protected UserMealService service;

    public UserMeal get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public List<UserMeal> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return service.getAll(userId);
    }

    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.id();
        LOG.info("getBetween {} and {} for User {}", startDate, endDate, userId);
        return service.getBetween(startDate, endDate, userId);
    }

    public void deleteAll() {
        int userId = LoggedUser.id();
        LOG.info("deleteAll for User {}", userId);
        service.deleteAll(userId);
    }

    public void update(UserMeal meal, int id) {
        meal.setId(id);
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}", meal, userId);
        service.update(meal, userId);
    }

    public UserMeal create(UserMeal meal) {
        meal.setId(null);
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}" + meal, userId);
        return service.save(meal, userId);
    }
}
