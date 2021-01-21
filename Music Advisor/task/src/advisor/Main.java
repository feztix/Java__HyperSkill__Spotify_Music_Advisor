
package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        while(!query.equals("exit")) {
            switch (query) {
                case("auth"):
                    System.out.println("https://accounts.spotify.com/authorize?client_id=40e3cdf40f624b6396e8116f712c48aa&redirect_uri=http://localhost:8080&response_type=code");
                    System.out.println(service.setAuthorization(true));
                    break;
                case ("new"):
                    System.out.println(service.getReleases());
                    break;
                case ("featured"):
                    System.out.println(service.getFeatured());
                    break;
                case ("categories"):
                    System.out.println(service.getCategories());
                    break;
                case ("playlists Mood"):
                    System.out.println(service.getPlaylists());
                    break;
            }
            query = scanner.nextLine();
        }
        service.setAuthorization(false);
        System.out.println("---GOODBYE!---");
    }
}