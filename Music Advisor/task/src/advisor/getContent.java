package advisor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Receive and process information on requests
 */
class GetContent {
    static String CATEGORIES = "/v1/browse/categories";
    static String NEW = "/v1/browse/new-releases";
    static String FEATURED = "/v1/browse/featured-playlists";
    static String PLAYLIST = "/v1/browse/categories/";

    /**
     * GET request with access token
     * @param _path - String, uri path
     * @return - String, answer of the server
     */
    public String getRequest(String _path) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + Authorisation.ACCESS_TOKEN)
                .uri(URI.create(_path))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            assert response != null;
            return response.body();

        } catch (InterruptedException | IOException e) {
            return "Error response";
        }
    }

    /**
     * Getting featured from site
     * @return - String, formatted output result of the request
     */
    public String getFeatured(){
        List<Info> infos = new ArrayList<>();
        String response = getRequest(Authorisation.API_SERVER_PATH + FEATURED);

        JsonObject jo = JsonParser.parseString(response).getAsJsonObject();
        JsonObject categories = jo.getAsJsonObject("playlists");

        for (JsonElement item : categories.getAsJsonArray("items")) {
            Info element = new Info();
            element.setAlbum(item.getAsJsonObject().get("name").toString().replaceAll("\"", ""));

            element.setLink(item.getAsJsonObject().get("external_urls")
                    .getAsJsonObject().get("spotify")
                    .toString().replaceAll("\"", ""));

            infos.add(element);
        }
        StringBuilder result = new StringBuilder();
        for (Info each : infos) {
            result.append(each.album).append("\n")
                    .append(each.link).append("\n")
                    .append("\n");
        }
        return result.toString();
    }


}