({
    myAction : function(component, event, helper) {

    },
    resolver : function(component, event, helper) {
        var numero1 = event.getParam("numero1");
        var numero2 = event.getParam("numero2");
        var operador = event.getParam("operador");

        if (operador == "suma"){
            console.log(parseInt(numero1) + parseInt(numero2))
            component.find("resultado").getElement().value = parseInt(numero1) + parseInt(numero2)
        } else if (operador == "resta"){
            component.find("resultado").getElement().value = parseInt(numero1) - parseInt(numero2);
        } else if (operador == "multiplicacion"){
            component.find("resultado").getElement().value = parseInt(numero1) * parseInt(numero2);
        } else if (operador == "division"){
            component.find("resultado").getElement().value = parseInt(numero1) / parseInt(numero2);
        }
    }
})
