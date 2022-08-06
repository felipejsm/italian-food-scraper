package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface ExtractDetailFromRecipe {
    String getIngredients(HtmlPage recipePage);
    String getMethod(HtmlPage recipePage);
    String getRecipeHeader(HtmlPage recipePage);
    String getRecipeDescription(HtmlPage recipePage);
}
