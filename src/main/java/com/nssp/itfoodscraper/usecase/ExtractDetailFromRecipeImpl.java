package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExtractDetailFromRecipeImpl implements ExtractDetailFromRecipe {
    private static final String INGREDIENTS_XPATH = "//div[normalize-space(@class)='recipe-tab-container']//div[normalize-space(@class)='ingredient']";
    private static final String METHOD_XPATH = "//div[@class='recipe-text']//p";
    private static final String HEADER_XPATH = "//ul[@class='recipe-head']//li";
    private static final String DESCRIPTION_XPATH = "//h1[@itemprop='name'] | //h2[@itemprop='description']";
    @Override
    public String getIngredients(HtmlPage recipePage) {
        var ingredients = recipePage.getByXPath(INGREDIENTS_XPATH);
        for (Object ingredient: ingredients) {
            var ingred = (HtmlDivision) ingredient;
            System.out.println(ingred.getTextContent());
        }
        return null;
    }

    @Override
    public String getMethod(HtmlPage recipePage) {
        return null;
    }

    @Override
    public String getRecipeHeader(HtmlPage recipePage) {
        return null;
    }

    @Override
    public String getRecipeDescription(HtmlPage recipePage) {
        return null;
    }
}
