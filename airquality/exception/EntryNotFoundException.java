package br.com.fiap.airquality.exception;

public class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException() {
        super("Entry not found.");
    }
}
