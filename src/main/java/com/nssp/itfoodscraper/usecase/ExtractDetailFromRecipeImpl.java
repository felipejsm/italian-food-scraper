package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.*;
import com.nssp.itfoodscraper.model.Recipe;
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
        StringBuilder ingredient = new StringBuilder();
        ingredients.forEach(i -> {
            var div = (HtmlDivision)i;
            ingredient.append(div.getTextContent()).append("\n");
        });
        return ingredient.toString();
    }

    @Override
    public String getMethod(HtmlPage recipePage) {
        var methods = recipePage.getByXPath(METHOD_XPATH);
        StringBuilder method = new StringBuilder();
        methods.forEach(m -> {
            var paragraph = (HtmlParagraph)m;
            method.append(paragraph.getTextContent()).append("\n");
        });
        return method.toString();
    }

    @Override
    public String getRecipeHeader(HtmlPage recipePage) {
        var headers = recipePage.getByXPath(HEADER_XPATH);
        StringBuilder header= new StringBuilder();
        headers.forEach(h -> {
            var listItem = (HtmlListItem) h;
            var span = (HtmlSpan)listItem.getFirstChild();
            var strong = (HtmlStrong) listItem.getLastChild();
            header.append(span.getTextContent()).append(" ").append(strong.getTextContent()).append("\n");
        });
        return header.toString();
    }

    @Override
    public String getRecipeDescription(HtmlPage recipePage) {
        var descriptions = recipePage.getByXPath(DESCRIPTION_XPATH);
        StringBuilder description = new StringBuilder();
        descriptions.forEach(d -> {
            if(d instanceof HtmlHeading2 h2) {
                description.append(h2.getTextContent()).append("\n");
            }
            if(d instanceof HtmlHeading3 h3) {
                description.append(h3.getTextContent()).append("\n");
            }
        });
        return description.toString();
    }

    @Override
    public Recipe getRecipe(HtmlPage recipePage) {
        Recipe recipe = new Recipe();
        String ingredients = getIngredients(recipePage);
        String method = getMethod(recipePage);
        String header = getRecipeHeader(recipePage);
        String description = getRecipeDescription(recipePage);
        recipe.setDescription(description);
        recipe.setHeader(header);
        recipe.setIngredients(ingredients);
        recipe.setMethod(method);
        return recipe;
    }
}
