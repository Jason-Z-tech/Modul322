package com.schule.base.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

import java.time.LocalTime;

@Route("neu")
public class NeueErinnerungView extends VerticalLayout {

    public NeueErinnerungView() {

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
        HorizontalLayout topBar = new HorizontalLayout(moonIcon, new Span(""), profileIcon);
        topBar.setWidthFull();
        topBar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        H1 title = new H1("Neue Erinnerung");

        TextField titel = new TextField("Titel");
        titel.setPlaceholder("z.B. Arzttermin");
        titel.setRequiredIndicatorVisible(true);

        TextArea beschreibung = new TextArea("Beschreibung (optional)");

        TimePicker zeit = new TimePicker("Uhrzeit");
        zeit.setStep(java.time.Duration.ofMinutes(15));
        zeit.setMin(LocalTime.of(0, 0));
        zeit.setMax(LocalTime.of(23, 45));
        zeit.setRequiredIndicatorVisible(true);

        DatePicker datum = new DatePicker("Datum");

        Select<String> zugriff = new Select<>();
        zugriff.setLabel("Zugriff Auswahl");
        zugriff.setItems("Bewohner", "Tochter", "Pflege", "Alle");
        zugriff.setValue("Alle");

        Select<String> kategorie = new Select<>();
        kategorie.setLabel("Kategorie");
        kategorie.setItems("Essen", "Aktivitaet", "Medikamente", "Besuch");
        kategorie.setPlaceholder("Bitte waehlen");

        Button busy = new Button("Termin ist belegt");
        busy.addThemeVariants(ButtonVariant.LUMO_ERROR);
        busy.getElement().setProperty("title", "Dieser Zeitslot ist bereits belegt");
        busy.setVisible(false);

        // 08:00–15:00 frei, danach besetzt; vor Eingabe unsichtbar
        zeit.addValueChangeListener(event -> {
            LocalTime value = event.getValue();

            if (value == null) {
                busy.setVisible(false);
                return;
            }

            boolean isFree = !value.isBefore(LocalTime.of(8, 0)) && !value.isAfter(LocalTime.of(15, 0));
            busy.setVisible(!isFree);
        });

        Button back = new Button(VaadinIcon.BACKWARDS.create(),
                e -> UI.getCurrent().navigate(MainView.class));

        Button save = new Button(VaadinIcon.DOWNLOAD.create(),
                e -> UI.getCurrent().navigate(MainView.class));

        HorizontalLayout bottom = new HorizontalLayout(back, save);
        bottom.setWidthFull();
        bottom.setJustifyContentMode(JustifyContentMode.BETWEEN);

        content.add(
                topBar,
                title,
                titel,
                beschreibung,
                zeit,
                datum,
                zugriff,
                kategorie,
                busy,
                bottom
        );

        phone.add(content);
        add(phone);
    }
}
