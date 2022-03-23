({
    myAction : function(component, event, helper) {

    },
    comprobar : function(component, event){
        var eleccion = event.getParam("eleccion");
        component.set("v.jugador", eleccion);

        var action = component.get("c.getString");

        action.setCallback(this, function(response) {
            
            var state = response.getState();
            if (state === "SUCCESS") {
                var result = response.getReturnValue();
                component.set("v.cpu", result);
                console.log(result);
            }
        
        });
        $A.enqueueAction(action);

        
    },
    ganador : function(component, event){
        console.log("hols")
        var jugador = component.get("v.jugador");
        var cpu = component.get("v.cpu");
        if(jugador == "tijera" && cpu == "papel"){
            component.set("v.ganador", "Jugador");
        } else if(jugador == "papel" && cpu == "piedra"){
            component.set("v.ganador", "Jugador");
        } else if(jugador == "piedra" && cpu == "tijera"){
            component.set("v.ganador", "Jugador");
        } else if(jugador == cpu){
            component.set("v.ganador", "la amistad");
        } else {
            component.set("v.ganador", "CPU");
        }
    }
})
