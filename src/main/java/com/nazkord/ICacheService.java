package com.nazkord;

public interface ICacheService {
    boolean createCacheFile();
    boolean checkCacheFile(String requestURL);
}
