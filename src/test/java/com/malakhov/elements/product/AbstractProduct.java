package com.malakhov.elements.product;

public interface AbstractProduct {
    boolean isSale();
    boolean isNew();
    String getTitle();
    String getShortDesc();
    String getOldPrice();
    String getNewPrice();
}