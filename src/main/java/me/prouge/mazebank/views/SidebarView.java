package me.prouge.mazebank.views;

import javafx.scene.layout.AnchorPane;

import javax.inject.Singleton;

@Singleton
public class SidebarView extends Component<AnchorPane> {


    public SidebarView() {
        super("sidebar.fxml", new AnchorPane());
    }
}
