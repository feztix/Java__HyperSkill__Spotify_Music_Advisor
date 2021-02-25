package advisor;

public class Main {
    public static void main(String[] args) {

        if (args.length > 3 && args[0].equals("-access") && args[2].equals("-resource")) {
            Authorisation.SERVER_PATH = args[1];
            Authorisation.API_SERVER_PATH = args[3];
        }

        Advisor advisor = new Advisor();
        advisor.start();
    }
}