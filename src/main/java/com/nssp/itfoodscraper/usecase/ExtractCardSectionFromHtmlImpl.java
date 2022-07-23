package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ExtractCardSectionFromHtmlImpl implements ExtractCardSectionFromHtml {
    private ScrapeFullHtmlPage fullHtmlPage;
    @Override
    public String getRecipes(String htmlPage) {
        var page = fullHtmlPage.requestByHtmlPage(htmlPage);
        StringBuilder recipes = new StringBuilder();
        if(page != null) {
            List<?> anchors = page.getByXPath("//a[@class='card-link']");
            anchors.forEach( a -> {
                HtmlAnchor link = (HtmlAnchor) a;
                recipes.append("Title: ").append(link.getAttribute("title").replace(',', ';'));
                recipes.append("\n");
                recipes.append("Link: ").append(link.getHrefAttribute());
                recipes.append("\n");
            });
        }
        return recipes.toString();
    }
}
