module me.prouge.mazebank {
    requires javafx.controls;
    requires me.prouge.guicefx;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires javax.inject;
    requires com.google.guice;
    requires org.hibernate.orm.core;
    requires reflections;
    requires static lombok;

    opens me.prouge.mazebank;
    opens me.prouge.mazebank.entities;
    opens me.prouge.mazebank.controllers;
    opens me.prouge.mazebank.utils;
    opens me.prouge.mazebank.views;
    opens me.prouge.mazebank.views.navigation;
    opens me.prouge.mazebank.utils;

    exports me.prouge.mazebank;
}
