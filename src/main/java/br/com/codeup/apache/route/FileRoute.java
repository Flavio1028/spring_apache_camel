package br.com.codeup.apache.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileRoute extends RouteBuilder {

    private String path = "C:\\Users\\flavio.vaz.da.rocha\\Documents\\_apache\\";

    @Override
    public void configure() throws Exception {

        from("file://" + path + "input")
                .log("${file:name}")
                .bean("fileComponent")
                .to("file://" + path + "output");

    }
}

@Component
class FileComponent {

    public void log(File file) {
        System.out.println("fileComponent " + file.getName());
    }

}