package com.example.hh_market.item.dto;

import com.example.hh_market.item.entity.Item;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ItemDto {

    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public static ItemDto from(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .username(item.getUsername())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .build();
    }

    public static ItemDto fromAll(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .username(item.getUsername())
                .title(item.getTitle())
                .price(item.getPrice())
                .build();
    }


    public static Item toEntity(ItemDto itemDto) {
        return Item.builder()
                .title(itemDto.getTitle())
                .content(itemDto.getContent())
                .price(itemDto.getPrice())
                .username(itemDto.getUsername())
                .build();
    }
}
