package me.prouge.mazebank.utils;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    EntityManager provideEntityManager() {
        return Persistence.createEntityManagerFactory("app-unit").createEntityManager();
    }
}
