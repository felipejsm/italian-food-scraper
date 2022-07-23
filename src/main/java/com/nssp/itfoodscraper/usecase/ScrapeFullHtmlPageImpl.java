package com.nssp.itfoodscraper.usecase;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.nssp.itfoodscraper.configuration.ScrapperConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;

@Component
@AllArgsConstructor
public class ScrapeFullHtmlPageImpl implements ScrapeFullHtmlPage {
    private ScrapperConfiguration configuration;
    @Override
    public HtmlPage requestByHtmlPage(String htmlPage) {
        var client = configuration.getClient();
        HtmlPage myPage = null;
        try {
            myPage = client.getPage(htmlPage);
            client.getCurrentWindow().getJobManager().removeAllJobs();

        } catch(MalformedURLException malformedURLException) {
            System.err.println("An error occurred: "+malformedURLException.getMessage());
        } catch(IOException ioException) {
            System.err.println("An error occurred: "+ioException.getMessage());
        }
        return myPage;
    }
}
