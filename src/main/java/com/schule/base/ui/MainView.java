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

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
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

        Span spacer = new Span();
        spacer.setWidthFull();

        HorizontalLayout topBar = new HorizontalLayout(moonIcon, spacer, profileIcon);
        topBar.setWidthFull();
        topBar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        H1 title = new H1("Meine Erinnerungen");

        Button prevDay = new Button(VaadinIcon.ANGLE_LEFT.create());
        Button nextDay = new Button(VaadinIcon.ANGLE_RIGHT.create());
        Span dateLabel = new Span("Montag 11.11.2027");
        HorizontalLayout dateBar = new HorizontalLayout(prevDay, dateLabel, nextDay);
        dateBar.setAlignItems(Alignment.CENTER);
        dateBar.setJustifyContentMode(JustifyContentMode.CENTER);
        dateBar.setWidthFull();

        VerticalLayout list = new VerticalLayout();
        list.setWidthFull();
        list.setPadding(false);
        list.setSpacing(true);

        list.add(createReminderRow("08:30 UHR", "Spaziergang"));
        list.add(createReminderRow("09:30 UHR", "Fruehstueck"));
        list.add(createReminderRow("11:30 UHR", "Medikamente"));
        list.add(createReminderRow("14:30 UHR", "Tochter zu Besuch"));
        list.add(createReminderRow("18:30 UHR", "Abendessen"));

        Button addButton = new Button(VaadinIcon.PLUS.create(),
                e -> UI.getCurrent().navigate(NeueErinnerungView.class));
        Button deleteButton = new Button(VaadinIcon.MINUS.create());
        Button fotosButton = new Button("Fotos und Lieder",
                e -> UI.getCurrent().navigate(FotosView.class));

        addButton.getStyle().set("border-radius", "999px");
        deleteButton.getStyle().set("border-radius", "999px");
        fotosButton.getStyle()
                .set("background-color", "#ff4444")
                .set("color", "white")
                .set("border-radius", "12px");

        HorizontalLayout bottomBar = new HorizontalLayout();
        bottomBar.getStyle().set("margin-top", "200px");
        bottomBar.setWidthFull();
        bottomBar.setJustifyContentMode(JustifyContentMode.BETWEEN);
        bottomBar.setAlignItems(Alignment.END);

        Span addText = new Span("Erinnerung hinzufügen");
        addText.getStyle()
                .set("font-size", "14px")
                .set("text-align", "center");

        VerticalLayout left = new VerticalLayout(addButton, addText);
        left.setAlignItems(Alignment.CENTER);
        left.setPadding(false);
        left.setSpacing(false);
        left.setWidth("150px"); 

        Span deleteText = new Span("Erinnerung löschen");
        deleteText.getStyle()
                .set("font-size", "14px")
                .set("text-align", "center");

        VerticalLayout right = new VerticalLayout(deleteButton, deleteText);
        right.setAlignItems(Alignment.CENTER);
        right.setPadding(false);
        right.setSpacing(false);
        right.setWidth("150px");

        bottomBar.add(left, fotosButton, right);
        content.add(topBar, title, dateBar, list, bottomBar);
        phone.add(content);
        add(phone);
    }

    private HorizontalLayout createReminderRow(String time, String text) {

        Span timeLabel = new Span(time);
        Span textLabel = new Span(text);

        VerticalLayout right = new VerticalLayout(timeLabel, textLabel);
        right.setPadding(false);
        right.setSpacing(false);

        HorizontalLayout row = new HorizontalLayout( right);
        row.setWidthFull();
        row.getStyle().set("background-color", "#5146B8");
        row.setAlignItems(Alignment.CENTER);
        return row;
    }
}
