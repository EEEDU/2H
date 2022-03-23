public with sharing class random {
    @AuraEnabled
    public static String getString() {
        List<String> listaEleccion = new List<String>{'piedra', 'papel', 'tijera'};
        Integer size = listaEleccion.size() - 1;
        Integer random = Integer.valueof((Math.random() * size));
        String randomString= listaEleccion[random];
        return randomString;
    }
}
