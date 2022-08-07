package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.nssp.itfoodscraper.model.Recipe;

public interface ExtractDetailFromRecipe {
    String getIngredients(HtmlPage recipePage);
    String getMethod(HtmlPage recipePage);
    String getRecipeHeader(HtmlPage recipePage);
    String getRecipeDescription(HtmlPage recipePage);
    Recipe getRecipe(HtmlPage recipePage);
}
