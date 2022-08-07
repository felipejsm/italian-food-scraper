package com.nssp.itfoodscraper.usecase;

import com.nssp.itfoodscraper.model.Recipe;

import java.util.List;

public interface ExtractCardSectionFromHtml {
    List<Recipe> getRecipes(String htmlPage);
}
