module me.prouge.mazebank {
    requires javafx.controls;
    requires me.prouge.guicefx;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires jakarta.inject;
    requires com.google.guice;
    requires org.hibernate.orm.core;
    requires org.reflections;
    requires static lombok;

    opens me.prouge.mazebank;
    opens me.prouge.mazebank.entities;
    opens me.prouge.mazebank.controllers;
    opens me.prouge.mazebank.utils;
    opens me.prouge.mazebank.views;
    opens me.prouge.mazebank.service;
    opens me.prouge.mazebank.views.authentication;

    exports me.prouge.mazebank;
}
