package advisor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The engine of the advisor. Here are all the methods of work.
 */
public class Service {
    boolean isAuthorised = false;
    GetContent getContent = new GetContent();

    String releases = "Mountains [Sia, Diplo, Labrinth]\n" +
            "Runaway [Lil Peep]\n" +
            "The Greatest Show [Panic! At The Disco]\n" +
            "All Out Life [Slipknot]";
    String featured = "Mellow Morning\n" +
            "Wake Up and Smell the Coffee\n" +
            "Monday Motivation\n" +
            "Songs to Sing in the Shower";
    String categories = "Top Lists\n" +
            "Pop\n" +
            "Mood\n" +
            "Latin";
    String playlists = "Walk Like A Badass  \n" +
            "Rage Beats  \n" +
            "Arab Mood Booster  \n" +
            "Sunday Stroll";

    public void setAuthorization() {
        Authorisation authorisation = new Authorisation();
        authorisation.getAccessCode();
        authorisation.getAccessToken();
        this.isAuthorised = true;
    }

    public String getReleases() {
        if (isAuthorised) {
            return getContent.getReleases();
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getFeatured() {
//        if (isAuthorised) {
//            return "---FEATURED---\n" + featured;
//        }
        if (isAuthorised) {
            return getContent.getFeatured();
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getCategories() {
        if (isAuthorised) {
            return "---CATEGORIES---\n" + categories;
        } else {
            return "Please, provide access for application.";
        }
    }

    public String getPlaylists() {
        if (isAuthorised) {
            return "---MOOD PLAYLISTS---\n" + playlists;
        } else {
            return "Please, provide access for application.";
        }
    }
}