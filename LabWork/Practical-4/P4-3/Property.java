interface Property {
    int computePrice();
}

class Flat implements Property {
    String name;
    int constructionArea;

    Flat(String name, int constructionArea) {
        this.name = name;
        this.constructionArea = constructionArea;
    }

    public int computePrice() {
        int constructionCost = constructionArea * 500;
        int additionalCost = 200000;
        return constructionCost + additionalCost;
    }
}

class Bungalow implements Property {
    String name;
    int constructionArea;
    int landArea;

    Bungalow(String name, int constructionArea, int landArea) {
        this.name = name;
        this.constructionArea = constructionArea;
        this.landArea = landArea;
    }

    public int computePrice() {
        int constructionCost = constructionArea * 500;
        int additionalCost = landArea * 200;
        int landCost = landArea * 400;
        return constructionCost + additionalCost + landCost;
    }
}
