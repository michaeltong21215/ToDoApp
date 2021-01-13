package com.practice.todoapp.model;

public enum CategorizationEnum {
    LOVE("Love"),
    ART("Art"),
    SPORTS("Sports"),
    HOME("Home"),
    WORK("Work"),
    MUSIC("Music"),
    FOOD("Food"),
    IT("IT"),
    FUN("Fun"),
    FAMILY("Family"),
    RELIGION("Religion"),
    DANCE("Dance")
    ;
    private String value;

    CategorizationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CategorizationEnum parse(String value) {
        if (value != null) {
            for(CategorizationEnum enumValue : CategorizationEnum.values()) {
                if (enumValue.getValue().equals(value)) {
                    return enumValue;
                }
            }
        }
        return null;
    }
}
