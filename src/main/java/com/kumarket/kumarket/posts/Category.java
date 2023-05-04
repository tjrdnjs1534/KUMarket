package com.kumarket.kumarket.posts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum Category {
    BOOK("Book"),
    ELC("Electric");

    private final String key;

}
