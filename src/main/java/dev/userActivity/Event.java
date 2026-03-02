package dev.userActivity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Event(String type, Repo repo, @JsonProperty("created_at")@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") LocalDateTime createdAt) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Repo(String name, String url){}
}
