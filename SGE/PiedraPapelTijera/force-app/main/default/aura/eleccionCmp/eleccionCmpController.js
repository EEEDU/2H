({
    myAction : function(component, event, helper) {

    },
    seleccionar: function(component, event, helper) {
        var eleccion = component.find("eleccion").getElement().value;

        var appEvent = $A.get("e.c:eleccionEvent");
        appEvent.setParams({"eleccion": eleccion});
        appEvent.fire();
    }
})
