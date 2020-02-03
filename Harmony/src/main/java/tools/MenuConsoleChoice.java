package tools;

public enum MenuConsoleChoice {

    k("wyswietlic kola kwintowe"),
    t("stworzyc triade harmoniczna"),
    p("sprawdzic swoja wiedze"),
    s("wyswietlic opis programu"),
    z("zakonczyc"),
    n("budowac trojdzwieki"),
    b("znajdowac akordy triady harmonicznej"),
    v("budowac triade harmoniczna"),
    q("wrocic do menu glownego");


    final String description;

    MenuConsoleChoice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
