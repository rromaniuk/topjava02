package ru.javawebinar.topjava.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

abstract public class UserMealServiceTest extends DbTest {

    @Autowired
    UserMealService service;

    @Test
    public void testDelete() throws Exception {
        service.delete(MEAL1_ID, START_SEQ);
        MATCHER.assertListEquals(Arrays.asList(MEAL4, MEAL3, MEAL2), service.getAll(START_SEQ));
    }

    //    @Test(expected = NotFoundException.class)
    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(MEAL1_ID, 1);
    }

    @Test
    public void testSave() throws Exception {
        UserMeal created = getCreated();
        service.save(created, START_SEQ);
        MATCHER.assertListEquals(Arrays.asList(created, MEAL4, MEAL3, MEAL2, MEAL1), service.getAll(START_SEQ));
    }

    @Test
    public void testGet() throws Exception {
        UserMeal actual = service.get(MEAL1_ID, START_SEQ);
        MATCHER.assertEquals(MEAL1, actual);
    }

    //    @Test(expected = NotFoundException.class)
    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(MEAL1_ID, START_SEQ + 1);
    }

    @Test
    public void testUpdate() throws Exception {
        UserMeal updated = getUpdated();
        service.update(updated, START_SEQ);
        MATCHER.assertEquals(updated, service.get(MEAL1_ID, START_SEQ));
    }

    //    @Test(expected = NotFoundException.class)
    @Test
    public void testNotFoundUpdate() throws Exception {
        UserMeal item = service.get(MEAL1_ID, START_SEQ);
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + MEAL1_ID);
        service.update(item, START_SEQ + 1);
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertListEquals(Arrays.asList(MEAL4, MEAL3, MEAL2, MEAL1), service.getAll(START_SEQ));
    }

    @Test
    public void testGetBetween() throws Exception {
        MATCHER.assertListEquals(Arrays.asList(MEAL2, MEAL1),
                service.getBetween(LocalDateTime.of(2015, 1, 6, 8, 0), LocalDateTime.of(2015, 1, 6, 14, 0), START_SEQ));
    }

    @Test
    public void testDeleteAll() throws Exception {
        service.deleteAll(START_SEQ);
        Assert.assertEquals(0, service.getAll(START_SEQ).size());
    }
}
