package com.nazkord.fetchers;

public abstract class Fetcher {

    private String fetcherOptionName;

    public Fetcher(String fetcherOption) {
        this.fetcherOptionName = fetcherOption;
    }

    public String getFetcherOptionName() {
        return fetcherOptionName;
    }

    public abstract void fetch(String[] optionValues);
}
