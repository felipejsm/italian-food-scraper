package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.nssp.itfoodscraper.model.FoodNetwork;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
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
        StringBuilder recipes = new StringBuilder();
        if(page != null) {
            List<?> anchors = page.getByXPath("//a[@class='card-link']");
            AtomicBoolean ongoing = new AtomicBoolean(true);
            anchors.stream().takeWhile(value -> ongoing.get()).forEach( a -> {
                HtmlAnchor link = (HtmlAnchor) a;
                String pageUrl = recipes.append(FoodNetwork.BASE_URL.value).append(link.getHrefAttribute().replaceFirst("/", "")).toString();
                HtmlPage htmlRecipePage = fullHtmlPage.requestByHtmlPage(pageUrl);
                this.recipePage.getIngredients(htmlRecipePage);
                ongoing.set(false);
            });
        }
        return recipes.toString();
    }
}
