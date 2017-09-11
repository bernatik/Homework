package com.alexbernat.classwork17;

/**
 * Created by Александр on 11.09.2017.
 */
public class Rest {

    private OkHttp okHttp;
    private Gson gson;

    public Rest(OkHttp okHttp, Gson gson) {
        this.okHttp = okHttp;
        this.gson = gson;
    }
}
