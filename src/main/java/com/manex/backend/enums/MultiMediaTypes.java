package com.manex.backend.enums;

public enum MultiMediaTypes {
    EMPTY(""),
    JPG("JPG"),
    JPEG("JPEG"),
    PNG("PNG"),
    MP3("MP3"),
    MP4("MP4"),
    PDF("PDF"),
    DOC("DOC"),
    DOCX("DOCX"),
    CSV("CSV"),
    XLS("XLS"),
    XLSX("XLSX");

    private final String type;

    MultiMediaTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
