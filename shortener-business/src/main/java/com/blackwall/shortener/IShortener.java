package com.blackwall.shortener;

import com.blackwall.shortener.model.ShortLink;

/**
 * 
 * @author hraf
 *
 * @param <SHORT_URL>
 */
public interface IShortener<SHORT_URL extends ShortLink>
{

    /**
     *
     * @param longURL
     * @return
     */
    SHORT_URL shorten(String longURL) throws Exception;
}
