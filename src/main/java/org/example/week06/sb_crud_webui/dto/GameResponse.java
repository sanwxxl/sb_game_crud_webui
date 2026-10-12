package org.example.week06.sb_crud_webui.dto;

public record GameResponse(Long id, String name, String company, int price, String genre, int playTime) {
}
