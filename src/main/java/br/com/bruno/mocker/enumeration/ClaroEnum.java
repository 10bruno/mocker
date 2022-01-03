package br.com.bruno.mocker.enumeration;

public enum ClaroEnum {

    CLARO_DEFAULT("./src/main/java/br/com/bruno/mocker/util/claro/default.json"),
    CLARO_200("./src/main/java/br/com/bruno/mocker/util/claro/200.json"),
    CLARO_400("./src/main/java/br/com/bruno/mocker/util/claro/400.json"),
    CLARO_500("./src/main/java/br/com/bruno/mocker/util/claro/500.json");

    public final String local;

    ClaroEnum(String local) {
        this.local = local;
    }

}
