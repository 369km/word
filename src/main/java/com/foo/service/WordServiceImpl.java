package com.foo.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private Configuration configuration;

    @Override
    public void export() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "123456");
        map.put("style", "zhong");
        File file = new File("doc/test.doc");
        try {
            Template template = configuration.getTemplate("test.ftl");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            template.process(map, writer);
            writer.flush();
            writer.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
