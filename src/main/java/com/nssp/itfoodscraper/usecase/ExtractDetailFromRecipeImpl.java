package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLDivElement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class ExtractDetailFromRecipeImpl implements ExtractDetailFromRecipe {
    private ScrapeFullHtmlPage fullHtmlPage;
    @Override
    public String get(String fullUrl) {
        var page = fullHtmlPage.requestByHtmlPage(fullUrl);
        final List<?> divs = page.getByXPath("//div");
        divs.forEach(d -> {
            var currentDiv = (HtmlDivision)d;
            //currentDiv.getByXPath("//div[@class='card-content']")
            var divClass = currentDiv.getNodeValue();
        });
        return null;
    }
}
