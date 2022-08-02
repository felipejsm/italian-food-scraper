package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface ExtractDetailFromRecipe {
    String get(HtmlPage newPage);
    String getPAgeByUrl(String uri);
}
