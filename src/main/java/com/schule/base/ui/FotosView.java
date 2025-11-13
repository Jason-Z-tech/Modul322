package com.schule.base.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("fotos")
public class FotosView extends VerticalLayout {

    public FotosView() {

        setSizeFull();
        getStyle().set("background-color", "#ffffffff");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Div phone = new Div();
        phone.getStyle()
                .set("max-width", "430px")
                .set("height", "900px")
                .set("margin", "24px auto")
                .set("border-radius", "30px")
                .set("border", "8px solid black")
                .set("overflow", "hidden")
                .set("background-color", "#28A9FF");

        VerticalLayout content = new VerticalLayout();
        content.setPadding(true);
        content.setSpacing(true);
        content.setWidthFull();

        Icon moonIcon = VaadinIcon.MOON_O.create();
        Icon profileIcon = VaadinIcon.USER.create();
        Button back = new Button(VaadinIcon.BACKWARDS.create(),
                e -> UI.getCurrent().navigate(MainView.class));

        HorizontalLayout topBar = new HorizontalLayout(moonIcon, back, new Span(""), profileIcon);
        topBar.setWidthFull();
        topBar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        topBar.setAlignItems(Alignment.CENTER);

        H1 title = new H1("Fotos und Lieder");

        VerticalLayout fotoBox = new VerticalLayout();
        fotoBox.setWidthFull();
        fotoBox.setHeight("200px");
        fotoBox.getStyle().set("background-color", "#e0e0e0");
        Span fotoLabel = new Span("Foto Bild");
        Button prevFoto = new Button(VaadinIcon.ANGLE_LEFT.create());
        Button nextFoto = new Button(VaadinIcon.ANGLE_RIGHT.create());
        HorizontalLayout fotoNav = new HorizontalLayout(prevFoto, nextFoto);
        fotoNav.setJustifyContentMode(JustifyContentMode.BETWEEN);
        fotoNav.setWidthFull();

        Span beschriftung = new Span("Anna aufm Bild");
        Button addFoto = new Button("+");
        Button removeFoto = new Button("-");

        HorizontalLayout fotoActions = new HorizontalLayout(beschriftung, addFoto, removeFoto);
        fotoActions.setWidthFull();
        fotoActions.setJustifyContentMode(JustifyContentMode.BETWEEN);

        fotoBox.add(fotoLabel);

        VerticalLayout musikBox = new VerticalLayout();
        musikBox.setWidthFull();
        musikBox.setHeight("200px");
        musikBox.getStyle().set("background-color", "#e0e0e0");
        Span musikIcon = new Span("♪");
        Button prevSong = new Button(VaadinIcon.ANGLE_LEFT.create());
        Button nextSong = new Button(VaadinIcon.ANGLE_RIGHT.create());
        HorizontalLayout songNav = new HorizontalLayout(prevSong, nextSong);
        songNav.setWidthFull();
        songNav.setJustifyContentMode(JustifyContentMode.BETWEEN);
        Button play = new Button("Play");
        Button addSong = new Button("+");
        Button removeSong = new Button("-");

        HorizontalLayout musikBottom = new HorizontalLayout(play, removeSong, addSong);
        musikBottom.setWidthFull();
        musikBottom.setJustifyContentMode(JustifyContentMode.BETWEEN);

        musikBox.add(musikIcon, songNav, play);

        content.add(
                topBar,
                title,
                fotoBox,
                fotoNav,
                fotoActions,
                musikBox,
                songNav,
                musikBottom
        );

        phone.add(content);
        add(phone);
    }
}
