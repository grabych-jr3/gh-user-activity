package dev.userActivity;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivity {

    private String username;
    private String baseUrl;
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public UserActivity(String username){
        this.username = username;
        this.baseUrl = "https://api.github.com/users/" + this.username + "/events";
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public HttpResponse<String> sendRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Event> fetchActivities() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest();
        if(response.statusCode() != 200){
            throw new ActivitiesNotFoundException("User " + username + " not found!");
        }

        return objectMapper.readValue(response.body(), new TypeReference<>(){});
    }

    public void groupByEvent() throws IOException, InterruptedException {
        List<Event> events = fetchActivities();
        Map<EventEnum, List<Event>> eventsByType = events.stream().collect(Collectors.groupingBy(e -> EventEnum.fromString(e.type())));

        eventsByType.forEach((type, values) -> {
            System.out.println(type);
            System.out.println(type.getText());
            Map<String, List<Event>> eventsByRepo = values.stream().collect(Collectors.groupingBy(e -> e.repo().name()));
            eventsByRepo.forEach((repoName, e) -> {
                System.out.println("Repository name: " + repoName);
                e.forEach(event -> {
                    System.out.println("Repo url: " + event.repo().url() + "; Created at: " + event.createdAt());
                });
                System.out.println();
            });
            System.out.println("------------------");
        });
    }
}
