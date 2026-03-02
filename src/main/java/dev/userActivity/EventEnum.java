package dev.userActivity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum EventEnum {
    CommitCommentEvent("Created a commit comment"),
    CreateEvent("A Git branch or tag is created"),
    DeleteEvent("A Git branch or tag is deleted"),
    DiscussionEvent("A discussion is created in a repository"),
    ForkEvent("A user forked a repository"),
    GollumEvent("A wiki page is created or updated"),
    IssueCommentEvent("Activity related to an issue or pull request comment"),
    IssuesEvent("Activity related to an issue"),
    MemberEvent("Activity related to repository collaborators"),
    PublicEvent("When a private repository is made public"),
    PullRequestEvent("Activity related to pull requests"),
    PullRequestReviewEvent("Activity related to pull request reviews"),
    PullRequestReviewCommentEvent("Activity related to pull request review comments in the pull request's unified diff"),
    PushEvent("One or more commits are pushed to a repository branch or tag"),
    ReleaseEvent("Activity related to a release"),
    WatchEvent("When someone stars a repository"),
    @JsonEnumDefaultValue
    Unknown("Unknown activity");

    private String text;

    EventEnum(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public static EventEnum fromString(String type) {
        try {
            return EventEnum.valueOf(type);
        } catch (IllegalArgumentException e) {
            return Unknown;
        }
    }
}
