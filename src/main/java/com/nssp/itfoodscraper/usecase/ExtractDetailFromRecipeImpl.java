package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSection;
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
    public String get(HtmlPage newPage) {
        var sections = newPage.getByXPath("//section[@class='article-head']");
        for (Object section: sections) {
            var s = (HtmlSection) section;
            System.out.println(s.toString());
        }
        return null;
    }

    @Override
    public String getPAgeByUrl(String uri) {
        var ful = fullHtmlPage.requestByHtmlPage(uri);
        var wr = ful.getWebResponse();
        return null;
    }

    private void printRecipe(List<?> recipes) {
        for (Object recipe : recipes) {
           var r = (HtmlDivision) recipe;
            System.out.println(r.getTextContent());
        }
    }
}
