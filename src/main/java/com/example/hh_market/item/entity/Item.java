package com.example.hh_market.item.entity;

import com.example.hh_market.item.dto.ItemDto;
import jakarta.persistence.*;
import lombok.*;

/*
- 테이블명 : Item
    - id : 게시글 번호 (DB 인덱스)
    - title (String) :  게시글 제목
    - content (String) : 게시글 내용
    - price(int) : 가격
    - username : 작성자
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name ="Item")
public class Item {
    // 게시글 번호
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "price")
    private int price;

    @Column(name = "username")
    private String username;

    public void updateFromDto(ItemDto itemDto) {
        this.title = itemDto.getTitle();
        this.content = itemDto.getContent();
        this.price = itemDto.getPrice();
        this.username = itemDto.getUsername();
    }

}
