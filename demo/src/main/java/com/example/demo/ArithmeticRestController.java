package com.example.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class ArithmeticRestController {


    @GetMapping(path = "/{operation}")
    public String operation(@PathVariable String operation, @RequestParam(name = "a") int a, @RequestParam(name = "b") int b){
        return  calculate(operation,a ,b);
    }

    public String calculate(String operation, int a, int b) {
        if(operation.equals("add"))return String.valueOf(a+b);
        if(operation.equals("mult"))return String.valueOf(a*b);
        if(operation.equals("subtract"))return String.valueOf(a-b);
        return "Unknown operation";
    }

    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getWebCode(){
        String code = "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                "public static void main(String[] args) {\n" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                "}</pre>\n" +
                "</body>\n" +
                "</html>";
        return code;
    }


}
