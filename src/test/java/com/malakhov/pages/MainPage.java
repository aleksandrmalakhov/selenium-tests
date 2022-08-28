package com.malakhov.pages;

import com.malakhov.elements.Footer;
import com.malakhov.elements.Header;
import lombok.Getter;

@Getter
public class MainPage extends BasePage {
    private final Header header;
    private final Footer footer;

    public MainPage(){
        super();
        header = new Header();
        footer = new Footer();
    }
}
