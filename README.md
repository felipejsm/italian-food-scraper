## Italian Food Scraper in Java

Implementation from [Guide Java Web Scraping](https://www.webscrapingapi.com/java-web-scraping/) with [HtmlUnit](https://github.com/HtmlUnit/htmlunit)

### Pre-requisites

- Java 11 <= 17
- Maven
- Any flavour IDE

### My Custom Changes From Guide  
Although the guide is quite simple and complete in itself   
I wanted to put some more complexity on top of it  
So, I've run through every recipe and get its features such as header, ingredients, etc.  
By the end of the process shows output right in _System.out.print_

### How to Run

Via cli
```
mvn spring-boot:run
```

Sample output
```
[Recipe(ingredients=100g Parmigiano Reggiano, plus extra, to serve
400g linguine or spaghetti
25g butter
1 bunch spring onions, finely chopped
4 tbsp dry white wine
150g frozen petit pois or garden peas, thawed
100g Parma ham, torn into strips
Salt and freshly ground black pepper
Basil leaves, to garnish
, method=This easy pasta dish depends on fine ingredients to make it taste so special.
1. Grate the Parmigiano Reggiano finely and set to one side.
2. Cook the linguine or spaghetti in plenty of lightly salted boiling water for six to eight minutes until just tender, or follow the pack instructions.
3. Meanwhile, melt the butter and gently fry the spring onions until softened, about two minutes. Add the wine and let it bubble up for a few moments, then stir in the peas and heat gently for one or two minutes.
4. Reserving three tablespoons of the cooking liquid, drain the cooked pasta. Return it to the saucepan with the liquid. Stir in the spring onion and pea mixture, Parma ham and Parmigiano Reggiano. Re-heat gently for a few moments, season, then share between four warm plates or bowls.
5. Serve at once, with the freshly grated Parmigiano Reggiano and basil leaves.
Cook’s tip: Make sure that there is extra Parmigiano Reggiano at the table!
Recipe Courtesy of Parmigiano Reggiano
, header=Preparation Time 5 mins
Cooking Time 15 mins
Serves 4
Difficulty Easy
, description=Luscious linguine tossed with wafer-thin slices of Parma ham and tender peas.
)
...
```