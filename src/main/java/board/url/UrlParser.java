package board.url;

import java.util.HashMap;
import java.util.Map;

public class UrlParser {
    public Url parse(String url) {
        if (url == null || !url.startsWith("/")) {
            throw new InvalidUrlException("잘못된 url 형식입니다.");
        }

        String[] parts = url.split("\\?");
        String[] pathParts = parts[0].split("/");

        String category = pathParts[1];
        String function = pathParts[2];

        Map<String, String> parameters = new HashMap<>();
        if (parts.length > 1) {
            String[] params = parts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                parameters.put(keyValue[0], keyValue[1]);
            }
        }

        return new Url(category, function, parameters);
    }
}
