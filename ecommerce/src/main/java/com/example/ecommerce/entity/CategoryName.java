package com.example.ecommerce.entity;

import lombok.Getter;

@Getter
public enum CategoryName {
    CLOTHING("Clothing"),
    JEWELRY("Jewelry"),
    HOME_AND_LIVING("Home & Living"),
    WEDDINGS("Weddings"),
    CRAFT_SUPPLIES("Craft Supplies"),
    VINTAGE("Vintage"),
    ART_AND_COLLECTIBLES("Art & Collectibles"),
    TOYS_AND_GAMES("Toys & Games"),
    BATH_AND_BEAUTY("Bath & Beauty"),
    PET_SUPPLIES("Pet Supplies");

    private final String displayName;

    CategoryName(String displayName) {
        this.displayName = displayName;
    }

}
