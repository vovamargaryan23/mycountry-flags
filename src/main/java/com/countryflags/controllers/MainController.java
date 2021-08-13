package com.countryflags.controllers;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/")
public class MainController {


    @GetMapping("/countries/{countryName}")
    public String getCountryFlag(@PathVariable("countryName") String countryName) throws IOException {
        URL url = new URL( "https://restcountries.eu/rest/v2/name/"+ countryName + "?fields=flag" );
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String res = "";
        res = in.readLine();
        in.close();
        res = res.replaceAll("[\\[\\](){}]","");
        if(res.contains(",")){
            return res.substring(0,res.indexOf(","));
        }
        return res;
}
}
