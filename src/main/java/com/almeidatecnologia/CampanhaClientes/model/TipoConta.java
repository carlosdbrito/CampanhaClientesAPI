package com.almeidatecnologia.CampanhaClientes.model;

public enum TipoConta {
    Poupanca(0),
    ContaCorrente(1);

    private final int valor;

    TipoConta(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
        
    public static TipoConta fromInt(int valor) {
        for (TipoConta tipo : TipoConta.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TipoConta: " + valor);
    }
    
}