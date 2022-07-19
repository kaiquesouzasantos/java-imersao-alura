package Dia_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser{
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {
        // tratamento do json com o matcher -> verifica cada char e compara com o REGEX
        Matcher matcher = REGEX_ITEMS.matcher(json);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("},\\{");
        List<Map<String, String>> dados = new ArrayList<>();

        // adicao de cada item a lista
        for (String item : items) {
            Map<String, String> atributosItem = new HashMap<>();
            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);

            // categoriza (key, value)
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }
            dados.add(atributosItem);
        }

        return dados;
    }
}
