package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.nssp.itfoodscraper.model.FoodNetwork;
import com.nssp.itfoodscraper.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@AllArgsConstructor
public class ExtractCardSectionFromHtmlImpl implements ExtractCardSectionFromHtml {
    private final String RECIPES_ELEMENT = "//a[@class='card-link']";
    private ScrapeFullHtmlPage fullHtmlPage;
    private ExtractDetailFromRecipe recipePage;
    @Override
    public List<Recipe> getRecipes(String htmlPage) {
        List<Recipe> recipeList = new ArrayList<>();
        var page = fullHtmlPage.requestByHtmlPage(htmlPage);
        StringBuilder recipes = new StringBuilder();
        if(page != null) {
            List<?> anchors = page.getByXPath(RECIPES_ELEMENT);
           /*
            AtomicBoolean ongoing = new AtomicBoolean(true);
            anchors.stream().takeWhile(value -> ongoing.get()).forEach( a -> {
                HtmlAnchor link = (HtmlAnchor) a;
                String pageUrl = recipes.append(FoodNetwork.BASE_URL.value).append(link.getHrefAttribute().replaceFirst("/", "")).toString();
                HtmlPage htmlRecipePage = fullHtmlPage.requestByHtmlPage(pageUrl);
                recipeList.add(this.recipePage.getRecipe(htmlRecipePage));
                ongoing.set(false);//break foreach
            });
            */
            anchors.forEach( a -> {
                HtmlAnchor link = (HtmlAnchor) a;
                String pageUrl = recipes.append(FoodNetwork.BASE_URL.value).append(link.getHrefAttribute().replaceFirst("/", "")).toString();
                HtmlPage htmlRecipePage = fullHtmlPage.requestByHtmlPage(pageUrl);
                recipeList.add(this.recipePage.getRecipe(htmlRecipePage));
                recipes.setLength(0);
            });
        }
        return recipeList;
    }
}
