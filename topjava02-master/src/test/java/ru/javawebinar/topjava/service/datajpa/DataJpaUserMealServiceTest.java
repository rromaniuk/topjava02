package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserMealServiceTest;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, DATAJPA})
public class DataJpaUserMealServiceTest extends UserMealServiceTest {
}