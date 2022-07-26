package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@AllArgsConstructor
public class ExtractCardSectionFromHtmlImpl implements ExtractCardSectionFromHtml {
    private ScrapeFullHtmlPage fullHtmlPage;
    private ExtractDetailFromRecipe recipePage;
    @Override
    public String getRecipes(String htmlPage) {
        var page = fullHtmlPage.requestByHtmlPage(htmlPage);
        var baseUrl = page.getBaseURL().toString();
        StringBuilder recipes = new StringBuilder();
        if(page != null) {
            List<?> anchors = page.getByXPath("//a[@class='card-link']");
            AtomicBoolean ongoing = new AtomicBoolean(true);
            anchors.stream().takeWhile(value -> ongoing.get()).forEach( a -> {
                HtmlAnchor link = (HtmlAnchor) a;
              //  recipes.append("Title: ").append(link.getAttribute("title").replace(',', ';'));
               // recipes.append("\n");
                recipes.append(baseUrl).append(link.getHrefAttribute().replaceFirst("/", ""));
               // recipes.append("\n");
                ongoing.set(false);

            });
            recipePage.get(recipes.toString());
        }
        return recipes.toString();
    }
}
