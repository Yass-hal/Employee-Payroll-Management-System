package model;
//carries the authenticated user's identity
public record UserSession(int userId, String username, String role) {}
