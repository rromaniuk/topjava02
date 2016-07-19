package ru.javawebinar.topjava.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserMealServiceTest;

import static ru.javawebinar.topjava.Profiles.JDBC;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, JDBC})
public class JdbcUserMealServiceTest extends UserMealServiceTest {
}