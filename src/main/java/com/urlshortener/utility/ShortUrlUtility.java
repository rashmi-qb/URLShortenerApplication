package com.urlshortener.utility;

public class ShortUrlUtility {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int    BASE     = ALPHABET.length();

    public static String idToShortURL(int n)
    {
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();
        while (n > 0)
        {
            shorturl.append(map[n % 62]);
            n = n / 62;
        }
        return shorturl.reverse().toString();
    }

    public static Integer shortUrlToId(String url)
    {   int num = 0;
        for ( int i = 0; i < url.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(url.charAt(i));
        return num;

    }
}
