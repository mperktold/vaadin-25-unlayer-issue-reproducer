package com.example.application.views.helloworld;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@RouteAlias(value = "")
public class HelloWorldView extends VerticalLayout {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        var verticalLayout = new VerticalLayout();
        verticalLayout.add(new Button("Open alert", e -> new Dialog(new Text("Alert")).open()));
        verticalLayout.addAndExpand(new UnlayerEditor());
        verticalLayout.setHeight("70vh");
        verticalLayout.setWidth("70vw");
        new Dialog(verticalLayout).open();
    }

    @Tag("unlayer-editor")
    @JsModule("./src/unlayer-editor.ts")
    @JavaScript("https://editor.unlayer.com/embed.js")
    public static class UnlayerEditor extends Component {
    }
}
