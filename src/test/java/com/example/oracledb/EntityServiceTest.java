package com.example.oracledb;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.oracle.OracleContainer;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Testcontainers
public class EntityServiceTest {

    @Inject
    EntityService entityService;

    static String image = "gvenzl/oracle-free:23.6-slim-faststart";

    @Container
    static OracleContainer oracleContainer = new OracleContainer(image)
            .withStartupTimeout(Duration.ofMinutes(3))
            .withUsername("testuser")
            .withPassword("testpwd");


    @Test
    @DisplayName("Teste")
    public void getConnection() {
        var entity = new MyEntity();
        entity.field = "Teste";
        entityService.save(entity);

        long count = MyEntity.count();
        assertEquals(1, count);

        MyEntity persisted = MyEntity.findAll().firstResult();
        assertNotNull(persisted);
    }
}



