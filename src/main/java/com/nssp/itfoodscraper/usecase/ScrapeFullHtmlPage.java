package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface ScrapeFullHtmlPage {
    HtmlPage requestByHtmlPage(String htmlPage);
}
