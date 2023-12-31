module me.prouge.mazebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires javax.inject;
    requires com.google.guice;
    requires org.hibernate.orm.core;

    opens me.prouge.mazebank;
    opens me.prouge.mazebank.entities;
    opens me.prouge.mazebank.utils;
    exports me.prouge.mazebank;
}
