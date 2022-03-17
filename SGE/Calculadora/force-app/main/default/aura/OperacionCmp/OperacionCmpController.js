({


    resolver: function(component, event, helper) {
        var numero1 = component.find("numero1").getElement().value;
        var numero2 = component.find("numero2").getElement().value;
        var operador = component.find("operador").getElement().value;
        console.log(operador);
        var appEvent = $A.get("e.c:OperacionEvent")
        console.log(appEvent)
        
        appEvent.setParams({"numero1" : numero1, "numero2" : numero2, "operador" : operador})
        appEvent.fire()
    }
})
